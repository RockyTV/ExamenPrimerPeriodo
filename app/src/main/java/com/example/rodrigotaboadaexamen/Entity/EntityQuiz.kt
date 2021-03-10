package com.example.rodrigotaboadaexamen.Entity

data class EntityQuiz(

    var Edad: String,
    var gender:Int,
    var bodytype:String,
    var muscle:Boolean,
    var Resistence:Boolean,
    var tone:Boolean,
    var pay:Boolean,
    var email:String
)
{
    constructor():this("",0,"",false,false,false, false,"")

}
