//
//  ChatKitView.swift
//  iosApp
//
//  Created by Koji Osugi on 14/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ChatKitWrapperView: View {
    
    let chatKitFactory: ChatBotFactory
    
    @Environment(\.dismiss)
    private var dismiss
    
    var body: some View {
        ComposeView(chatKitFactory: chatKitFactory)
            .applyToolbar(
                logo: chatKitFactory.logo(),
                background: chatKitFactory.toolbarColor(),
                backButtonColor: chatKitFactory.toolbarBackButtonColor(),
                onBackClick: { dismiss() }
            )
    }
}
