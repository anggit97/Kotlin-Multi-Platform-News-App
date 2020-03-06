//
//  ContentView.swift
//  example
//
//  Created by Anggit Prayogo on 3/6/20.
//  Copyright © 2020 Anggit Prayogo. All rights reserved.
//

import SwiftUI
import SharedCode

struct ContentView: View {
    var body: some View {
        Text(CommonKt.createApplicationScreenMessage())
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
