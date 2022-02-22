package com.maatayim.koren.ui.base.list

interface BaseListItem<T> {
    fun areItemsTheSame(newItem: T): Boolean
    fun isContentTheSame(newItem: T): Boolean
}