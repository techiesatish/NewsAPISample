package com.reposenergy.listeners

import com.reposenergy.data.models.Article

interface OnNewsItemClick {
    fun onNewsItemClick(newsItemData:Article)
}