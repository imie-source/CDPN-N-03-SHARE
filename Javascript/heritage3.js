


function test(){

function ObjPere(param){// la forme ObjPere=function() ne fonctionne pas
 this.attr=param;
}
ObjPere.prototype.maFonctionPere = function(){
  console.log("père : attribut : "+this.attr);
};

function Obj(param){
 //execution du constructeur père
 //héritage du comportement défini dans le constructeur
 ObjPere.call(this,param);//super(param)
}

//facile mais incohérent
Obj.prototype=new ObjPere(1);
//constructor ObjPere->Obj : incohérence
Obj.prototype.constructor= Obj;

//ajout des spécificité du prototype fils
Obj.prototype.maFonction=function(){
 console.log("fils : attribut : "+this.attr);
};


var o = new Obj(3);
 o.maFonction();
 o.maFonctionPere();
}
