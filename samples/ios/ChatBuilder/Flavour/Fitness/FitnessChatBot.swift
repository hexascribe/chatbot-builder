//
//  FitnessChatBot.swift
//  ios
//
//  Created by Koji Osugi on 19/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import ChatBotBuilder
import UIKit
import SwiftUI

class FitnessChatBot: ChatBotFactory {
    
    private let initialBotMessage = "Hello, I'm a fitness coach here to assist you with anything related to exercise, gym tips, and much more."
    
    private let preSeededMessages = "You are a helpful assistant fitness coach, ready to answer any questions related to fitness, including gym tips, exercises, and more."
    
    func factory() -> ChatBot {
        let primaryColor = UIColor(Color.fitness)
        let colors = ChatBot.DarkColorsBuilder()
            .setBackgroundColor(color: UIColor(0x212121))
            .setInputFieldBackgroundColor(color: UIColor(0x424242))
            .setSendButtonColor(color: primaryColor)
            .setUserBalloonColor(color: primaryColor)
            .setSendButtonColor(color: primaryColor)
            .setUserBalloonTextColor(color: .white)
            .setInputFieldFocusedIndicatorColor(color: primaryColor)
            .setBotBalloonColor(color: UIColor(0x424242))
        
        return ChatBot.Builder(apiKey: Config.apiKey)
            .setDarkMode(isEnabled: true)
            .setDarkColorsBuilder(darkColorsBuilder: colors)
            .addMessage(role: .assistant, content: initialBotMessage)
            .addPreSeededMessage(role: .system, content: preSeededMessages)
            .build()
    }
    
    func toolbarTitle() -> String? {
        "Fitness Coach"
    }
    
    func toolbarColor() -> Color {
        Color(hex: 0x212121)
    }
}
