//
//  ChatKitView.swift
//  iosApp
//
//  Created by Koji Osugi on 14/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ChatKitWrapperView: View {
    
    private let chatKitFactory: ChatBotFactory
    
    private var bottomSafeAreaColor: Color
    
    @Environment(\.dismiss)
    private var dismiss
    
    init(chatKitFactory: ChatBotFactory, _ bottomSafeAreaColor: Color = .white) {
        self.chatKitFactory = chatKitFactory
        self.bottomSafeAreaColor = bottomSafeAreaColor
    }
    
    var body: some View {
        VStack(spacing: 0) {
            ComposeView(chatKitFactory: chatKitFactory)
                .applyToolbar(
                    logo: chatKitFactory.logo(),
                    title: chatKitFactory.toolbarTitle(),
                    background: chatKitFactory.toolbarColor(),
                    backButtonColor: chatKitFactory.toolbarBackButtonColor(),
                    onBackClick: { dismiss() }
                )
            bottomSafeAreaColor.frame(height: 20)
        }
        .edgesIgnoringSafeArea(.bottom)
    }
}
