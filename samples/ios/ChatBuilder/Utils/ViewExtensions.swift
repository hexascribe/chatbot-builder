//
//  ViewExtensions.swift
//  iosApp
//
//  Created by Koji Osugi on 14/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

extension View {
    
    func applyToolbar(
        logo: String,
        background: Color,
        backButtonColor: Color,
        onBackClick: @escaping () -> Void = {}
    ) -> some View {
        self
            .navigationBarBackButtonHidden(true)
            .toolbar {
                ToolbarItem(placement: .navigationBarLeading) {
                    HStack(spacing: 16) {
                        Button(action: { onBackClick() }) {
                            Image("ic_arrow_left")
                                .renderingMode(.template)
                                .tint(backButtonColor)
                        }
                        Image(logo)
                    }
                }
            }
            .toolbarBackground(.visible, for: .navigationBar)
            .toolbarBackground(background, for: .navigationBar)
    }
}
