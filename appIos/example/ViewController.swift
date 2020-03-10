//
//  ViewController.swift
//  example
//
//  Created by Anggit Prayogo on 3/9/20.
//  Copyright © 2020 Anggit Prayogo. All rights reserved.
//

import UIKit
import Shared

class ViewController: UIViewController, NewsView, UITableViewDelegate, UITableViewDataSource {
    
    
    func showLoading(visible: Bool) {
        
    }
    
    func onSuccessGetNews(data: NewsResponse) {
        if let data = data.articles as? [Article] {
            articles = data
            tableView.reloadData()
        }
        debugPrint(data)
    }
    
    func onErrorGetNews(exception: KotlinThrowable) {
        debugPrint(exception)
    }
    
    private let tableView = UITableView()
    private var articles: [Article] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.addSubview(tableView)
        tableView.translatesAutoresizingMaskIntoConstraints = false
        tableView.topAnchor.constraint(equalTo: view.safeAreaLayoutGuide.topAnchor).isActive = true
        tableView.bottomAnchor.constraint(equalTo: view.safeAreaLayoutGuide.bottomAnchor).isActive = true
        tableView.leadingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.leadingAnchor).isActive = true
        tableView.trailingAnchor.constraint(equalTo: view.safeAreaLayoutGuide.trailingAnchor).isActive = true
        
        tableView.delegate = self
        tableView.dataSource = self
        tableView.register(UITableViewCell.self, forCellReuseIdentifier: "cell")
        // Do any additional setup after loading the view.
        let injection = InjectionCommon()
        let presenter = injection.provideNewsPresenter()
        presenter.attachView(view: self)
        presenter.getNews(domain: "wsj.com,nytimes.com")
        debugPrint(NewsApi.Companion().token)
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return articles.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
        cell.textLabel?.text = articles[indexPath.row].title
        return cell
    }
}
