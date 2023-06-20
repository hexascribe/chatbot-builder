//
//  ChatKitFactory.swift
//  iosApp
//
//  Created by Koji Osugi on 14/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import ChatBotBuilder
import SwiftUI

protocol ChatBotFactory {
    
    func factory() -> ChatBot
    
    func logo() -> String?
    
    func toolbarTitle() -> String?
    
    func toolbarColor() -> Color
    
    func toolbarBackButtonColor() -> Color
}

extension ChatBotFactory {
    func toolbarBackButtonColor() -> Color {
        .white
    }
    
    func toolbarTitle() -> String? {
        nil
    }
    
    func logo() -> String? {
        nil
    }
}
