//
//  HealthChatBot.swift
//  ios
//
//  Created by Koji Osugi on 19/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import ChatBotBuilder
import UIKit
import SwiftUI

class HealthChatBot: ChatBotFactory {
    
    private let initialBotMessage = "Hi, I'm Health GPT, here to assist you. Feel free to ask me anything related to health, diet, and other related topics. I'll do my best to help you."
    
    private let preSeededMessages = "You are a helpful health assistant, capable of answering any questions related to health, diet, and other related topics."
    
    func factory() -> ChatBot {
        let primaryColor = UIColor(Color.health)
        let colors = ChatBot.DefaultColorsBuilder()
            .setSendButtonColor(color: primaryColor)
            .setUserBalloonColor(color: primaryColor)
            .setSendButtonColor(color: primaryColor)
            .setInputFieldFocusedIndicatorColor(color: primaryColor)
        
        return ChatBot.Builder(apiKey: Config.apiKey)
            .setDefaultColorsBuilder(defaultColorsBuilder: colors)
            .addMessage(role: .assistant, content: initialBotMessage)
            .addPreSeededMessage(role: .system, content: preSeededMessages)
            .build()
    }
    
    func toolbarTitle() -> String? {
        "Health Chat"
    }
    
    func toolbarColor() -> Color {
        .white
    }
    
    func toolbarBackButtonColor() -> Color {
        .black
    }
}
