package com.ubaya.adv160421013week6.model

data class Operator(
    var id:String?,
    var name:String?,
    var role:String?,
    var faction:Faction,
    var traits:ArrayList<String>,
    var images:String?
)

data class Faction(
    var name: String?,
    var position: String?,
)
