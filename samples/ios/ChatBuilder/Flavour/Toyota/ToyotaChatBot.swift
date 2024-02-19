//
//  ToyotaChatKit.swift
//  iosApp
//
//  Created by Koji Osugi on 15/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import ChatBotBuilder

class ToyotaChatBot: ChatBotFactory {
    
    private let initialBotMessage = "Hello there! Let me know what your budget is, if you want to buy or lease, and any other details that can help me find the perfect vehicle for you."
    
    private let preSeededMessages = "You are a helpful Toyota salesman. Your main goal is to find the best suitable vehicle for the customer. Answer as concisely as possible."
    
    func factory() -> ChatBot {
        let initialBotMessage = "Hello there! Let me know what your budget is, if you want to buy or lease, and any other details that can help me find the perfect vehicle for you."
        let preSeededMessages = "You are a helpful Toyota salesman. Your main goal is to find the best suitable vehicle for the customer. Answer as concisely as possible."
        let primaryColor = UIColor(Color.toyota)
        
        let defaultColors = ChatBot.DefaultColorsBuilder()
            .setInputFieldFocusedIndicatorColor(color: primaryColor)
            .setSendButtonColor(color: primaryColor)
        
        let chatbot = ChatBot.Builder(apiKey: Config.apiKey)
            .setDefaultColorsBuilder(defaultColorsBuilder: defaultColors)
            .setBotIcon(image: UIImage(named: "ic_toyota")!)
            .addMessage(role: .assistant, content: initialBotMessage)
            .addPreSeededMessage(role: .system, content: preSeededMessages)
            .setLogError(isEnabled: true)
            .build()
        return chatbot
    }
    
    func logo() -> String? {
        "logo_toyota"
    }
    
    func toolbarColor() -> Color {
        .white
    }
    
    func toolbarBackButtonColor() -> Color {
        .black
    }
}
