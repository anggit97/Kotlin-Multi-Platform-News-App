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
        window = UIWindow()
        window?.makeKeyAndVisible()
        window?.rootViewController = ViewController()
        return true
    }

}

