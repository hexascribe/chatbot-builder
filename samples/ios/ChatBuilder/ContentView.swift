import UIKit
import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        ZStack(alignment: .top) {
            ComposeView(chatKitFactory: WalmartHealthChatKit())
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
            GeometryReader { reader in
                Color(hex: 0x449fbc)
                    .frame(height: reader.safeAreaInsets.top, alignment: .bottom)
                    .ignoresSafeArea()
            }
        }
    }
}
