function tp1(){
 var a = prompt("saisir age");
 age=parseInt(a);
 var b;
 if(age<6){
  b="pas de catégorie";
 }else if(age <=7){
  b="Poussin"; 
 }else if(age <=9){
  b="Pupille"; 
 }else if(age <=11){
  b="Minime"; 
 }else{
  b="Cadet";
 }
 
 document.write(b);
}

function tp2(nbCopie){
 var tarif=0;
 var nbPhotocop1 = nbCopie<10?nbCopie:10;
 tarif+=nbPhotocop1*0.1;
 nbCopie-=nbPhotocop1;
 var nbPhotocop2 = nbCopie<20?nbCopie:20;
 tarif+=nbPhotocop2*0.08;
 nbCopie-=nbPhotocop2;
 tarif+=nbCopie*0.05;
 return tarif
}

function tp3(operande){
 var retour;
 if(operande==0){
  retour=1;
 }else{
  retour= operande * tp3(operande-1);
 }
 return retour;
}

function tp4(tableau){
 var sum=0;
 for(key in tableau){
  sum+=tableau[key];
 }
 return sum/tableau.length;
}

function tp5(tableau){
 for(var i=0; i < tableau.length-1; i++){
  for(var j= tableau.length-1 ; j >= i; j--){
   if(tableau[j]>tableau[j+1]){
    var tmp=tableau[j+1];
    tableau[j+1] = tableau[j];
    tableau[j]=tmp;
   }
  } 
 }
 return tableau;
}

function tp6(tableau){
 return tableau.sort(function(a,b){return a<b}); 
}

function tp7(tableau,fctAffichage){
 for(var i=0; i < tableau.length-1; i++){
  for(var j= tableau.length-1 ; j >= i; j--){
   if(parseInt(tableau[j])>parseInt(tableau[j+1])){
    var tmp=tableau[j+1];
    tableau[j+1] = tableau[j];
    tableau[j]=tmp;
   }
  }
  if(fctAffichage){
   fctAffichage(tableau); 
  }
 }
 return tableau;
}


var model=[];


function refreshDOM(){
 var container= document.getElementById('listValueToSort');
 while(container.firstChild){
  container.removeChild(container.firstChild);
 }
 for (key in model){
  addValueToSort(model[key]);
 }
}

function addValueToSort(valueToSort){

 var elmt = document.createElement('div');
 elmt.setAttribute('class','inlineElement');
 var text = document.createTextNode(valueToSort);
 
 var btnD = document.createElement('button');
 btnD.setAttribute('class','blockElement');
 btnD.setAttribute('data-position',model.indexOf(valueToSort));
 btnD.appendChild(document.createTextNode('<'));
 btnD.addEventListener('click',function(e){
  var position = e.target.getAttribute('data-position');
  position=parseInt(position);
  var tmp= model[position-1];
  if(position>0){
   model[position-1] = model[position];
   model[position]=tmp;
   refreshDOM();
  }
 });

 var btnU = document.createElement('button');
 btnU.setAttribute('class','blockElement');
 btnU.setAttribute('data-position',model.indexOf(valueToSort));
 btnU.appendChild(document.createTextNode('>'));
 btnU.addEventListener('click',function(e){
  var position = e.target.getAttribute('data-position');
  position=parseInt(position);
  if(position<model.length-1){
   var tmp= model[position+1];
   model[position+1] = model[position];
   model[position]=tmp;
   refreshDOM();
  }
 });

 elmt.appendChild(btnU);
 elmt.appendChild(text);
 elmt.appendChild(btnD);
 var container = document.getElementById('listValueToSort');
 container.appendChild(elmt);
 
}

function tp8(){
 document.getElementById('addValue').addEventListener(
  'click',
  function(e){
   //console.log('click');
   var valueToSort=document.getElementById('inputText').value;
   model.push(valueToSort);
   addValueToSort(valueToSort)
  }
 ); 
 document.getElementById('sortValue').addEventListener(
  'click',
  function(e){
   //console.log('click');
   var container= document.getElementById('sortedResult');
   while(container.rows[0]){
    container.deleteRow(0);
   }
   //Object.create() créé un objet dont le prototype est le paramètre
   tp7(Object.create(model),function(tab){
     console.log(tab);
     var row = container.insertRow(container.rows.length);
     for(key in tab){
      console.log(key);
      var cell=row.insertCell(key);
      cell.appendChild(document.createTextNode(tab[key]));
     }
   });
  }
 );
}

function Human(){this.speak = function(){ return "bonjour" } }
function Monster() {
 this.speak = function(){ return "grrrr" };
 this.manger= function(){ return "miam" }
}



function Hulk(){}

// hulk hérite de Human
console.log(Human.prototype);
Hulk.prototype = Object.create(Human.prototype)
Hulk.prototype.constructor=Hulk;
hulk1 = new Hulk()
console.log(hulk1.speak());		// "bonjour"

// hulk hérite Monster
Hulk.prototype =new Monster()//Object.create(Monster.prototype)
Hulk.prototype.constructor=Hulk;
hulk2 = new Hulk()
console.log(hulk2.speak());		// "grrrr"


console.log(hulk1);
console.log(hulk2);
console.log(hulk1.constructor);
console.log(hulk2.constructor);


// Attention:
console.log(hulk1.speak());		// "bonjour"
//Le changement de constructeur n’impacte pas les objets déjà créés 
//car la propriété prototype de hulk1 n’a pas été modifiée, 
//c’est le prototype du parent (Hulk) qui a été modifié.

hulk1.prototype = new Monster();
hulk1.speak()			// "bonjour"






























