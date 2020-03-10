//
//  ProfileViewController.swift
//  example
//
//  Created by Ahmad Raf Sanjani on 10/03/20.
//  Copyright © 2020 Anggit Prayogo. All rights reserved.
//

import UIKit
import Shared

class ProfileViewController: UIViewController, ProfileView {
  func showLoading(visibility: Bool) {
  }

  func onSuccessGetProfile(data: UserProfileResponse) {
    debugPrint(data)
  }

  func onErrorGetProfile(exception: KotlinThrowable) {
    debugPrint(exception.message as Any)
  }


  override func viewDidLoad() {
    super.viewDidLoad()

    // Do any additional setup after loading the view.
    let inject = InjectionCommon()
    let presenter = inject.provideProfilePresenter()
    presenter.attachView(view: self)
    presenter.getProfile()
  }


  /*
   // MARK: - Navigation

   // In a storyboard-based application, you will often want to do a little preparation before navigation
   override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
   // Get the new view controller using segue.destination.
   // Pass the selected object to the new view controller.
   }
   */

}
