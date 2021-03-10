package com.example.rodrigotaboadaexamen.Data

import com.example.rodrigotaboadaexamen.Entity.EntityQuiz
import com.example.rodrigotaboadaexamen.Entity.EntityUser

class ListUsers {
    companion object{
        private val listUser= arrayListOf<EntityUser>()
        private val listQuiz= arrayListOf<EntityQuiz>()
    }
    fun add(user: EntityUser):Int{
        var answer=-1
        if(!existEmailFilter((user.email))){
            listUser.add(user)
            answer=listUser.size-1
        }
        return answer
    }
    fun add2(quiz: EntityQuiz):Int{
            listQuiz.add(quiz)
            var answer= listQuiz.size-1
            return answer
    }
    fun existEmailFilter(email:String):Boolean{
        var answer:Boolean=false
        if(listUser.filter { e -> e.email==email }.count()==1){
            answer=true
        }
        return answer
    }
    fun getUser(id:Int):EntityUser{
        return listUser[id]
    }
    fun existsEmail(email:String): Int {
        var answer: Int=-1
        var count: Int=-1
        for(element in listUser){
            count=count+1
            if(element.email == email){
                answer = count
                break
            }
        }
        return answer
    }
    fun existsQuiz(email:String): Int {
        var answer: Int=-1
        var count: Int=-1
        for(element in listQuiz){
            count=count+1
            if(element.email == email){
                answer = count
                break
            }
        }
        return answer
    }
    fun getStringArrayQuiz():Array<String>{
        val answerList= arrayListOf<String>()
        for((index, item) in listQuiz.withIndex()){
            if(item.gender.equals(2)) {
                answerList.add(("${item.Edad} ${item.pay} ${item.bodytype} Masculino"))
            }
            if(item.gender.equals(1)) {
                answerList.add(("${item.Edad} ${item.pay} ${item.bodytype} Femenino"))
            }
        }
        return answerList.toTypedArray()
    }
    fun getQuiz(id:Int):EntityQuiz{
        return listQuiz[id]
    }
    fun delete(email:String):Boolean{
        var answer:Boolean=false
        for((index,item) in  listQuiz.withIndex()){
            if(item.email==email){
                listQuiz.removeAt(index)
                answer=true
                break
            }
        }
        return answer

    }

}