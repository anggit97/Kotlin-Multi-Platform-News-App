//
//  AppDelegate.swift
//  example
//
//  Created by Anggit Prayogo on 3/6/20.
//  Copyright © 2020 Anggit Prayogo. All rights reserved.
//

import UIKit
import Shared

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        NewsApi.Companion().invoke()
        NewsApi.Companion().token = "Anjing"
        NgampoozApi.Companion().invoke()
        NgampoozApi.Companion().token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvZGV2Lm5nYW1wb296LmNvbVwvYXBpXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU4MzgyNzE2NywiZXhwIjoxNTk5Mzc5MTY3LCJuYmYiOjE1ODM4MjcxNjcsImp0aSI6Ikt0UGhZc0g4dmdRRk1IbGkiLCJzdWIiOjEyOTI1NSwicHJ2IjoiODdlMGFmMWVmOWZkMTU4MTJmZGVjOTcxNTNhMTRlMGIwNDc1NDZhYSJ9.HaaYKA0EKTWwu5iIT0FTwvmWI7iO2KytKoIqT-Fw_-k"
        window = UIWindow()
        window?.makeKeyAndVisible()
        window?.rootViewController = ProfileViewController()
        return true
    }

}

