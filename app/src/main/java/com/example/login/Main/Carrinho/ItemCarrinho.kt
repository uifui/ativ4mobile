package com.example.login.Main.Carrinho

data class ItemCarrinho(
    val id: String,
    val nome: String,
    val preco: Double,
    var quantidade: Int,
    val imagem: Int
    //val imagemUrl: String usar dps no Banco
)
