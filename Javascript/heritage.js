


function test(){

// la forme ObjPere=function() ne fonctionne pas
//ATTENTION à vérifier
function ObjPere(param){
 this.attr=param;
 this.maFonctionPere = function(){
  console.log("père : attribut : "+this.attr);
 };
}

function Obj(param){
 //execution du constructeur père
 //héritage du comportement défini dans le constructeur
 ObjPere.call(this,param);
 this.maFonction = function(){
  console.log("fils : attribut : "+this.attr);
 };
}

//Obj.prototype=new ObjPere(2);
//Obj.prototype.constructor= Obj;//constructor ObjPere->Obj : incohérence

var o = new Obj(1);
o.maFonction();
o.maFonctionPere();
}
