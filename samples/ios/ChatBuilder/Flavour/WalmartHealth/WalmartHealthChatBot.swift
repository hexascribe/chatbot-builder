//
//  WalmartHealthChatKit.swift
//  iosApp
//
//  Created by Koji Osugi on 14/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import ChatBotBuilder
import UIKit
import SwiftUI

class WalmartHealthChatBot: ChatBotFactory {
    
    private let initialBotMessage = "Hello, here the GPT assistant from Walmart Health, how can I assist you today?"
    
    private let preSeededMessages = "You are a helpful chatbot from https://www.sutterhealth.org/ website. You will answer only questions related to healthcare such as workout routines, diet plans, health advice, etc.\nAnswer all questions in a super short and objective way"
    
    func factory() -> ChatBot {
        let primaryColor = UIColor(Color.walmartHealth)
        let defaultColors = ChatBot.DefaultColorsBuilder()
            .setInputFieldFocusedIndicatorColor(color: primaryColor)
            .setSendButtonColor(color: primaryColor)
        
        return ChatBot.Builder(apiKey: Config.apiKey)
            .setDefaultColorsBuilder(defaultColorsBuilder: defaultColors)
            .setBotIcon(image: UIImage(named: "ic_walmart")!)
            .addMessage(role: .assistant, content: initialBotMessage)
            .addPreSeededMessage(role: .system, content: preSeededMessages)
            .setLogError(isEnabled: true)
            .build()
    }
    
    func logo() -> String? {
        "logo_walmart"
    }
    
    func toolbarColor() -> Color {
        .walmartHealth
    }
}
