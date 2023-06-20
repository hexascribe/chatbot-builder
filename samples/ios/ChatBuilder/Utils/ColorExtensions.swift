//
//  ColorExtensions.swift
//  iosApp
//
//  Created by Koji Osugi on 14/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI

extension Color {
    init(hex: UInt, alpha: Double = 1) {
        self.init(
            .sRGB,
            red: Double((hex >> 16) & 0xff) / 255,
            green: Double((hex >> 08) & 0xff) / 255,
            blue: Double((hex >> 00) & 0xff) / 255,
            opacity: alpha
        )
    }
    
    static var health: Color {
        Color(hex: 0x3E6D49)
    }
    
    static var fitness: Color {
        Color(hex: 0x448AFF)
    }
    
    static var walmartHealth: Color {
        Color(hex: 0x449fbc)
    }
    
    static var toyota: Color {
        Color(hex: 0xE80C1C)
    }
}

extension UIColor {
    convenience init(_ hex: UInt, alpha: Double = 1) {
        let color = Color(hex: hex, alpha: alpha)
        self.init(color)
    }
}
