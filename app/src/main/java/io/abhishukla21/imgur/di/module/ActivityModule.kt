package io.abhishukla21.imgur.di.module

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import io.abhishukla21.imgur.repository.AuthRepository
import io.abhishukla21.imgur.ui.auth.LoginViewModel
import io.abhishukla21.imgur.ui.auth.LoginViewModelFactory
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    fun provideLoginViewModel(
        authRepository: AuthRepository,
        compositeDisposable: CompositeDisposable
    ): LoginViewModel = ViewModelProvider(activity, LoginViewModelFactory(authRepository, compositeDisposable))
        .get(LoginViewModel::class.java)


}