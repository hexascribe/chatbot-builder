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
        logo: String?,
        title: String?,
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
                        if let logo = logo {
                            Image(logo)
                        }
                        if let title = title {
                            Text(title)
                        }
                    }
                }
            }
            .toolbarBackground(.visible, for: .navigationBar)
            .toolbarBackground(background, for: .navigationBar)
    }
}
