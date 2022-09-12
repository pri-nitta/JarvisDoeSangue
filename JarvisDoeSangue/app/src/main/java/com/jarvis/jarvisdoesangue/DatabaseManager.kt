package com.jarvis.jarvisdoesangue

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context, name: String?) : SQLiteOpenHelper(context,name,null,1)  {

    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL("CREATE TABLE USUARIO(\n" +
                "\tID_USUARIO INT NOT NULL,\n" +
                "\tNOME VARCHAR(20),\n" +
                "\tEMAIL VARCHAR(20),\n" +
                "\tSENHA VARCHAR(20),\n" +
                "\tCPF VARCHAR(20),\n" +
                "\tDT_NASCIMENTO VARCHAR(20),\n" +
                "\tESTADO_CIVIL VARCHAR(20),\n" +
                "\tPESO INT(3),\n" +
                "\tALTURA INT(3),\n" +
                "\tTIPO_SANGUINEO VARCHAR(3),\n" +
                "\tTELEFONE VARCHAR(11),\n" +
                "\tCEP INT(8),\n" +
                "\tLOGRADOURO VARCHAR(20),\n" +
                "\tNUMERO VARCHAR(5),\n" +
                "\tCOMPLEMENTO VARCHAR(20),\n" +
                "\tBAIRRO VARCHAR(20),\n" +
                "\tESTADO VARCHAR(20),\n" +
                "\tCIDADE VARCHAR(20),\n" +
                "\tPRIMARY KEY (ID_USUARIO)\n" +
                "\t);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS USUARIO")

        p0?.execSQL("CREATE TABLE USUARIO(\n" +
                "\tID_USUARIO INT NOT NULL,\n" +
                "\tNOME VARCHAR(20),\n" +
                "\tEMAIL VARCHAR(20),\n" +
                "\tSENHA VARCHAR(20),\n" +
                "\tCPF VARCHAR(20),\n" +
                "\tDT_NASCIMENTO VARCHAR(20),\n" +
                "\tESTADO_CIVIL VARCHAR(20),\n" +
                "\tPESO INT(3),\n" +
                "\tALTURA INT(3),\n" +
                "\tTIPO_SANGUINEO VARCHAR(3),\n" +
                "\tTELEFONE VARCHAR(11),\n" +
                "\tCEP INT(8),\n" +
                "\tLOGRADOURO VARCHAR(20),\n" +
                "\tNUMERO VARCHAR(5),\n" +
                "\tCOMPLEMENTO VARCHAR(20),\n" +
                "\tBAIRRO VARCHAR(20),\n" +
                "\tESTADO VARCHAR(20),\n" +
                "\tCIDADE VARCHAR(20),\n" +
                "\tPRIMARY KEY (ID_USUARIO)\n" +
                "\t);")
    }

    fun insereUsuario(id: Int, name: String, email: String, password: String, cpf: String, birthday: String,
                      maritalStatus: String, weight: Int, height: Int, bloodType: String, telephone: String, zipCode: Int, street: String, number: Int, additionalData: String,
                      neighbourhood: String, city: String, state: String
    ){
        var db = this.writableDatabase

        var cv = ContentValues()

        cv.put("ID_USUARIO",id)
        cv.put("NOME",name)
        cv.put("EMAIL",email)
        cv.put("CPF",cpf)
        cv.put("SENHA",password)
        cv.put("DT_NASCIMENTO",birthday)
        cv.put("ESTADO_CIVIL",maritalStatus)
        cv.put("PESO",weight)
        cv.put("ALTURA",height)
        cv.put("TIPO_SANGUINEO",bloodType)
        cv.put("TELEFONE",telephone)
        cv.put("CEP",zipCode)
        cv.put("LOGRADOURO",street)
        cv.put("NUMERO", number)
        cv.put("COMPLEMENTO",additionalData)
        cv.put("BAIRRO",neighbourhood)
        cv.put("CIDADE",city)
        cv.put("ESTADO",state)

        db.insert("USUARIO","ID_USUARIO",cv)
    }

    fun listaUsuario(): Cursor {

        var db = this.readableDatabase
        var cur = db.rawQuery("select name, email, cpf from usuario",null)
        return cur
    }

    fun removeUsuario(){
        var db = this.writableDatabase
        db.delete("USUARIO","ID_USUARIO=1",null)
    }
}