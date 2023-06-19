//
//  ComposeView.swift
//  iosApp
//
//  Created by Koji Osugi on 14/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ComposeView: UIViewControllerRepresentable {
    
    let chatKitFactory: ChatBotFactory
    
    func makeUIViewController(context: Context) -> UIViewController {
        chatKitFactory.factory().getViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
