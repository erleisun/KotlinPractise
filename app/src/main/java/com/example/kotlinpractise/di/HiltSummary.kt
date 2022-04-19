package com.example.kotlinpractise.di

//hilt概述

//@HiltAndroidApp 触发代码生成
//@AndroidEntryPoint 创建一个依赖容器，该容器遵循Android的生命周期
//@Module 告诉hilt如何提供不同类型到实例
//@InstallIn 告诉hilt 这个模块会被安装到哪个组件上
//Providers 告诉hilt如何获取具体的实例
//@Singleton 单例
//@ViewModelInject 通过构造函数 给ViewModel注入实例