function tp1(){
 var obj = new Object();
 obj.nom='Medor';
 obj.afficher=function(){console.log(this.nom);};
 obj.afficher();

 var obj2={
  nom:'Kafy',
  afficher:function(){console.log(this.nom);}
 }
 obj2.afficher();

 function Chien(param){
  this.nom=param;
  this.afficher=function(){
   console.log(this.nom);
  }
 }
 var obj3 = new Chien('Rex');
 obj3.afficher();
}

function tp2(){
 function Chien(param){
  var nom=param;
  var afficher=function(){
   console.log(this.nom);
  }
 }
 var obj=new Chien('Rex');
 try{
  obj.afficher();
 }catch(e){
  console.log('exception lors de l\'acces à la methode afficher : '+e);
 }

 function Chat(param){
  var nom=param;
  this.afficher=function(){
   console.log(nom);
  }
 }
 var obj2=new Chat('Tipi');
 obj2.afficher();
}

function tp3(){
 function Chien(param){
  this.nom=param.nom||'valeur pas valuée';
  this.affichage=param.affichage||function(){console.log('methode non-implementée')};
 }
 var obj= new Chien({
   nom:'Sanna',
   affichage:function(){console.log(this.nom)}
  });
 obj.affichage();
}

function tp4(){
 function Chien(param){
 param=param||{}; 
 this.nom=param.nom||'valeur pas valuée';
 //this.affichage=param.affichage||function(){console.log('methode non-implementée')};
 }

 Chien.prototype.affichage=function(){console.log('methode non-implementée')};

 var obj2 = new Chien({
   nom:'Bramovic',
   affichage:function(){console.log(this.nom);}
 });

 Chien.prototype.affichage=function(){console.log('affiche2 : nom : '+this.nom)}; 

 //obj2.affichage2();
 obj2.affichage();

 Chien.prototype = {
  affichage3 : function(){console.log('affiche3 : nom : '+this.nom);}
 }  
 
 console.log(obj2);
 obj2.affichage3();

 var obj3 = new Chien();
 obj3.affichage3();
}

function tp5(){
 function affichage(texte,recepteur){
  console.log(this.nom +' dit : '+texte+' à '+recepteur.nom)
 }

 context1={nom:'liyron'};
 context2={nom:'titi'};

 affichage.apply(context1,['texte1',context2]);
 affichage.call(context2,'texte2',context1);

}

function tp6(){
 function createDelegate(fonc,context,params){
  return function(){
    fonc.apply(context,params)
   };
 }

 function affichage(texte,recepteur){
  recepteur = recepteur||'anomyme';
  console.log(this.nom +' dit : '+texte+' à '+recepteur.nom)
 }

 context1={nom:'liyron'};
 context2={nom:'titi'};
 var delegate = createDelegate(affichage,context1,['bonjour',context2]);
 

 delegate();
 
 
}

