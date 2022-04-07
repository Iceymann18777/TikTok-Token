/*
 * MIT License
 *
 * Copyright (c) 2021 Andre-max
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.andre_max.tiktokclone.presentation.ui.profile.with_account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.andre_max.tiktokclone.models.user.User
import com.andre_max.tiktokclone.repo.network.user.DefaultUserRepo
import com.andre_max.tiktokclone.utils.architecture.BaseViewModel
import kotlinx.coroutines.launch

class ProfileWithAccountViewModel: BaseViewModel() {
    private val userRepo = DefaultUserRepo()

    private val _profileUser = MutableLiveData<User>()
    val profileUser: LiveData<User> = _profileUser

    fun fetchUser(profileUid: String) {
        viewModelScope.launch {
            val user = userRepo.getUserProfile(profileUid).tryData() ?: return@launch
            _profileUser.value = user
        }
    }

}