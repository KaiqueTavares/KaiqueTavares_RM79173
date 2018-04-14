package br.com.kaiquetavaresreinodasilva.nacdado

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    var vitorias = 0
    var empates=0
    var derrotas =0

    private var d1 =1
    private var d2 =2
    private var d3 =3
    private var d4 =4
    private var d5 =5
    private var d6 =6

    var numeroAleatorioPlayer:Random? = null
    var numeroAleatorioPc:Random? = null

    private fun realizarJogada (){
        var jogadaPC = numeroAleatorioPc!!.nextInt(6)+1
        var jogadaPlayer = numeroAleatorioPlayer!!.nextInt(6)+1

        when (jogadaPC){
            d1 ->{
                ivPC!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice01))
            }
            d2 ->{
                ivPC!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice02))
            }
            d3 ->{
                ivPC!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice03))
            }
            d4 ->{
                ivPC!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice04))
            }
            d5 ->{
                ivPC!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice05))
            }
            d6 ->{
                ivPC!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice06))
            }
        }

        when (jogadaPlayer){
            d1 -> {
                ivPlayer!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice01))
                when (jogadaPC){
                    d1 -> empate()
                    d2 -> venceu()
                    d3 -> venceu()
                    d4 -> venceu()
                    d5 -> venceu()
                    d6 -> venceu()
                }
            }
            d2 -> {
                ivPlayer!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice02))
                when (jogadaPC){
                    d1 -> perdeu()
                    d2 -> empate()
                    d3 -> venceu()
                    d4 -> venceu()
                    d5 -> venceu()
                    d6 -> venceu()
                }
            }
            d3 -> {
                ivPlayer!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice03))
                when (jogadaPC){
                    d1 -> perdeu()
                    d2 -> perdeu()
                    d3 -> empate()
                    d4 -> venceu()
                    d5 -> venceu()
                    d6 -> venceu()
                }
            }
            d4 -> {
                ivPlayer!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice04))
                when (jogadaPC){
                    d1 -> perdeu()
                    d2 -> perdeu()
                    d3 -> perdeu()
                    d4 -> empate()
                    d5 -> venceu()
                    d6 -> venceu()
                }
            }
            d5 -> {
                ivPlayer!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice05))
                when (jogadaPC){
                    d1 -> perdeu()
                    d2 -> perdeu()
                    d3 -> perdeu()
                    d4 -> perdeu()
                    d5 -> empate()
                    d6 -> venceu()
                }
            }
            d6 -> {
                ivPlayer!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dice06))
                when (jogadaPC){
                    d1 -> perdeu()
                    d2 -> perdeu()
                    d3 -> perdeu()
                    d4 -> perdeu()
                    d5 -> perdeu()
                    d6 -> empate()
                }
            }
        }
    }

    private fun venceu (){
        vitorias ++
        tvVitoria.text = vitorias.toString()
    }

    private fun perdeu (){
        derrotas ++
        tvVitoria.text = derrotas.toString()
    }

    private fun empate (){
        empates ++
        tvVitoria.text = empates.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        numeroAleatorioPlayer = Random()
        numeroAleatorioPc = Random()

        btPlay.setOnClickListener{
            realizarJogada()
        }



    }
}
