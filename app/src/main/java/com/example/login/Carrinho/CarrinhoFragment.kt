package com.example.login.Carrinho

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.login.databinding.FragmentCarrinhoBinding

import java.text.NumberFormat
import java.util.Locale

interface CarrinhoActionsListener {
    fun onRemoverItem(position: Int)
}

class CarrinhoFragment : Fragment(), CarrinhoActionsListener {

    private var _binding: FragmentCarrinhoBinding? = null
    private val binding get() = _binding!!

    private lateinit var carrinhoAdapter: CarrinhoAdapter
    private val listaItens = mutableListOf<ItemCarrinho>()

    // *** REMOVIDO: TotalUpdateListener e onAttach ***
    // Motivo: A atualização do total está agora DENTRO do Fragment.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarrinhoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inicializa a lista de dados
        listaItens.add(ItemCarrinho("1", "Bolo Red Velvet", 50.00, 1, 3))
        listaItens.add(ItemCarrinho("2", "Brigadeiro de morango", 9.00, 1, 3))

        // 2. Cria e INICIALIZA a instância do seu adapter
        carrinhoAdapter = CarrinhoAdapter(listaItens, this)

        // 3. Configura a RecyclerView
        binding.rvCarrinhoItens.layoutManager = LinearLayoutManager(context)
        binding.rvCarrinhoItens.adapter = carrinhoAdapter

        // 4. Lógica de clique de adição (o botão está no layout do Fragment)
        // OBS: Se o botão 'btn_add_item_teste' estiver no Fragment:
        binding.btnAddItemTeste.setOnClickListener { // Usamos binding diretamente
            val novoItem = ItemCarrinho(
                id = "ID_${System.currentTimeMillis()}",
                nome = "Item Adicionado (TESTE)",
                preco = 10.00,
                quantidade = 1,
                imagem = 3
            )

            carrinhoAdapter.adicionarItem(novoItem)

            // ATUALIZA O TOTAL VISUALMENTE DENTRO DO PRÓPRIO FRAGMENT
            atualizarTotalNaTela()
        }

        // 5. Lógica de clique para Comprar
        binding.btnComprar.setOnClickListener {
            // Aqui você pode notificar a Activity para iniciar o processo de checkout.
            // Exemplo de como notificar a Activity:
            (activity as? ComprarActionListener)?.onComprarClicked(calcularTotal())
        }


        // CÁLCULO INICIAL: Envia o total na primeira vez que o Fragment é carregado
        atualizarTotalNaTela()
    }

    // Implementação da função da Interface CarrinhoActionsListener
    override fun onRemoverItem(position: Int) {
        // 1. Executa a remoção no Adapter
        carrinhoAdapter.removerItem(position)

        // 2. ATUALIZA O TOTAL VISUALMENTE DENTRO DO PRÓPRIO FRAGMENT
        atualizarTotalNaTela()
    }

    // Função para calcular o total
    private fun calcularTotal(): Double {
        // Usa a lista de dados do Adapter, que é a mesma listaItens
        return listaItens.sumOf { it.preco * it.quantidade }
    }

    // Função para ATUALIZAR as TextViews (total e total_title)
    private fun atualizarTotalNaTela() {
        val novoTotal = calcularTotal()
        val totalItens = listaItens.size

        // 1. Configuração do formatador de moeda
        val formatador = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

        // 2. ATUALIZAÇÃO DO TOTAL USANDO BINDING (Views no Fragment)
        binding.total.text = formatador.format(novoTotal)

        // 3. ATUALIZAÇÃO DA CONTAGEM DE ITENS USANDO BINDING
        binding.totalTitle.text = "Total ($totalItens)"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

/*
    *** NOTA SOBRE COMUNICAÇÃO (OPCIONAL) ***
    Se você precisar que a Activity saiba quando o botão "Comprar" foi clicado,
    você ainda precisa de uma interface, mas com um propósito diferente:
*/
interface ComprarActionListener {
    fun onComprarClicked(total: Double)
}

// REMOVA a interface TotalUpdateListener do seu projeto se usar esta solução.