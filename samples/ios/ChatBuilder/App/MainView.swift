//
//  MainView.swift
//  iosApp
//
//  Created by Koji Osugi on 14/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct MainView: View {
    
    @State
    private var showWalmartHealthChat: Bool = false
    
    @State
    private var showToyotaChat: Bool = false
    
    var body: some View {
        NavigationStack {
            VStack {
                Text("ChatBot SDK Sample")
                    .padding(.bottom, 24)
                button(
                    text: "Walmart Health",
                    backgroundColor: Color.walmartHealth,
                    onAction: { showWalmartHealthChat.toggle() }
                )
                button(
                    text: "Toyota",
                    backgroundColor: Color.toyota,
                    onAction: { showToyotaChat.toggle() }
                )
                Spacer()
            }
            .padding(24)
            .navigationDestination(isPresented: $showWalmartHealthChat) {
                ChatKitWrapperView(chatKitFactory: WalmartHealthChatBot())
            }
            .navigationDestination(isPresented: $showToyotaChat) {
                ChatKitWrapperView(chatKitFactory: ToyotaChatBot())
            }
        }
    }
}

extension MainView {
    
    @ViewBuilder
    func button(
        text: String,
        backgroundColor: Color = .blue,
        foregroundColor: Color = .white,
        onAction: @escaping () -> Void
    ) -> some View {
        Button(action: { onAction() }) {
            Text(text.capitalized)
                .foregroundColor(foregroundColor)
                .font(.system(size: 16))
                .fontWeight(.semibold)
                .frame(minWidth: 0, maxWidth: .infinity)
                .padding()
        }
        .background(backgroundColor)
        .cornerRadius(8)
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
