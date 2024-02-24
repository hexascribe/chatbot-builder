//
//  Config.swift
//  iosApp
//
//  Created by Koji Osugi on 14/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

enum Config {
    static var apiKey: String {
        if let path = Bundle.main.path(forResource: "Info", ofType: "plist") {
            if let configDict = NSDictionary(contentsOfFile: path) as? [String: Any] {
                return configDict["API_KEY"] as? String ?? ""
            }
        }
        return ""
    }
}
