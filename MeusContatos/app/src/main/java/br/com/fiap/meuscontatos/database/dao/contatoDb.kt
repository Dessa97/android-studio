package br.com.fiap.meuscontatos.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.meuscontatos.model.Contato

@Database(entities = [Contato::class], version = 1)
abstract class ContatoDb : RoomDatabase() {

    abstract fun contatoDao(): ContatoDao
    //Essa função é necessária p/ temos acesso aos métodos CRUD nela descritos

    companion object {

        private lateinit var instance: ContatoDb

        fun getDatabase(context: Context): ContatoDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        ContatoDb::class.java,
                        "contato_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
            //A função "getDataBase" e o atributo "instance" se encontram dentro de um bloco
            //"companion object", que as torna estaticas. Fazemos isso para aplicar o concei-
            //to de "singleton" no retorno da função "getDataBase", para garantir que sempre
            //entregaremos ao consumidor dessa classe uma unica instancia do banco de dados.
            //Isso garante consistencia e economia de recursos do dispositivo do usuario.
        }
    }
}
