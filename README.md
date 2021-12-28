# LiveDataDemo

* ViewModel
O ViewModel armazena e gerencia os dados relacionado a interface do usuário.
Para que isso seja possível, ele considera o ciclo de vida dos componentes. (Activity, Fragment e Service)
O ViewModel mantém os dados independente do estado dos componentes.
Para saber mais https://developer.android.com/topic/libraries/architecture/viewmodel

* LiveData
O LiveData é uma classe armazenadora de dados observáves.
Para que isso seja possível, ele considera o ciclo de vida dos componentes. (Activity, Fragment e Service)
Isso garante que os dados sejam atualizados assim que ouver mudanças.
Ressaltando que tal ação reflete apenas nos observadores.
Sendo assim, é possível atualizar a interface do usuário e deixar síncrono com as mudanças.
Para saber mais https://developer.android.com/topic/libraries/architecture/livedata?hl=pt-br

* Overview
Se considerarmos a demonstração, veremos um contador no qual é armazenado em um LiveData e refletido a UI através do observador.
Ao rotacionar a tela, veremos o ViewModel em ação, pois os dados se manterão.
Isso só ocorre por que no momento em que o componente for destruido, o ViewModel "desaclopa" e mantém os dados. 
