
angular.module("mainApp" , ["ngResource","ngSanitize","pascalprecht.translate","angularjs-datetime-picker","textAngular","keren.core.calendar","keren.core.discussion","keren.core.commons"]);        
//Regle de traduction 
angular.module("mainApp").config(['$translateProvider',
    function($translateProvider){
        
        $translateProvider.translations('en',{
            Creer:'Create',
            Dupliquer:'Duplicate',
            Importer:'Import',
            Imprimer:'Print',
            Filtres:'Filter',
            Quitter:'Exit',
            PJ:'Attachement(s)',
            Actions:'Actions',
            Enregistrer:'Save',
            Ajouter:'Add',
            Exporter:'Export',
            Modifier:'Update',
            Supprimer:'Delete',
            Administration:'Administration',
            Discussion:'Discuss',
            Calendrier:'Calendar',
            Applications:'Applications',
            Configuration:'Configuration',
            Documentation:'Documentation',
            Assistance:'Assistance',
            Préference:'Preference',
            UPPWD:'Change the Password',
            Déconnexion:'Log out',
            MAIL:'Mailbox',
            Conversation:'Tchat',
            Administrateur:'Administrator',
            EVENTTITLE:'Event Title',
            Participants:'Participants',
            EVENTDATE:'Event date',
            Options:'Options',
            Nom:'Name',
            EMAIL:'Mail adrdress',
            Socièté:'Partner',
            Description:'Description',
            BEGINDATETIME:'Start date and time',
            Rappels:'Reminders',
            Confidentialite:'Privacy',
            ALLPEOPLE:'Everybody',
            ONLYME:'Only me',
            INNERONLY:'Internal user only',
            SHOWHOURS:'Show time as',
            Libre:'Free',
            Occupé:'Occupied',
            Duree:'Duration',
            CALENDAROPTIONS:'Calendar options',
            ADDELEMENT:'Add an element',
            MISEAJOUR:'Update applcations list',
            Utilisateurs:'Users',
            Groupes:'Groups',
            Societes:'Companies',
            Pays:'Country',
            Traductions:'Translations',
            Langues:'Languages',
            CANAUX:'Communication channels',
            Technique:'Technical',
            MENUGROUP:'Menu Elements',
            MENUACTION:'Actions Menu',
            FORMVIEW:'Form Views',
            LISTVIEW:'List Views',
            CALENDARVIEW:'Calendar Views',
            DASHBORDVIEW:'Dashboards',
            Editique:'Editique',
            TERME:'Translated terms',
            EXPORTBD:'Export schema',
            DBSAVE:'Backup Data', 
            CALENDAR_DESC:'Event Management',
            APPLI_DESC:'Application Management',
            CONFIG_DESC:'Platform Administration',
            DISCUSION_DESC:'Collaborative platform',
            IMPORTDATA:'Import data to CVS format',
            Statut:'Status',
            Champ:'Field',
            Obligatoire:'Mandatory',
            EXPORTDATA:'Data export',
            Fermer:'Close',
            VALIDATETITRE:'Validation report',
            Ligne:'Line',
            Valeur:'Value',
            Valider:'Validate',
            Impimer:'Print',
            Annuler:'Cancel',
            Voir:'Display'
        });
        $translateProvider.translations('fr',{
            PJ:'Pièce(s) Jointe(s)',
            UPPWD:'Modifier le Mot de passe',
            MAIL:'Boîte de reception',
            EVENTTITLE:'Titre evenement',
            EVENTDATE:'Date evenement',
            EMAIL:'Adresse mail',
            BEGINDATETIME:'Date et heure de debut',
            ALLPEOPLE:'Tout le monde',
            ONLYME:'Moi seulement',
            INNERONLY:'Utilisateur interne seulement',
            SHOWHOURS:'Afficher heure comme',
            CALENDAROPTIONS:'Options du calendrier',
            ADDELEMENT:'Ajouter un element',
            MISEAJOUR:'Mise à jour',
            CANAUX:'Canaux de communication',
            MENUGROUP:'Menu Elements',
            MENUACTION:'Menus Action',
            FORMVIEW:'Vues Formulaire',
            LISTVIEW:'Vues Liste',
            CALENDARVIEW:'Vues Calendaires',
            DASHBORDVIEW:'Tableaux de bord',
            TERME:'Termes traduits',
            EXPORTBD:'Exporter le schema',
            DBSAVE:'Sauvegarde Données' ,
            CALENDAR_DESC:'Gestion des évènements',
            APPLI_DESC:'Gestion des Applications',
            CONFIG_DESC:'Administration de la plateforme',
            DISCUSION_DESC:'Plateforme collaborative',
            IMPORTDATA:'Importer les données au format CVS',
            VALIDATETITRE:'Compte rendu validation'
        });
        $translateProvider.preferredLanguage('fr');
    }]);
//Creation du controleur
angular.module("mainApp")
.controller("mainCtrl" , function($scope ,$rootScope,$translate,$http,$location,$filter, $compile,$timeout,commonsTools,restService){
    $scope.desablecreate = false;    
    $scope.desableupdate = false;
    $scope.desabledelete = false;
    $scope.desableprint = false;
    $scope.desablecreateedit = false;
    $scope.desableupdateedit = false;
    $scope.desabledeleteedit = false;
    $scope.desableprintedit = false;
    $scope.hideactionsmenu = false;
    $scope.showpjmenu = false;
   //Pour module Calendrier
     $scope.showCalendar = false;
    //Hide the discussion
    $scope.showDiscussion = false;
    //Hide the discussion
    $scope.hideOther = false;
    //Label Exporter 
    $scope.exportbtnlabel = 'Exporter'; 
    //Label Update 
    $scope.updatebtnlabel = 'Modifier'; 
    //Label Exporter 
    $scope.deletebtnlabel = 'Supprimer'; 
    //Module courant = application
    $scope.showApplication = false;
    //Hide Discussion login , calendar ,discussion ,others
    $scope.moduleValue = "login";
    //Number de messages
    $scope.numberofnewmessages = 0;
    $scope.numberofconnectusers = 0;
    //List of available users and canal
    $scope.tchatinput = new Array();   
    $scope.hostname = $location.host();    
    $scope.portvalue = $location.port();
    $scope.protocol = $location.protocol(); 
   //Utilisateur courant
   $scope.agendaModule = { id:-1 , name:"discussionconf",label:"Discussion",selected:false,hasmenu:false,
                          groups:[
                                                      
                          ]

               };
    $scope.calandarModule = { id:-1 , name:"calandar",label:"Agenda",selected:false,hasmenu:false,
              action:{id:-1,name:"events" , label:"Evenement",icon:"glyphicon glyphicon-user",entityName:"Event",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',hide:false,viewMode:'form'}

   };
   /**
       Structure du module de configuration
   **/
   $scope.configurationModule = { id:-1 , name:"configuration",label:"Configuration",selected:false,hasmenu:true,
                 groups:[
                      {id:-1 , name:"utilisateurs",label:"Utilisateurs",icon:"glyphicon glyphicon-user" ,showmenu:true,
                       actions:[
                          {id:-1,name:"utilisateur" , label:"Utilisateurs",icon:"glyphicon glyphicon-user",entityName:"Utilisateur",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',hide:false,viewMode:'kaban,tree,form'
                              ,kaban:{code:"application_001",script:"<div class='col-md-12 col-sm-12' id='detail-panel-body-header'> <div class='col-md-3 col-sm-4'> <div id='imageContent'  style='float: left;margin-left: -20px;'> <img id='apercuImageContent' src='http://{{hostname}}:{{portvalue}}/keren/auth/resource/static/{{item.image }}' alt='Image ' ng-click='imageClick()' height='70' width='75'></div> </div> <div  class='col-md-8 col-sm-7'> <div style='font-weight: bold;'>{{item.designation}}</div> <div>{{item.courriel | cut:true:50:'...'}}</div> <div> <div class='col-sm-6 col-md-6 pull-left' >{{item.societe.designation}}</div></div> </div> </div>"}},
                          {id:-2,name:"groupes" , label:"Groupes",icon:"glyphicon glyphicon-list-alt",entityName:"Groupe",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',hide:false},
                          {id:-3,name:"societe" , label:"Societes",icon:"glyphicon glyphicon-home",entityName:"Societe",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',hide:false},
                          {id:-4,name:"pays" , label:"Pays",icon:"glyphicon glyphicon-flag",entityName:"pays",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',hide:false}
                       ]},
                       { id:-2 , name:"traduction" , label:"Traductions",icon:"glyphicon glyphicon-book" ,showmenu:true,
                         actions:[{id:-1,name:"langues" , label:"Langues",icon:"glyphicon glyphicon-bullhorn",entityName:"Langue",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',hide:false},
//                                  {id:-2,name:"chargelangue" , label:"Charger une traduction",icon:"glyphicon glyphicon-saved",entityName:"ChargerLangue",moduleName:"kerencore",modal:true,securitylevel:0,model:'kerencore'},
                                  ,{id:-3,name:"traduction" , label:"TERME",icon:"glyphicon glyphicon-globe",entityName:"Terme",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',hide:false,viewMode:'tree'}
                                  //{id:4,name:"exportertraduction" , label:"Exporter une traduction",icon:"glyphicon glyphicon-user",entityName:null,moduleName:"kerencore",modal:false}
                         ]},
                         {id:-4 , name:"discussion_conf",label:"Discussion",icon:"glyphicon glyphicon-th",showmenu:true,
                                actions:[
                                   {id:-100,name:"show_canal_discussion" , label:"CANAUX",icon:"glyphicon glyphicon-th",entityName:"Canal",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',hide:false}
//                                   {id:-2,name:"application_update" , label:"Mise a jour",icon:"glyphicon glyphicon-refresh",entityName:"MenuModule",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore'}                          
                           ]},
                       {id:-3 , name:"techniques",label:"Technique",icon:"glyphicon glyphicon-cog", showmenu:true,
                       actions:[
                          {id:-1,name:"actionsdb" ,hide:false, label:"Actions",icon:"glyphicon glyphicon-th",entityName:"ActionItem",moduleName:"kerencore",modal:false,securitylevel:2,model:'kerencore'},
                          {id:-2,name:"menu" ,hide:false, label:"MENUGROUP",icon:"glyphicon glyphicon-th",entityName:"MenuGroupActions",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore'},
                          {id:-3,name:"actions" ,hide:false, label:"MENUACTION",icon:"glyphicon glyphicon-align-center",entityName:"MenuAction",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore'},
                          {id:-4,name:"formview" ,hide:false, label:"FORMVIEW",icon:"glyphicon glyphicon-list-alt",entityName:"FormRecord",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore'},
                          {id:-5,name:"treeview" ,hide:false, label:"LISTVIEW",icon:"glyphicon glyphicon-align-justify",entityName:"TreeRecord",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore'},
                          {id:-6,name:"calendarview" ,hide:false, label:"CALENDARVIEW",icon:"glyphicon glyphicon-align-justify",entityName:"CalendarRecord",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore'},
                          {id:-7,name:"dashboardview" ,hide:false, label:"DASHBORDVIEW",icon:"glyphicon glyphicon-align-justify",entityName:"DashboardRecord",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore'},
                          {id:-8,name:"reportview" ,hide:false, label:"Editique",icon:"glyphicon glyphicon-align-justify",entityName:"ReportRecord",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore'}
                       ]},
                       {id:-5 , name:"sauvegarde_conf",label:"DBSAVE",icon:"glyphicon glyphicon-hdd",showmenu:true,
                           actions:[
                              {id:-100,name:"progra_save" ,hide:false, label:"Configuration",icon:"glyphicon glyphicon-time",entityName:"Export",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',viewMode:'form'},
                              {id:-2,name:"export_bd" ,hide:false, label:"EXPORTBD",icon:"glyphicon glyphicon-save-file",entityName:"Export",moduleName:"kerencore",modal:true,securitylevel:0,model:'kerencore'}                          
                       ]}
                 ]

      };
     
   /**
       Structure du module de configuration
   **/
   $scope.applicationsModule = { id:-1 , name:"application",label:"Applications",selected:false,hasmenu:true,
                 groups:[
                      {id:-1 , name:"application",label:"Applications",icon:"glyphicon glyphicon-th",showmenu:true,
                       actions:[
                          {id:-1,name:"applications" ,hide:false, label:"Applications",icon:"glyphicon glyphicon-th-list",entityName:"MenuModule",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',viewMode:'kaban,tree,form'
                              ,kaban:{code:"application_001",script:"<div class='col-md-12 col-sm-12' id='detail-panel-body-header'> <div class='col-md-3 col-sm-4'> <div id='imageContent'  style='float: left;margin-left: -20px;'> <img id='apercuImageContent' src='{{protocol}}://{{hostname}}:{{portvalue}}/keren/auth/resource/static/{{item.icon}}' alt='Image ' ng-click='imageClick()' height='70' width='75'></div> </div> <div  class='col-md-8 col-sm-7'> <div style='font-weight: bold;'>{{item.designation | cut:true:20:'...'}}</div> <div>{{item.shortDescription | cut:true:50:'...'}}</div> <div> <div class='col-sm-6 col-md-6 pull-left' >{{item.autor}}</div> <div class='col-sm-6 col-md-6 pull-right'><a href='{{item.website}}'>{{item.name}}</a></div> </div> </div> </div>"}},
                          {id:-2,name:"application_update" ,hide:false, label:"MISEAJOUR",icon:"glyphicon glyphicon-refresh",entityName:"MenuModule",moduleName:"kerencore",modal:false,securitylevel:0,model:'kerencore',viewMode:'kaban,tree,form'
                              ,kaban:{code:"application_001",script:"<div class='col-md-12 col-sm-12' id='detail-panel-body-header'> <div class='col-md-3 col-sm-4'> <div id='imageContent'  style='float: left;margin-left: -20px;'> <img id='apercuImageContent' src='{{protocol}}://{{hostname}}:{{portvalue}}/keren/auth/resource/static/{{item.icon}}' alt='Image ' ng-click='imageClick()' height='70' width='75'></div> </div> <div  class='col-md-8 col-sm-7'> <div style='font-weight: bold;'>{{item.designation | cut:true:20:'...'}}</div> <div>{{item.shortDescription | cut:true:50:'...'}}</div> <div> <div class='col-sm-6 col-md-6 pull-left' >{{item.autor}}</div> <div class='col-sm-6 col-md-6 pull-right'><a href='{{item.website}}'>{{item.name}}</a></div> </div> </div> </div>"}}                          
                       ]}                       
                 ]

      };
   
   
   $scope.metaData = {  entityName:"Module",
                         name:{type:"string" , search:true ,fieldName:"name" , "fieldLabel":"Nom Module"},
                         shortDescription:{type:"string" , search:true,fieldName:"shortDescription" , fieldLabel:"Description Module"},
                         actions:{type:"array" , search:false,fieldName:"actions"
                         ,metaData:{name:{type:"string" , search:true,fieldName:"name"},
                                    shortDescription:{type:"string" , search:true,fieldName:"description"}
                                   }
                               }
                      };

   $scope.checkbox01 = false;
    /**
       type de fenetre active : new ,update , view ,list
    **/
    $scope.windowType = 'new';
    
    $scope.messageType = "inner";
    
    $scope.innerWindowType = 'new';
    
    $scope.currentModule = null;

    $scope.currentObject = null;

    $scope.currentUser = null;
    
    $scope.company = null;    
    
    $scope.enabledVerticalMenu = false;

    $scope.tableheaderselected = false;

    $scope.dataSelects = [] ;

    $scope.filtertemplate = new Object();
   
    $scope.principalscreen = true ;
          
     /**
      * 
      * @returns {Boolean}
      */
     $scope.hideApplicationModule = function(){
         if(!$rootScope.globals.user){
             return true;
         }//end if(!$rootScope.globals.user)
         if($rootScope.globals.user.adminlevel==0||$rootScope.globals.user.adminlevel==2){
             return true;
         }else{
             return false;
         }//end if($rootScope.globals.user.adminlevel==0||$rootScope.globals.user.adminlevel==2)
     };
     
     /**
      * 
      * @returns {Boolean}
      */
     $scope.hideConfiguration = function(){
         if(!$rootScope.globals.user){
             return true;
         }//end if(!$rootScope.globals.user)
         if($rootScope.globals.user.adminlevel==0||$rootScope.globals.user.adminlevel==1){
             return true;
         }else{
             return false;
         }//end if($rootScope.globals.user.adminlevel==0||
     };
      /**
        * 
        * @param {type} filename
        * @param {type} position
        * @returns {undefined}
        */
         $scope.imageloader = function(filename, position){
//             console.log("principal.imageloader(filename, position) ================= filename : "+filename+" ==== position : "+position)
            if(angular.isDefined(filename)&&angular.isDefined(position)) { 
              restService.downloadPNG(filename,position);
            }//end if(angular.isDefined(filename)&&angular.isDefined(position)) { 
             return "img\\photo.png";
         };
     /**
      * Chargement des modules de l'utilisateur
      * @returns {undefined}
      */
     $scope.getModulesForCurrentUser = function(){
         commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                //Chargement des modules de l'utilisateur
                restService.url('utilisateur','kerencore');
                restService.findByStringProperty('courriel',$rootScope.globals.currentUser.username).$promise
                        .then(function(data){
                            if(data.length>0){
                                $rootScope.globals.user = data[0];
                                $scope.currentUser = data[0];
                        //Initialisation du user en cours
                                $http.defaults.headers.common['userid']=angular.toJson(data[0].id);
                                $rootScope.globals.company = $rootScope.globals.user.societeCourante;
                                $scope.company = $rootScope.globals.company;
                                $translate.use('fr');
                                //Conservation de la langue si existe
                                if(data[0].langue){
                                    $rootScope.globals.langue = data[0].langue;
                                }//end if(data[0].langue)
                                if(data[0].langue && data[0].langue.codeISO=="en"){
                                    $translate.use('en');
                                }//end if(data[0].langue.codeISO=="fr_FR"){
//                                console.log("principal.getModulesForCurrentUser ====== "+angular.toJson(data[0]))
//                                $http.defaults.headers.common['user']= angular.toJson(data[0]);           
                                //Chargement  des modules
                                var url = 'http://'+$location.host()+':'+$location.port()+'/kerencore/utilisateur/application';
                                $http.get(url).then(
                                        function(response){
                                            $scope.modules = response.data;
                                            //console.log(angular.toJson($scope.modules));
                                            var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
                                            if(session==null){
                                                commonsTools.createsession(null,null,$rootScope.globals.user.id);
//                                                $scope.discussionModule();
                                            }else{
//                                                console.log("principal.327 ============== session precedente : "+session);
                                                session = angular.fromJson(session);                                               
                                                $scope.restoreSession(session);
                                            }//end if(session==null){
                                            commonsTools.hideDialogLoading();
                                        },function(error){
                                             commonsTools.hideDialogLoading();
                                             commonsTools.showMessageDialog(error);
                                        });                       
                           }
                        },function(error){
                            commonsTools.hideDialogLoading();
                            commonsTools.showMessageDialog(error);
                        });
                        //Chargement du logo de l'application
                        //restService.downloadPNG("appli_icon_id","logo.png");
     };
/**
 * Restoration de la precedente session 
 * de l'utilisateur connecté
 * @param {type} session
 * @returns {undefined}
 */
  $scope.restoreSession = function(session){      
      var module = null;
      if(session.module===null){
          $scope.discussionModule();
      }else if(session.module===$scope.applicationsModule.name){
          module = $scope.applicationsModule;
      }else if(session.module===$scope.configurationModule.name){
          module = $scope.configurationModule;
      }else{
            for(var i=0;i<$scope.modules.length;i++){
                var mod = $scope.modules[i];
                if(mod.name === session.module){
                    module = mod ;
                    break;
                }//end if(mod.id == session.module){
            }//end for(var i=0;i<$scope.modules.length;i++){
        }//end if(session.module==null){
      if(module!==null){
            var mementos = angular.fromJson(session.navigator);
            var memento = null;
            if(mementos!==null&& mementos.length>0){
                memento = mementos[mementos.length-1];
            }//end if(mementos!=null&& mementos.length>0){
            if(memento===null){
                $scope.getModule(module);
            }else{
                $scope.getModule(module,memento.action,memento.item);
            }//end if(memento===null){           
      }//end if(module!=null){
  };
/**
 * Filter action without appropiate security level
 * @param {type} module
 * @returns {undefined}
 */
     $scope.firstActiongroupFilter = function(module){
         for(var i=0;i<module.groups.length;i++){
             var group = module.groups[i];
             for(var j=0 ; j<group.actions.length;j++){
                 var action = group.actions[j];
                 if(action.securitylevel !=3 && action.hide==false){
                     return action;
                 }//end if(action.securitylevel !=3){
             }//end for(var j=0 ; j<group.actions.length,j++){
         }//end for(var i=0;i<module.groups.length;i++){
     };
     /**
      * Return action of module whith name  name 
      * @param {type} module
      * @param {type} name
      * @returns {group.actions|undefined}
      */
     $scope.getAction = function(module,name){
         if(name!=null && name !=""){
            for(var i=0;i<module.groups.length;i++){
                var group = module.groups[i];
                for(var j=0 ; j<group.actions.length;j++){
                    var action = group.actions[j];
//                    console.log("principal.getAction ======================== name : "+name+" ==== action : "+action.name+" ==== test : "+(action.name===name));
                    if(angular.isDefined(action) && action.name===name){
                        return action;
                    }//end if(action.securitylevel !=3){
                }//end for(var j=0 ; j<group.actions.length,j++){
            }//end for(var i=0;i<module.groups.length;i++){
        }//end if(name!=null && name !=""){        
         return $scope.firstActiongroupFilter(module);
     };
   /**
    * Function de chargement du module 
      courant(module selectionnÃ©)
    * @param {type} module
    * @param {type} action
    * @param {type} item
    * @returns {undefined}
    */
    $scope.getModule = function(module , action ,item){      
    	if(angular.isDefined(module)){    		
            $scope.currentModule = module;
            $scope.enabledVerticalMenu = false;
            $scope.moduleValue = "others";
            $http.defaults.headers.common['moduleid']= $scope.currentModule.id;
            $http.defaults.headers.common['modulename']= $scope.currentModule.name;                  
            //Notification du changement du module
            $rootScope.$broadcast("currentModule" , {module:$scope.currentModule , verticalMenu:$scope.enabledVerticalMenu});
            if(angular.isDefined(module.groups) && (module.groups.length > 0)){
               //Chargement de l'action par defaut
                $scope.enabledVerticalMenu = true;
                //$scope.getSelectAction(module.groups[0].actions[0]);                   
            }//end if(angular.isDefined(module.groups) && (module.groups.length > 0))  
            $scope.getSelectAction($scope.getAction(module , action),item);               
            //Hide the calendar panel
            $scope.showCalendar = false ;
            //Hide the discussion
            $scope.showDiscussion = false;
            //Hide General
            $scope.hideOther = $scope.showCalendar || $scope.showDiscussion ;    
            $scope.principalscreen = false;
            //Chargement du logo de l'application
            restService.downloadPNG("logo.png","appli_icon_id");
             
    	}//end if(angular.isDefined(module))
    };
    /**
     * 
     * @returns {undefined}
     */
    $scope.gotoModulesMenu = function(){
        $scope.principalscreen = true ;
        $scope.currentModule = null;
        $scope.currentAction = null;
        $http.defaults.headers.common['moduleid']= null;
        $http.defaults.headers.common['modulename']= null;
    };
    /**
     * 
     * @param {type} module
     * @returns {String}
     */
    $scope.getModuleClass = function(module){        
        if($scope.currentModule.name==module.name){
            return "activemodule";
        }//end if($scope.currentModule.name==module.name){
        return "";
    };
    
    $scope.getMenuClass = function(module){
//        console.log("$scope.getMenuClass = function(module) ========= "+module+" ===== "+$scope.currentAction.name+" test==");
        if(angular.isDefined(module) 
                 && $scope.currentAction.name==module.name){
            return "activemenu";
        }//end if($scope.currentAction.name==module.name){
        return "";
    };
    $scope.resetHttp_commons =function(){
//        $http.defaults.headers.common['predicats']= new Array(); $rootScope.globals.
            if(!$rootScope.globals.headers){
                return ;
            }//end if(!$rootScope.globals.headers){
            for(var i=0;i<$rootScope.globals.headers.length;i++){
                var prop = $rootScope.globals.headers[i];
                console.log("$scope.resetHttp_commons ========= "+prop+" ===== "+$http.defaults.headers.common[prop]);
                delete $http.defaults.headers.common[prop];
            }//end for(var i=0;i<$rootScope.globals.headers.length;i++){
            $rootScope.globals.headers = new Array();
    };
    /**
     * Fonction de traitement de l'action
       courant()
     * @param {type} action
     * @param {type} entity
     * @returns {undefined}
     */
    $scope.getSelectAction = function(action , entity,filters){
    	$scope.currentAction = null;	
         $scope.resetHttp_commons();
    	if(angular.isDefined(action)){
    		$scope.currentAction = action;
//                var mode = null ;
//                if($scope.currentAction.viewMode){
//                    mode = $scope.currentAction.viewMode.split(",");
//                }//end if($scope.currentAction.viewMode)   
//                //Traitement des actions de type website
//                if(mode && mode.length>0 && mode[0]=='website'){
//                    $rootScope.$broadcast("website" , {website:$scope.currentAction.model,currentuser:$rootScope.globals.currentUser});
//                    return ;
//                }//end if(mode && mode.length>0 && mode[0]=='dashboard'){
                $rootScope.$broadcast("currentActionUpdate" ,{
                 item:entity, action:$scope.currentAction , verticalMenu:$scope.enabledVerticalMenu,restriction:filters});  
    	}//end if(angular.isDefined(action)){    	
    };

    /**
     * 
     * @returns {undefined}
     */
    $scope.getDefaultModule = function(){         
        $scope.getModulesForCurrentUser();
        commonsTools.createBodyChatContent();
        $rootScope.$broadcast("startdiscussionworker" ,{});  
    };

    /**
    Action devant appeler l'entite
    **/
    $scope.executeActionEvent = function(action){

    };

/**
 * 
 * @returns {undefined}
 */
    $scope.onCheckboxClick = function(){
        
           	 $scope.tableheaderselected = !$scope.tableheaderselected;
         
	     	 for(var i=0 ; i<$scope.modules.length;i++){
	     	   var  module = $scope.modules[i];	     	 	 		  
	     	 	module.selected = $scope.tableheaderselected;
	     	 }//end for(var i=0 ; i<$scope.modules.length;i++){
                 
             for(var i=0 ; i<$scope.modules.length;i++){
             	  module = $scope.modules[i];	     
             	  //console.log("Vous avez cliquez sur "+module.name+" === "+module.shortDescription+"==="+module.selected); 
             }//end for(var i=0 ; i<$scope.modules.length;i++){  
    };


     /**
       Fonction de gestion
    **/
    $scope.configurationModuleAction = function(){
      $scope.enabledVerticalMenu = false;
      $scope.moduleValue = "others";
      $scope.currentModule = $scope.configurationModule;
      $http.defaults.headers.common['moduleid']= null;
      $http.defaults.headers.common['modulename']= null;                  
      //Notification du changement du module
      $rootScope.$broadcast("currentModule" , {module:$scope.currentModule , verticalMenu:$scope.enabledVerticalMenu});
      if(angular.isDefined($scope.currentModule.groups) && ($scope.currentModule.groups.length > 0)){
            $scope.enabledVerticalMenu = true;
            //var module = $scope.currentModule;
            $scope.getSelectAction($scope.currentModule.groups[0].actions[0]);
      }//end if(angular.isDefined($scope.currentModule.groups) && ($scope.currentModule.groups.length > 0))       
        //Hide the calendar panel
        $scope.showCalendar = false ;
        //Hide the discussion
        $scope.showDiscussion = false;
         //Hide application action
        $scope.showApplication = true ;
        //$scope.getModule($scope.configurationModule);    
        $scope.hideOther = $scope.showCalendar || $scope.showDiscussion ;
        $scope.principalscreen = false;
        //Chargement du logo de l'application
        restService.downloadPNG("logo.png","appli_icon_id");
    };

     /**
        Gestion du module applications
     **/
    $scope.applicationModule = function(){
         $scope.enabledVerticalMenu = true;
        $scope.moduleValue = "applications";
        $scope.currentModule = $scope.applicationsModule;
        $http.defaults.headers.common['moduleid']= null;
        $http.defaults.headers.common['modulename']= null;                  
        //Notification du changement du module
        $rootScope.$broadcast("currentModule" , {module:$scope.currentModule , verticalMenu:$scope.enabledVerticalMenu});
        if(angular.isDefined($scope.currentModule.groups) && ($scope.currentModule.groups.length > 0)){
                $scope.enabledVerticalMenu = true;
                //var module = $scope.currentModule;
             $scope.getSelectAction($scope.currentModule.groups[0].actions[0]);
          }//end if(angular.isDefined($scope.currentModule.groups) && ($scope.currentModule.groups.length > 0))
        //Hide the calendar panel
        $scope.showCalendar = false ;
        //Hide the discussion
        $scope.showDiscussion = false;
        $scope.moduleValue = "others";
        $scope.hideOther = $scope.showCalendar || $scope.showDiscussion ;
        $scope.principalscreen = false;
         //console.log("Vous avez cliquer sur le module ::: configuration");
         //Chargement du logo de l'application
        restService.downloadPNG("logo.png","appli_icon_id");
    };

    /**
      Module des Discussion
    **/
    $scope.discussionModule = function(){         
        //Hide the calendar panel
        $scope.showCalendar = false ;
        //Hide the discussion
        $scope.showDiscussion = true;
        $scope.moduleValue = "discussion";
        $scope.currentModule = $scope.agendaModule;
        $http.defaults.headers.common['moduleid']= null;
        $http.defaults.headers.common['modulename']= null;                  
        //Desactivi
        $scope.enabledVerticalMenu = false;
        $scope.hideOther = $scope.showCalendar || $scope.showDiscussion ;
        $scope.principalscreen = false;
        //Fermeture du tchat
        //Chargement du logo de l'application
        restService.downloadPNG($rootScope.globals.user.image,"mail_user_id");        
        //console.log("Vous avez cliquer sur le module ::: Discussion");
        $rootScope.$broadcast("discussionmodule" , {verticalMenu:$scope.enabledVerticalMenu});
//        $rootScope.$broadcast("currentModule" , {module:$scope.currentModule , verticalMenu:false});
    };
    
   
    /**
       Module des calendriers
    **/
    $scope.calendrierModule = function(){
        commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
        //Hide the calendar panel
        $scope.showCalendar = true ;
        //Hide the discussion
        $scope.showDiscussion = false;
        //Hide the verticam Menu
        $scope.enabledVerticalMenu = false;
        $scope.hideOther = $scope.showCalendar || $scope.showDiscussion ;
        $scope.moduleValue = "calendar";
        $scope.principalscreen = false;
        $scope.currentModule = $scope.calandarModule;
        $http.defaults.headers.common['moduleid']= null;
        $http.defaults.headers.common['modulename']= null;                  
        //Initialisation du service Rest
        restService.url('event','kerencore');
        restService.getMetaData(null).$promise.then(
                        function(metaData){
                             $scope.metaData = metaData;
                             var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/event/event/"+$rootScope.globals.userinfo.id; 
                             $http.get(url).then(
                                /**
                                 * 
                                 * @param {type} datas
                                 * @returns {undefined}
                                 */
                                    function(response){
                                         //Notification du changement du module
                                         $rootScope.$broadcast("calendarModule" , {metaData:metaData , events:response.data});
                                         commonsTools.hideDialogLoading();
                                    },
                                    function(error){
                                         commonsTools.hideDialogLoading();
                                         commonsTools.showMessageDialog(error);
                                    }
                                 );
                           
                        },
                /**
                 * Cas d'erret
                 * @returns {undefined}
                 */
                        function(error){
                            commonsTools.hideDialogLoading();
                            commonsTools.showMessageDialog(error);
                        });
        
        //console.log("Vous avez cliquer sur le module ::: Calendrier");
    };
    
    /**
     * Deconnexion de l'applicatiopn
     * @returns {undefined}
     */
    $scope.deconnexion = function(){
          commonsTools.hideDialogLoading();                                                        
        $rootScope.$broadcast("login" , {  });  
    };
    /**
     * 
     * @returns {undefined}
     */
    $scope.tchat = function(){
              $scope.currentUser = $rootScope.globals.userinfo;
               $scope.tchatinput = new Array();
//                 console.log(angular.toJson($scope.currentUser));
                var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/canal/canaux/"+$scope.currentUser.courriel;
                commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                $http.get(url)
                        .then(function(response){
                             var result = response.data;
                             for(var i=0;i<result.length;i++){
                                $scope.tchatinput.push(result[i]);
                             }//end for(var i=0;i<result.length;i++){
                             var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/canal/directe/"+$scope.currentUser.courriel;
//                commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                            $http.get(url)
                                    .then(function(response){
                                        var result = response.data;
                                        for(var i=0;i<result.length;i++){
                                            $scope.tchatinput.push(result[i]);
                                        }//end for(var i=0;i<result.length;i++){
                                        //console.log("$scope.tchat ====================== "+angular.toJson($scope.tchatinput));
                                        $scope.tchatinput = $filter('orderBy')($scope.tchatinput,'designation',false);    
                                        commonsTools.hideDialogLoading();
                                    },function(error){
                                        commonsTools.hideDialogLoading();
                                        commonsTools.showDialogLoading(error);
                                    });
                        },function(error){
                            commonsTools.hideDialogLoading();
                            commonsTools.showDialogLoading(error);
                        });
//        generateTchat();
    };
    /**
     * 
     * @param {type} idParent
     * @param {type} idElement
     * @param {type} idUser
     * @param {type} sens
     * @param {type} photo
     * @param {type} message
     * @param {type} date
     * @returns {undefined}
     */
     $scope.addMessage = function(idParent,idElement,idUser,sens,photo,message,date){
                   $('#'+idParent+'_tchatTexteContent').append("<div id="+idParent+idElement+"_messageTchat style='width:100%;padding:8px;'></div>");
	           if(sens == 0){
                            //Left
                            $('#'+idParent+idElement+"_messageTchat").append("<span id="+idParent+idElement+"_messageTchatPhotoContent style='margin-right:5px;width:40px;border:solid 1px #d3d3d3;display:inline-block;'></span>");
                            $('#'+idParent+idElement+"_messageTchat").append("<span id="+idParent+idElement+"_messageTchatTexteContent style='width:82%;vertical-align:top;display:inline-block;background-color:#eaeaea;padding:8px;border-radius:15px;word-wrap : break-word ;'></span>");

                            $('#'+idParent+idElement+"_messageTchatPhotoContent").append("<img id="+idParent+idElement+"_messageTchatPhoto style='width:100%;' src="+photo+">");
                            if(angular.isString(message)){
                              $('#'+idParent+idElement+"_messageTchatTexteContent").append("<div id="+idParent+idElement+"_messageTchatTexte style='font-size:89%'>"+message+"</div>");
                            }else{
                                $('#'+idParent+idElement+"_messageTchatTexteContent").append("<div id="+idParent+idElement+"_messageTchatTexte style='font-size:89%'>"+message.body+"</div>");
                            }//end if(angular.isString(message)){
                            $('#'+idParent+idElement+"_messageTchatTexteContent").append("<div id="+idParent+idElement+"_messageTchatDate style='font-style:italic;font-size:80%;text-align:right;'>"+date+"</div>");

                    }else{

                            //Right
                            $('#'+idParent+idElement+"_messageTchat").append("<span id="+idParent+idElement+"_messageTchatTexteContent style='margin-right:5px;width:82%;vertical-align:top;display:inline-block;background-color:#0484f7;color:white;padding:8px;border-radius:15px;word-wrap : break-word ;'></span>");
                            $('#'+idParent+idElement+"_messageTchat").append("<span id="+idParent+idElement+"_messageTchatPhotoContent style='width:40px;border:solid 1px #d3d3d3;display:inline-block;'></span>");

                            $('#'+idParent+idElement+"_messageTchatPhotoContent").append("<img id="+idParent+idElement+"_messageTchatPhoto style='width:100%;' src="+photo+">");
                            if(angular.isString(message)){
                                $('#'+idParent+idElement+"_messageTchatTexteContent").append("<div id="+idParent+idElement+"_messageTchatTexte style='font-size:89%'>"+message+"</div>");
                            }else{
                               $('#'+idParent+idElement+"_messageTchatTexteContent").append("<div id="+idParent+idElement+"_messageTchatTexte style='font-size:89%'>"+message.body+"</div>");
                            }
                            $('#'+idParent+idElement+"_messageTchatTexteContent").append("<div id="+idParent+idElement+"_messageTchatDate style='font-style:italic;font-size:80%;text-align:right;'>"+date+"</div>");
                    }
                    //On scroll vers le bas
                    $('#'+idParent+'_tchatTexteContent').scrollTop(1000000000,'bottom');
                    //Save en bd
                    var instance = commonsTools.getToTchatContext(idParent);
                    var canal = null;
                    var user = null;
//                    console.log("commons.addMessage : function(idParent,idElement,idUser,sens,photo,message,date,rootScope)============= "+" ===Element : "+idElement+"========="+angular.toJson(instance));
                    if(instance[idParent].cible.editTitle=='CANAL'){
                        canal = instance[idParent].cible;
                    }else{
                        user = instance[idParent].cible;
                    }//end if(instance[idElement].user.editTitle=='CANAL'){
                    var msge = message;
                    if(angular.isString(message)){
                        msge = commonsTools.createemptyMessage(instance[idParent].user,canal,user,message);
                        msge.sender=instance[idParent].user;                        
//                        console.log("princiÃ¢l.addMessage : function(idParent,idElement,idUser,sens,photo,message,date,rootScope) ============ ")
                        commonsTools.sendAction(msge);
                    }//end if(angular.isString(message)){     
                    instance[idParent].messages.push(msge);
               }; 
//     $scope.addPieceJoointe = function()
    /**
     * 
     * @param {type} item
     * @returns {undefined}
     */
    $scope.tchatwindow = function(item){
        var zoneid = "zone"+item.id;
        var idUser = $scope.currentUser.id;
        var idFriend = item.id;
        var photoUser = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/keren/auth/resource/static/"+$scope.currentUser.image;
        var photoFriend = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/keren/auth/resource/static/"+item.image;
        var nameFriend = item.designation;       
        if(angular.isDefined($scope.currentModule) && $scope.currentModule.name!=="discussionconf"){
            commonsTools.addToTchatContext(zoneid,$scope.currentUser,item);
            commonsTools.addChatZone(zoneid,idUser,idFriend,photoUser,photoFriend,nameFriend,$scope);
            //Chargement des donnÃ©es
           var messages = new Array();
           var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/kmessage/direct/"+$scope.currentUser.id+"/"+item.id+"/0/15";
           if(item.editTitle==='CANAL'){
              url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/kmessage/canal/"+$scope.currentUser.id+"/"+item.id+"/0/15";
           }//end if(item.editTitle==='CANAL'){
           $http.get(url)
                    .then(function(response){
                         var messages = response.data;
//                         $filter('orderBy')(messages,'id',true); 
                         for(var i=messages.length-1 ; i>=0 ;i--){
                             var sens = 0;
                             var photo = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/keren/auth/resource/static/"+$scope.currentUser.image;
                             if($scope.currentUser.id!=messages[i].sender.id){
                                 sens = 1;
                                 photo = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/keren/auth/resource/static/"+item.image;
                             }//end if($scope.currentUser.id!=messages[i].sender.id){
                             var today = new Date();
                             $scope.addMessage(zoneid,today.getTime(),idUser,sens,photo,messages[i],commonsTools.formatDat(new Date(messages[i].date)));
                         }//endfor(var i=0 ; i<messages.length;i++){
//                        $scope.piecejointeMenu($scope.messageobject);
                        commonsTools.hideDialogLoading();
                    },function(error){
                        commonsTools.hideDialogLoading();
                        commonsTools.showDialogLoading(error);
                    });
        }//end if($scope.currentModule.name!=="discussionconf"){
    };
    
    /**
     * 
     */
    $scope.updatePassword = function(){
        var action = {id:-80,name:"modifpassword" , label:"Elements de Menu",icon:"glyphicon glyphicon-th",entityName:"PwdUser2",moduleName:"kerencore",modal:true,securitylevel:0,model:'kerencore'};
        $rootScope.$broadcast("currentActionUpdate" ,{
                                   action:action , verticalMenu:$scope.enabledVerticalMenu});  
    };
    
     /**
        * Chargement du theme de l'application
        * @returns {undefined}
        */
       $scope.loadTheme = function(){
           var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/themerecord/theme"; 
           commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
           $http.get(url)
                   .then(function(response){
                       var theme = response.data;
                       if(angular.isDefined(theme) && angular.isDefined(theme.script)){
                            $rootScope.globals.theme = theme;
                            commonsTools.principalScreenBuilder(theme,$scope); 
                            $scope.getDefaultModule();
                        }else{
                            $scope.loadTheme();    
                        }//end if(angular.isDefined(theme) && angular.isDefined(theme.script)){
                   },function(error){
                       commonsTools.hideDialogLoading();
                       commonsTools.showMessageDialog(error);
                       $rootScope.globals.theme = null;
                       $scope.getDefaultModule();                       
                   });
       };
       //Chargmeent du theme
       $scope.loadTheme();    

     /**
        Reception du signal de changement de module
      **/
    $scope.$on("calandarActionItem" , function(event , args){
              $scope.currentModule = $scope.calandarModule;
              var entity = args.item;
              $scope.currentAction = args.action;
              var filter = args.restriction;
              $scope.enabledVerticalMenu = false;
              $scope.moduleValue = "others";
              $rootScope.$broadcast("currentModule" , {module:$scope.currentModule , verticalMenu:$scope.enabledVerticalMenu});
              //Notification du changement du module
               $rootScope.$broadcast("currentActionUpdate" ,{
                  item:entity, action:$scope.currentAction , verticalMenu:$scope.enabledVerticalMenu,restriction:filter});   
              //Hide the calendar panel
              $scope.showCalendar = false ;
              //Hide the discussion
              $scope.showDiscussion = false;
              //Hide General
              $scope.hideOther = $scope.showCalendar || $scope.showDiscussion ;    
              $scope.principalscreen = false;
//                    console.log("principal.calandarActionItem =================== "+$scope.currentModule);

    });
    //Hide Discussion login , calendar ,discussion ,others
    //Chargement des modules de l'utilisateur connectÃ©;
//    $scope.$on("user_modules" ,function(event ,args){
//        console.log("Felicitation vous ÃƒÂªte authentifiÃ© == "+args.modules);
//    });
       /**
            * Reception des evenement de d'edition des etats $scope.numberofconnectusers = 0;
            */
          $scope.$on("updatemessagesnumber" , function(event, args){
//               console.log("customreport =========== "+angular.toJson(args.metaData)); 
               $scope.numberofnewmessages = args.value;
          });
          
          $scope.$on("updateconnectusernumber" , function(event, args){
//               console.log("customreport =========== "+angular.toJson(args.metaData)); 
               $scope.numberofconnectusers = args.value;
          });
          
          /**
           * Refresh the message 
           */
          $scope.$on("refresh_message",function(event,args){
                var message = args.message;
                var zoneid = null;//"zone"+item.id;
                var canal = message.canal;
                var user = message.reciever;
                var item = null;
                if(canal!=null){
                    zoneid = "zone"+canal.id;
                    item = canal;
                }else {
                    zoneid = "zone"+user.id;
                    item = user;
                }//end if(message.reciever!=null){
                //Mise a jour de la Zone de tchat               
                var instance = commonsTools.getToTchatContext(zoneid);
                if(!angular.isDefined(instance[zoneid])||instance[zoneid].active===false){
                     commonsTools.addToTchatContext(zoneid,$scope.currentUser,item);
                     instance = commonsTools.getToTchatContext(zoneid);
                }//end if(!angular.isDefined(instance[zoneid])){
                var photoUser = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/keren/auth/resource/static/"+$scope.currentUser.image;
                var photoFriend = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/keren/auth/resource/static/"+item.image;
                var nameFriend = item.designation;
                if(angular.isDefined($scope.currentModule)&&$scope.currentModule!=null
                        && $scope.currentModule.name!=="discussionconf" && !commonsTools.isTchatOpen(zoneid)){
                   commonsTools.addChatZone(zoneid,$scope.currentUser.id,item.id,photoUser,photoFriend,nameFriend,$scope); 
                }//end if(angular.isDefined($scope.currentModule) && $scope.currentModule.name!=="discussionconf" && !commonsTools.isTchatOpen(zoneid)){
//                console.log("discussionctrl.$scope.$on(refresh_message,function(event,args)===================== "+message.id+" === "+commonsTools.contains(instance[zoneid].messages,message)+" data table ===== "+angular.toJson(instance[zoneid].messages));
                if(!commonsTools.contains(instance[zoneid].messages,message)){
                    instance[zoneid].messages.push(message);
                    var sens = 0;
                    var photo = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/keren/auth/resource/static/"+$scope.currentUser.image;
                    if($scope.currentUser.id!=message.sender.id){
                        sens = 1;
                        photo = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/keren/auth/resource/static/"+item.image;
                    }//end if($scope.currentUser.id!=messages[i].sender.id){
                    var today = new Date();
                    instance[zoneid].messages.push(message);
                    $scope.addMessage(zoneid,today.getTime(),item.id,sens,photo,message,commonsTools.formatDat(new Date(message.date)));
                }//end if(!commonsTools.contains(instance[zoneid].messages,args.message))){
          });
          
          $scope.$on("linkToAction" , 
            /**
             * 
             * @param {type} event
             * @param {type} args
             * @returns {undefined}
             */
            function(event, args){              
                var action = $scope.getAction($scope.currentModule,args.action);
                var mode = null ;
                if(action.viewMode){
                    mode = action.viewMode.split(",");
                }//end if($scope.currentAction.viewMode) 
//                console.log("$scope.buttonAction ======================== == == mode : "+mode+"===== "+angular.toJson(args.item));   
                //Traitement des actions de type website
                if(mode && mode.length>0 && mode[0]=='website'){
                    $rootScope.websitedata = args.item;
                    $rootScope.$broadcast("website" , {website:action.model,currentuser:$rootScope.globals.currentUser,item:args.item});
                    return ;
                }//end if(mode && mode.length>0 && mode[0]=='dashboard'){
//              console.log("customreport ================================ name ::::: "+args.action+"  action"+angular.toJson(action)); 
              if(angular.isDefined(action)&&action!=null){
                  $scope.getSelectAction(action,args.item,args.restriction);
              }else{
                  commonsTools.notifyWindow("Status Operation" ,"Impossible de trouver l'action "+args.action,"danger");
              }//end if(angular.isDefined(action)&&action!=null){
          });

});

angular.module("mainApp")
.directive("headerBuilder" , function(restService,commonsTools,$rootScope ,$translate,$filter,$http , $compile , $parse , $timeout,$location){
    
    return {
    	restrict : "E",
        scope : {    		    
            enablebVerticalMenu: "@fullScreen",
            currentAction:"@selectAction"
             
            
    	},
      controller: function($scope , $element , $attrs){
           
           

           $scope.currentObject = new Object();
           //The user current company
           $scope.company = null;
           //Contient la liste du contenue des lignes selectionnÃ©es
          $scope.selectedObjects = [];

          $scope.temporalDatas = [];
          
          //Champ temporaire de stockage des donnÃ©es
          $scope.temporalData = {};
          
          //Model temporaire
          $scope.temporalModel = null;
          //Cache applicatif
          $scope.dataCache = {};
          //Cache de resource
          $scope.resourcesCache = {};
          //Show or enable report title
          $scope.showreporttitle = false;
          //DonnÃ©es courantes
          $scope.datas = [];
          //Liste des predicats
          $scope.predicats = new Array();
          $scope.searchCriteria = new String();
          $scope.temporalSearchCriteria = new String();
          $scope.temporalPredicats = new Array();
          $scope.suffixedittitle = 'Nouveau';
          $scope.enablefollowerpanel = false;
          $scope.activefollower = false;
          //information pour construire le calendrier
          $scope.calendarrecord = null;
          $scope.viewmode = "tree";
           //Calandar event source
          $scope.eventSources = [];
          //Contient les element de navigation
          $scope.navigations = new Array();
          $scope.events = [
//                    {title: 'All Day Event',start: new Date(y, m, 1),selected:false},
//                    {title: 'Long Event',start: new Date(y, m, d - 5),end: new Date(y, m, d - 2),selected:false},
//                    {id: 999,title: 'Repeating Event',start: new Date(y, m, d - 3, 16, 0),allDay: false,selected:false},
//                    {id: 999,title: 'Repeating Event',start: new Date(y, m, d + 4, 16, 0),allDay: false,selected:false},
//                    {title: 'Birthday Party',start: new Date(y, m, d + 1, 19, 0),end: new Date(y, m, d + 1, 22, 30),allDay: false,selected:false},
//                    {title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/',selected:false}
                ];
                var isFirstTime = true ;
          //Calendar section
          //Configuration du calendrier
                $scope.uiConfig ={
                    calendar:{
                        height:480,
                        editable:true,
                        displayEventTime:false,
                        header:{
                            left:'prev,today,next,month,agendaWeek,agendaDay',
                            center:'title',
                            right:' '
                        },
                        selectable:true,
                        selectHelper:true,
                        select:function(start,end){     
//                              console.log("calendarCong !!!!!!!!!!!!!!!!!! "+(new Date(start)));
                              $scope.currentObject = commonsTools.createEmptyObject($scope.metaData);
                              $scope.currentObject.start =new Date(start);;
                              $scope.currentObject.end = new Date(start); ;
                              if($scope.calendarrecord!=null){
                                  if($scope.calendarrecord.startfield){
                                      $scope.currentObject[$scope.calendarrecord.startfield]= new Date(start);
                                  }//end if($scope.calendarrecord.startfield){
                                  $scope.currentObject['allDay']=$scope.calendarrecord.allday;
                                  if($scope.calendarrecord.endfield){
                                       $scope.currentObject[$scope.calendarrecord.endfield]=new Date(end);
                                  }//end if($scope.calendarrecord.endfield){
                              }//end if($scope.calendarrecord!=null)                              
                              $scope.previousType="calendar";
                               $scope.addNewCalendar();
//                              $('.selectpicker').selectpicker('refresh');
                             //console.log("Vous avez cliquez sur selectionner");
                        },
                        eventClick:function(event){
//                            $scope.currentObject=event;
                            $scope.previousType = 'calendar';//Notification du changement du module
                             $scope.viewAction(event);                    
                        },
                        eventAfterAllRender:function(){
                            if($scope.events.length>0 && isFirstTime){
                                //Focus first event
                            //      console.log("=============== "+angular.toJson(uiCalendarConfig));
                                  if(uiCalendarConfig.calendars && uiCalendarConfig.calendars.myCalendar){
                                    uiCalendarConfig.calendars.myCalendar.fullCalendar('gotoDate',$scope.events[0].start);
                                  }//end if(uiCalendarConfig.calendars && uiCalendarConfig.calendars.myCalendar)
                                  isFirstTime = false;
                           }//end if($scope.events.length>0 && isFirstTime){
                        }//end eventAfterAllRender:function(){
                    }
                };
          $scope.pagination = {  
                                 beginIndex: 0,
                                 endIndex : 0,
                                 currentPage :0,
                                 pageSize : 15 ,
                                 totalPages : 0,
                                 enabledNext: true,
                                 enabledPrevious:true,
                                /** Get the next pages **/
                                 next:function(){
                                     //Notification du chargement
                                     //Verification si on peut avance
                                     if(this.hasnext()){
                                         commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");  
                                         //this.currentPage = (this.currentPage*this.pageSize)%this.totalPages; 
                                         $scope.pagination.beginIndex = $scope.pagination.endIndex; //+1                                       
                                         //Chargement des donnes
                                          restService.filter($scope.predicats ,$scope.pagination.beginIndex , $scope.pagination.pageSize)
                                                .$promise.then(function(data){
//                                                      console.log('$scope.loadData = function() :::::::::::::::: '+data);
                                                     if(data){
                                                         $scope.datas = data;
                                                         //Traitement des donnÃ©es
                                                        if($scope.calendarrecord){
                                                             for(var i=0;i<$scope.datas.length;i++){
                                                                var data = $scope.datas[i];
                                                                if($scope.calendarrecord.titlefield){
                                                                    data['title'] = data[$scope.calendarrecord.titlefield];
                                                                }
                                                                if($scope.calendarrecord.startfield){
                                                                    data['start'] = data[$scope.calendarrecord.startfield];
                                                                }
                                                                if($scope.calendarrecord.endfield){
                                                                    data['end'] = data[$scope.calendarrecord.endfield];
                                                                }
                                                                data['allDay'] = $scope.calendarrecord.allday;
                                                             }//end for(var i=0;i<datas.length;i++){
                                                             $scope.eventSources = [datas];
                                                         }//end if($scope.calendarrecord)
                                                         $scope.pagination.currentPage = $scope.pagination.beginIndex;
                                                         $scope.pagination.endIndex = $scope.pagination.endIndex+$scope.pagination.pageSize;
                                                         if($scope.pagination.endIndex>$scope.pagination.totalPages){
                                                             $scope.pagination.endIndex = $scope.pagination.totalPages;
                                                         }
                                                         commonsTools.hideDialogLoading();
                                                         $rootScope.$broadcast("dataLoad" , {
                                                             message:"dataLoad"
                                                         });
                                                     }
                                                } ,function(error){
                                                    commonsTools.hideDialogLoading();
                                                    commonsTools.showMessageDialog(error);
                                                });  
                                     }//end if(this.hasnext()){
                                 },
                                 hasnext:function(){
                                     //Verifie that current pages is less or egal than totalPages
                                     if(this.endIndex>=this.totalPages){
                                         this.enabledNext = false ;                                        
                                     }else{
                                         this.enabledNext = true;
                                     }
                                     return this.enabledNext;
                                 },                                 
                                 hasNextPage:function(){
                                      if(this.currentPage>=this.totalPages){
                                         return false;
                                     }
                                     return true ;
                                 },
                                hasPreviousPage:function(){
//                                    console.log("pagination.hasPreviousPage() ================= c_page : "+this.currentPage+" ==== b_index : "+this.beginIndex)
                                     if(this.currentPage<=1){
                                       return false;
                                    }  
                                   return true;
                                 },            
                                 nextPage:function(){
                                     if(this.hasNextPage()){
                                         $scope.pagination.currentPage +=1;
                                         $rootScope.$broadcast("displayitem",{index:$scope.pagination.currentPage});
                                     }else{
                                          if(this.hasnext()){
                                            commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");  
                                            //this.currentPage = (this.currentPage*this.pageSize)%this.totalPages; 
                                            $scope.pagination.beginIndex = $scope.pagination.endIndex;   //+1                                     
                                            //Chargement des donnes
                                             restService.filter($scope.predicats ,$scope.pagination.beginIndex , $scope.pagination.pageSize)
                                                   .$promise.then(function(data){
//                                                         console.log('$scope.pagination.nextPage: = function() :::::::::::::::: '+data);
                                                        if(data){
                                                            $scope.datas = data;
                                                             //Traitement des donnÃ©es
                                                            if($scope.calendarrecord){
                                                                 for(var i=0;i<$scope.datas.length;i++){
                                                                    var data = $scope.datas[i];
                                                                    if($scope.calendarrecord.titlefield){
                                                                        data['title'] = data[$scope.calendarrecord.titlefield];
                                                                    }
                                                                    if($scope.calendarrecord.startfield){
                                                                        data['start'] = data[$scope.calendarrecord.startfield];
                                                                    }
                                                                    if($scope.calendarrecord.endfield){
                                                                        data['end'] = data[$scope.calendarrecord.endfield];
                                                                    }
                                                                    data['allDay'] = $scope.calendarrecord.allday;
                                                                 }//end for(var i=0;i<datas.length;i++){
                                                                 $scope.eventSources = [datas];
                                                             }//end if($scope.calendarrecord)
                                                            $scope.pagination.currentPage = $scope.pagination.beginIndex;
                                                            $scope.pagination.endIndex = $scope.pagination.endIndex+$scope.pagination.pageSize;
                                                            if($scope.pagination.endIndex>$scope.pagination.totalPages){
                                                                $scope.pagination.endIndex = $scope.pagination.totalPages;
                                                            }
                                                            commonsTools.hideDialogLoading();
                                                            $rootScope.$broadcast("displayitem",{index:$scope.pagination.currentPage});
                                                            commonsTools.hideDialogLoading(); 
                                                       }
                                                   } ,function(error){
                                                       commonsTools.hideDialogLoading();
                                                       commonsTools.showMessageDialog(error);
                                                   });  
                                        }//end if(this.hasnext()){
                                     }//end if(this.hasNextPage())
                                 },
                                 previousPage:function(){
                                     if(this.currentPage>(this.beginIndex+1)){
                                          $scope.pagination.currentPage -=1;
                                         $rootScope.$broadcast("displayitem",{index:$scope.pagination.currentPage});
                                     }else{
                                         if(this.hasprevious()){
                                            commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");  
                                            var interval = $scope.pagination.endIndex - $scope.pagination.beginIndex;
                                            $scope.pagination.beginIndex = $scope.pagination.beginIndex-$scope.pagination.pageSize-1;
                                            $scope.pagination.currentPage -= 1 ;
                                            if($scope.pagination.beginIndex<0){
                                                $scope.pagination.beginIndex = 0;
//                                                $scope.pagination.currentPage = 1;
                                            }
                                            if(interval>=$scope.pagination.pageSize){
                                                $scope.pagination.endIndex = $scope.pagination.endIndex - $scope.pagination.pageSize;
                                            }else{
                                                $scope.pagination.endIndex = $scope.pagination.endIndex-interval;
                                            }//end if(interval>=this.pageSize){
                                            if($scope.pagination.endIndex<=0){
                                               $scope.pagination.endIndex = $scope.pagination.pageSize;                                                             
                                            }//end if(this.endIndex<=0)
                                             restService.filter($scope.predicats ,$scope.pagination.beginIndex , $scope.pagination.pageSize)
                                                   .$promise.then(function(data){
//                                                         console.log('$scope.pagination.previousPage: = function() :::::::::::::::: '+data);
                                                        if(data){
                                                            $scope.datas = data;                                                         
                                                            $rootScope.$broadcast("displayitem",{index:$scope.pagination.currentPage});
                                                        }
                                                        commonsTools.hideDialogLoading();
                                                   } ,function(error){
                                                       commonsTools.hideDialogLoading();
                                                       commonsTools.showMessageDialog(error);
                                                   });  
                                        }//end if(this.hasprevious()){
                                     }//end if(this.hasPreviousPage())
                                 },
                                 hasprevious:function(){
                                     if(this.beginIndex<=0){
                                         this.enabledPrevious = false ;
                                     }else{
                                        this.enabledPrevious = true ;
                                    }
                                    return this.enabledPrevious;
                                 },
                                 previous:function(){
                                     if(this.hasprevious()){
                                         commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");  
                                         var interval = this.endIndex - this.beginIndex;
                                         this.beginIndex = this.beginIndex-this.pageSize-1;
                                         this.currentPage = this.beginIndex+1 ;
                                         if(this.beginIndex<0){
                                             this.beginIndex = 0;
                                             this.currentPage = 1;
                                         }
                                         if(interval>=this.pageSize){
                                             this.endIndex = this.endIndex - this.pageSize;
                                         }else{
                                             this.endIndex = this.endIndex - interval;
                                         }//end if(interval>=this.pageSize){
                                         if(this.endIndex<=0){
                                            this.endIndex = this.pageSize;                                                             
                                         }//end if(this.endIndex<=0)
                                          restService.filter($scope.predicats ,$scope.pagination.beginIndex , $scope.pagination.pageSize)
                                                .$promise.then(function(data){
//                                                      console.log('$scope.loadData = function() :::::::::::::::: '+data);
                                                     if(data){
                                                         $scope.datas = data;                                                         
                                                         commonsTools.hideDialogLoading();
                                                         $rootScope.$broadcast("dataLoad" , {
                                                             message:"dataLoad"
                                                         });
                                                     }
                                                } ,function(error){
                                                    commonsTools.hideDialogLoading();
                                                    commonsTools.showMessageDialog(error);
                                                });  
                                     }//end if(this.hasprevious()){
                                 }
                                 
                           };
            $scope.temporalPagination = {
                                 module:null ,
                                 model:null,                                 
                /** Get the next pages **/
                                 next_2:function(){
                                     //Notification du chargement
                                    
                                     //Verification si on peut avance
                                     if(this.hasnext()){
                                         commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");  
                                         //this.currentPage = (this.currentPage*this.pageSize)%this.totalPages; 
                                        $scope.temporalPagination.beginIndex = $scope.temporalPagination.endIndex;  //+1
                                         var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase($scope.temporalPagination.module)+"/"+angular.lowercase($scope.temporalPagination.model)+"/filter/"+$scope.temporalPagination.beginIndex+"/"+$scope.temporalPagination.pageSize;
                                         //Chargement des donnes                                          
                                           var dmodel = this.model;
                                          $http.get(url)
                                                .then(function(response){
                                                    var datas = response.data;
//                                                     console.log('$scope.loadData = function() :::::::::::::::: b_index : '+$scope.temporalPagination.beginIndex+" ::: e_index : "+$scope.temporalPagination.endIndex+" === size : "+$scope.temporalPagination.pageSize);
                                                     if(datas){
                                                         $scope.dataCache[dmodel] = datas;
                                                         $scope.temporalPagination.currentPage = $scope.temporalPagination.beginIndex;
                                                         $scope.temporalPagination.endIndex = $scope.temporalPagination.endIndex + $scope.temporalPagination.pageSize;
                                                         if($scope.temporalPagination.endIndex>$scope.temporalPagination.totalPages){
                                                             $scope.temporalPagination.endIndex = $scope.temporalPagination.totalPages;
                                                         }//end if(this.endIndex>this.totalPages){                                                         
                                                     }
                                                     commonsTools.hideDialogLoading();
                                                } ,function(error){
                                                    commonsTools.hideDialogLoading();
                                                    commonsTools.showMessageDialog(error);
                                                });  
                                     }
                                 },                                 
                                 previous_2:function(){
                                     if(this.hasprevious()){
                                         commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");  
                                         var interval = this.endIndex - this.beginIndex;
                                         $scope.temporalPagination.beginIndex = $scope.temporalPagination.beginIndex-$scope.temporalPagination.pageSize-1;
                                         $scope.temporalPagination.currentPage = $scope.temporalPagination.beginIndex+1 ;
                                         if($scope.temporalPagination.beginIndex<0){
                                             $scope.temporalPagination.beginIndex = 0;
                                             $scope.temporalPagination.currentPage = 1;
                                         }
                                         if(interval>=$scope.temporalPagination.pageSize){
                                             $scope.temporalPagination.endIndex = $scope.temporalPagination.endIndex - $scope.temporalPagination.pageSize;
                                         }else{
                                             $scope.temporalPagination.endIndex = $scope.temporalPagination.endIndex - interval;
                                         }//end if(interval>=$scope.temporalPagination.pageSize)
                                         if($scope.temporalPagination.endIndex<=0){
                                            $scope.temporalPagination.endIndex = $scope.temporalPagination.pageSize;                                                             
                                         }//end if(this.endIndex<=0)
                                         var dmodel = $scope.temporalPagination.model;
                                         var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase($scope.temporalPagination.module)+"/"+angular.lowercase($scope.temporalPagination.model)+"/filter/"+$scope.temporalPagination.beginIndex+"/"+$scope.temporalPagination.pageSize;
                                          $http.get(url)
                                                  .then(function(response){
                                                      var datas = response.data;
                                                      //console.log('$scope.loadData = function() :::::::::::::::: '+datas);
                                                     if(datas){
                                                         $scope.dataCache[dmodel] = datas;                                                   
                                                     }//end if(datas){
                                                     commonsTools.hideDialogLoading();
                                                } ,function(error){
                                                    commonsTools.hideDialogLoading();
                                                    commonsTools.showMessageDialog(error);
                                                });  
                                     }
                                 }                
            };   
            //Heritage des data et met
           angular.extend($scope.temporalPagination,$scope.pagination);
           /**
              Type de la fenetre
              value : new , update , view , list
           **/
          $scope.windowType = 'new';
          /**
             Chemin d'acces au metaData
          **/
         $scope.currentMetaDataPath = 'metaData';
         /**
          * 
          */
         $scope.temporalMetaData = null;
         /**
          * Pool de gestion des objets observables
          */
         $scope.observablePools = {};
         //Conserve le template 
         $scope.templateData = null;
         /**
          * For Editable table contain the value of the select row
          */
         $scope.selectRow = null;
         /**
          * Titre du rapport
          */
         $scope.reporttitle = null;
         /**
          * Activate de back button
          */
        $scope.showback = false;         
        $scope.hostname = $location.host();
        $scope.portvalue = $location.port();
        $scope.protocol = $location.protocol(); 
         /**
          * Container de navigation
          */
          $scope.navigatorcontainer  = commonsTools.getNavigatorContainer();
         /**
          * Contient les datas de l'importation pour l'entite courante
          */
         $scope.importData = null;
         /**
          * Implementation du partne observer
          * @returns {Boolean}
          */
         var Observable = function(){
             this.observers = new Array();
         };
         Observable.prototype = {
               //enregistrement un observer a recevoir des notifications
                register:function(observer){
                    this.observers.push(observer);           
//                    console.log("Observer pattern === register : "+observer+" ==== "+this.observers.length);
                    return this;
                },
                //envoie une notification a tous les observers enregistres
                notifyObservers:function(event , parameters){
//                    console.log("Observer pattern === notifyObservers : "+this.observers.length);
                    for(var i=0;i<this.observers.length;i++){
                        var observer = this.observers[i];
                        observer.notify(event,parameters);
                    }//end for(var i=0;i<this.observers.length;i++)
                }
         };
         /**
          * 
          * @param {type} template
          * @param {type} model
          * @returns {principal_L731.principalAnonym$37.controller.Observer}
          */
         var Observer = function(template,model){
             this.template = template;
             this.model = model ;
         };
         Observer.prototype={
             register:function(observable){
                this.observable = observable;
                this.notifyMe();
                return this;
             },
             notifyMe:function(){
                 this.observable.register(this);
             },
             /**
              * 
              * @param {type} event
              * @param {type} parameters
              * @returns {undefined}
              */
             notifyObservers:function(event , parameters){
                 this.observable.notifyObservers(event,parameters);
             },
             /**
              * 
              * @param {type} event
              * @param {type} parameters
              * @returns {principal_L470.principalAnonym$31.controller.Observer.prototype}
              */
             notify:function(event , parameters){
                 var modelsplit = this.model.split(".");
                 var parentmodel = modelsplit[0];
                 for(var i=1;i<(modelsplit.length-1);i++){
                     parentmodel+="."+modelsplit[i];
                 }//end for(var i=0;i<modelsplit.length;i++)
                 var data = $scope.getParentModel(this.model);
                 var template = angular.fromJson(angular.toJson(this.template["source"]));
//                  console.log("notify:function(event , parameters) ============= method:"+template["methodname"]+" :::: entity : "+angular.toJson(data[this.template["observable"]]));
                 if(template["fieldname"] && data[this.template["observable"]]){
                     var entity = data[this.template["observable"]];
                     var elem = entity[template["fieldname"]];
                     data[modelsplit[modelsplit.length-1]] = elem;
//                     console.log("principal.notify :::: model : "+this.model+" ==== template : "+angular.toJson(template)+" ==== parentmodel : "+parentmodel+" === isObject:"+angular.isObject(elem)+" ==== elem:"+angular.toJson(elem));
                     if(angular.isObject(elem)){
                         var key = commonsTools.keygenerator(this.model);
                         $scope.dataCache[""+key+""] = new Array();
                         var obj = {id:'load' , designation:'Charger les donnÃ©es ....'};    
                         $scope.dataCache[""+key+""].push(elem);
                         $scope.dataCache[""+key+""].push(obj);                         
                         $timeout(function() {
                            $('.selectpicker').selectpicker('refresh');
                         });
                     }else if(angular.isArray(elem)){
                         var key = commonsTools.keygenerator(this.model);
                         for(var i=0 ; i<elem.length;i++){
                             $scope.dataCache[""+key+""] =[];
                             $scope.dataCache[""+key+""].push(elem[i]);
                         }//end for(var i=0 ; i<elem.length;i++){
                         $timeout(function() {
                            $('.selectpicker').selectpicker('refresh');
                         });
                     }//end if(angular.isObject(elem)){
                 }else if(template["methodname"]  && data[this.template["observable"]]){
                     commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                     var entity = data[this.template["observable"]];
                     if(angular.isDefined(entity)){
                         var id = entity ;
                         if(angular.isObject(entity)){
                             id = entity.id ;
                             if(!angular.isNumber(id)){
                                  id = -1 ;
                             }//end if(!angular.isNumber(id)){
                         }//end if(angular.isObject(entity)){                         
                         $http.defaults.headers.common['id']=angular.toJson(id);
                         //Construction des autres
                         var parameters = this.template["parameters"];
//                          console.log("notify:function(event , parameters) ============= model "+this.model+" method:"+template["methodname"]+" :::: entity : "+angular.toJson(parameters)+" ===== ID : "+id);
                         if(parameters.length>0){
                             for(var i=0;i<parameters.length;i++){
                                 var param = parameters[i];
//                                 console.log("notify:function(event , parameters) ============= ===== Date param : "+data[param]+" === param : "+param+" ==== isDate : "+angular.isDate(data[param]));
                                 if(angular.isObject(data[param])){
                                     $http.defaults.headers.common[param]=angular.toJson(data[param].id);
                                 }else if(!angular.isArray(data[param])){//element
                                      $http.defaults.headers.common[param]=angular.toJson(data[param]);
                                 }//end if(angular.isObject(entity[param])){
                             }//end for(var i=0;i<parameters.length;i++){
                         }//end if(parameters.length>0){
                     }//end if(angular.isDefined(entity)){
//                     console.log("notify:function(event , parameters) ============= model "+this.model+" method:"+template["methodname"]+" :::: entity : "+angular.toJson(entity));
                     var metaData = $scope.getParentMetaData(this.model);
                     var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(metaData.moduleName)+"/"+angular.lowercase(metaData.entityName)+"/"+template["methodname"];
                     $http.get(url)
                             .then(function(response){//$scope.getf
//                                 console.log("notify:function(event , parameters) ============= model "+this.model+" method:"+template["methodname"]+" :::: entity : "+angular.toJson(parameters)+" ===== ID : "+id+" ==== entity : "+angular.toJson(data)+" ===== key : "+modelsplit[modelsplit.length-1]+" ==== reponse : "+response.data);
                                 data[modelsplit[modelsplit.length-1]] = response.data;
                                 if(angular.isObject(elem)){
                                    var key = commonsTools.keygenerator(this.model);
                                    $scope.dataCache[""+key+""].push(response.data);
                                    $timeout(function() {
                                       $('.selectpicker').selectpicker('refresh');
                                    });
                                 }else if(angular.isArray(elem)){
                                     var key = commonsTools.keygenerator(this.model);
                                     for(var i=0 ; i<response.data.length;i++){
                                         $scope.dataCache[""+key+""].push(response.data[i]);
                                     }//end for(var i=0 ; i<response.data.length;i++){
                                     $timeout(function() {
                                       $('.selectpicker').selectpicker('refresh');
                                     });
                                 }//end if(angular.isObject(elem))
                                 commonsTools.hideDialogLoading();
                             },function(error){
                                  commonsTools.hideDialogLoading();
                                 commonsTools.showMessageDialog(error);
                             });
                 }//end if(template["fieldname"] && data[this.template["observable"]])
//                 console.log("Vous avez cliquez sur un observateur :::: "+data[modelsplit[modelsplit.length-1]]+" ============================ "+modelsplit[modelsplit.length-1]+" ============ "+angular.toJson(template)+" ================================ "+template["fieldname"]);
                 return this;
             }   
         };
          /**
            * 
            * @param {type} model
            * @param {type} field
            * @param {type} scope
            * @returns {undefined}
            */
           $scope.addObserver = function(model,field){
//               console.log("$scope.inputTextBuilder =======================================model : "+model+" filed Name : "+field.fieldName+" ======== Observer "+angular.toJson(field.observer));
              if(field.observable==true){
                   var observable = new Observable();
                   $scope.observablePools[field.fieldName] = observable;
               }//end if(field.observable==true)
               if(field.observer!=null){
                   var observer = new Observer(field.observer,model);
                   if($scope.observablePools[field.observer.observable]){
                       observer.register($scope.observablePools[field.observer.observable]);
                   }else{
                        var observable = new Observable();
                        $scope.observablePools[field.observer.observable] = observable;
                        observer.register($scope.observablePools[field.observer.observable]);
                   }//end if($scope.observablePools[field.fieldName])
               }//end if(field.observer!=null)
           };
         /**
          * 
          * @param {type} value
          * @param {type} length
          * @returns {undefined}
          */
         $scope.truncateString = function(value , length){
             if(value.length>length){
                return value.substring(0, length);
             }//end if(value.length>length){
             return value;
         };
         /**
          * 
          * @param {type} name
          * @returns {undefined}
          */
         $scope.getActionByName = function(name,filters,headers,item){
//             console.log("principals.getActionByName ======== action : "+name+" ==== filters : "+headers+" === item : "+angular.toJson(item));
             if(!angular.isDefined(filters)||filters==null){
                 filters = new Array();
             }//end if(!angular.isDefined(filters)||filters==null){
             $http.defaults.headers.common['action_param']= headers;             
             if(angular.isDefined(name)&&name!==""){
                 $rootScope.$broadcast("linkToAction" ,{
                      action:name,item:item,restriction:filters});  
             }//end if(angular.isDefined(name)&&name!=""){
         };
         
         /**
          * 
          * @returns {Boolean}Droite de creation 
          */
         $scope.canCreate = function(item){
//             console.log("$scope.canCreate = function() =================== "+angular.toJson($rootScope.globals.user));  
             var desablecreate = false ;
             if($scope.windowType=='view'){
                 if($scope.currentObject){
                     desablecreate = $scope.currentObject.desablecreate;
                 }//end if($scope.currentObject){
             }else if(item){
                 desablecreate = item.desablecreate;
             }//end if($scope.windowType=='update'||$scope.windowType=='view'){
             var result = true ;
             if(angular.isDefined($scope.metaData) && $scope.metaData.desablecreate==true && $scope.windowType=='new'){
                 result &= false;
             }//end if(angular.isDefined($scope.metaData) && $scope.metaData.desablecreate==true ){
             if(desablecreate==true){
                 return false ;
             }//end if(desablecreate==true){
             if($scope.currentAction){
                 result &=  ($scope.currentAction.securitylevel>=0)&&($scope.currentAction.securitylevel<=1);
             }//end if($scope.currentAction){ 
             return result ;
         };
         /**
            * Deconnexion de l'applicatiopn
            * @returns {undefined}
            */
           $scope.deconnexion = function(){
               commonsTools.hideDialogLoading();                                                        
               $rootScope.$broadcast("login" , {  });  
           };
           /**
            * 
            * @returns {Boolean}
            */
         $scope.canDelete = function(item){
             var desabledelete = false ;
             if($scope.windowType=='view'){
                 if($scope.currentObject){
                     desabledelete = $scope.currentObject.desabledelete;
                 }//end if($scope.currentObject){
             }else if(item){
                 desabledelete = item.desabledelete;
             }//end if($scope.windowType=='update'||$scope.windowType=='view'){
             if(angular.isDefined($scope.metaData) && ($scope.metaData.desabledelete==true||desabledelete==true)){
                 return false;
             }else if($scope.currentAction){
                 return ($scope.currentAction.securitylevel==0);
             }
             return false;
         };
         /**
          * 
          * @returns {Boolean}
          */
         $scope.canUpdate = function(item){
             var desableupdate = false;
             if($scope.windowType=='view'){
                 if($scope.currentObject){
                    desableupdate = $scope.currentObject.desableupdate;
                 }//end if($scope.currentObject){
             }else if(item){
                 desableupdate = item.desableupdate;
             }//end if($scope.windowType=='update'||$scope.windowType=='view'){
             if(angular.isDefined($scope.metaData) && ($scope.metaData.desableupdate==true||desableupdate==true)){// && $scope.windowType=='update'
                 return false;
             }else if($scope.currentAction){
                 return ($scope.currentAction.securitylevel>=0)&&($scope.currentAction.securitylevel<=1);
             }//end if($scope.currentAction){
             return false ;
         };
         /**
          * 
          * @returns {Boolean}
          */
         $scope.canPrint = function(){
             if($scope.currentAction){
                 return ($scope.currentAction.securitylevel>=0)&&($scope.currentAction.securitylevel<=2);
             }  
             return false ;
         };
         /**
          * 
          * @returns {Boolean}
          */
         $scope.showActions = function(){            
             return $scope.selectedObjects.length>0 && $scope.showApplication==false;
         };
          /**
           * 
           * @param {type} texte
           * @param {type} color
           * @param {type} colorContent
           * @param {type} topPos
           * @param {type} leftPos
           * @returns {undefined}
           */
          $scope.showDialogLoading =function(texte, color, colorContent, topPos,leftPos) {
            $('body').append("<div id='dialogContent' style='width:100%;height:100%;position:absolute;z-index:2000;text-align:center;'></div>");
            $('#dialogContent').append("<div id='dialogWindow'></div>");
            $('#dialogWindow').append("<span id='dialogWindowText' style='text-align:center;padding:8px;padding-right:16px;padding-left:16px;display:inline-block;color:white;border-radius:3px;font-size:80%;'>"+texte+"</span>");
            //Changer le proprietes css
            $('#dialogContent').css("top",topPos);
            $('#dialogContent').css("left",leftPos);
            $('#dialogWindowText').css("color",color);
            $('#dialogWindowText').css("background-color",colorContent);
             //Afficher le dialog
            $('#dialogContent').fadeIn();
          };

/**
 * 
 * @returns {undefined}
 */
          $scope.hideDialogLoading =function() {
            $('#dialogContent').fadeOut(function(){
              $('#dialogContent').remove();
            });
          };

/**
 * 
 * @returns {undefined}
 */
           $scope.hellordWordDialog = function() {            
            //On affiche le dialog
            commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
            setTimeout(function(){
              commonsTools.hideDialogLoading();
            },3000);
          };

           /***  
               verifie si c'est une operation de creation
           **/
          $scope.iscreateOperation = function(){
               return $scope.windowType == 'new';
          };
          
          $scope.shownotepanel = function(){
              if($scope.windowType == 'new'){
                  return false;
              }//end if($scope.windowType == 'new'){
              if($scope.metaData.activatefollower==true){
                  return true;
              }//end if($scope.metaData.activatefollower==true){
              return false;
          };

          $scope.isviewOperation = function(){
              return $scope.windowType == 'view';
          };

          /***  
               verifie si c'est une operation de creation
           **/
          $scope.isupdateOperation = function(){
               return $scope.windowType === 'update';
          };

          /**
             Selectionne ou desellectionn les lignes du tableaux
          **/
          $scope.onCheckboxClick = function(){        
            $scope.tableheaderselected = !$scope.tableheaderselected;
            $scope.selectedObjects = [];               
            for(var i=0 ; i<$scope.datas.length;i++){
               var module = $scope.datas[i];               
               module.selected = $scope.tableheaderselected;
               if(module.selected){
                    $scope.selectedObjects.push(module);
               }//end if(module.selected)
            }//end for(var i=0 ; i<$scope.datas.length;i++){                       
               
          };
  
          /**
             Verifie que le tableau contient un element
             @array : tableau de donnÃ©es
             @item : element
          **/
          $scope.contains = function(array , item){
               if(!angular.isDefined(array)){
                  return false;
               }//end if(!angular.isDefined(array)){
               for(var i= 0 ; i<array.length;i++){
                   if(array[i].id === item.id){
                      return true;
                   }//end if(array[i].id == item.id){
               }//end for(var i= 0 ; i<array.length;i++){
               return false;
          };
          
           /**
             Verifie que le tableau contient un element
             @array : tableau de donnÃ©es
             @item : element
          **/
          $scope.containsObject = function(array , item){
               if(!angular.isDefined(array)){
                  return false;
               }//end if(!angular.isDefined(array)){
               for(var i= 0 ; i<array.length;i++){
                   if(array[i].compareid === item.compareid){
//                       console.log("principals.$scope.containsObject = function(array , item) ==== item : "+angular.toJson(item)+" === selected items : "+angular.toJson(array));
                      return true;
                   }//end if(array[i].compareid == item.compareid){
               }//end for(var i= 0 ; i<array.length;i++)
               return false;
           };
          
          /**
           * Return the index of Item
           * @param {type} array
           * @param {type} item
           * @returns {undefined}
           */
          $scope.indexOf = function(array , item){
              if(!angular.isDefined(array)){
                  return -1;
               }//end if(!angular.isDefined(array)){
               for(var i= 0 ; i<array.length;i++){
                   if(array[i].compareid === item.compareid){
                      return i;
                   }//end if(array[i].compareid == item.compareid){
               }//endfor(var i= 0 ; i<array.length;i++){
               return -1;
          };

           /**
            * Retire une valeur d'un tableau
            * @param {type} array
            * @param {type} item
            * @returns {undefined}
            */
          $scope.removeFromArray = function(array , item){
               if(angular.isDefined(array)){     
                  for(var i=0 ; i<array.length;i++){
                     if(array[i].compareid === item.compareid){
                        array.splice(i , 1);
                     }//end if(array[i].compareid == item.compareid){
                  }//end for(var i=0 ; i<array.length;i++){
                  //console.log(array+" ====== "+item);                             
              }//end if(angular.isDefined(array)){ 
          };

           /**
            * 
            * @param {type} item
            * @returns {undefined}
            */
          $scope.onRowCheckboxClickDialog = function(item){
              
              //Verifier que 
              if(!$scope.dataCache.selectedObjects){
                  $scope.dataCache.selectedObjects = new Array();
              }//end if(!$scope.dataCache.selectedObjects){
              item.selected = !item.selected;

              if(item.selected){
                if(!commonsTools.contains($scope.dataCache.selectedObjects , item)){
                     //console.log("$scope.onRowCheckboxClickDialog = ============== "+item);
                     $scope.dataCache.selectedObjects.unshift(item);
                }else{
                    
                    item.selected =!item.selected; 
                    var message ="Vous avez selectionnÃ© deux lignes referencant la mÃªme entitÃ©e";
                    commonsTools.notifyWindow("Double selection " ,"<br/>"+message,"warning");
                }
              }else{
                //console.log("$scope.onRowCheckboxClickDialog $scope.containsObject($scope.dataCache.selectedObjects , item) = ============== "+item);
                $scope.removeFromArray($scope.dataCache.selectedObjects , item);                
              }             

          };
          
          /**
           * 
           * @param {type} item
           * @returns {undefined}
           */
          $scope.onRowCheckboxClick = function(item){
              //console.log("============== "+item);
              item.selected =!item.selected;

              if(item.selected){
                if(!$scope.contains($scope.selectedObjects , item)){
                     $scope.selectedObjects.unshift(item);
                }
              }else{
                $scope.removeFromArray($scope.selectedObjects , item);
                if($scope.selectedObjects.length===0){
                  $scope.tableheaderselected = false;
                }//end if($scope.selectedObjects.length===0){
              }
              $scope.currentObject = $scope.selectedObjects[0];

          };



         /**
          * 
          * @returns {undefined}
          */
         $scope.tableListBuilder = function(){
            
             var tableElem = document.createElement('table');
             tableElem.setAttribute('class' , 'table table-striped table-hover table-responsive');
             tableElem.setAttribute('id' , 'table');
             //Creation du table header
             var theadElem = document.createElement('thead');
             tableElem.appendChild(theadElem);
             //Creation entete
             var  rheadElem = document.createElement('tr');
             theadElem.appendChild(rheadElem);
             var thElem0 = document.createElement('th');
             var inputElem0 = document.createElement('input');
             inputElem0.setAttribute('type' , 'checkbox');
             inputElem0.setAttribute('ng-model' , 'tableheaderselected');
             inputElem0.setAttribute('ng-click' , 'onCheckboxClick()');
            thElem0.appendChild(inputElem0);
            rheadElem.appendChild(thElem0);
            $scope.metaData.columns = $filter('orderBy')($scope.metaData.columns,'colsequence',false);    
            for(var i=0 ; i<$scope.metaData.columns.length;i++){
              if(angular.isDefined($scope.metaData.columns[i].search)
                        &&($scope.metaData.columns[i].search==true)){
                  var thElem = document.createElement('th');
                  thElem.innerHTML = $scope.metaData.columns[i].fieldLabel;
                  rheadElem.appendChild(thElem);
              }
            }

            //Creation du corps du tableau
            var tbodyElem = document.createElement('tbody');
            tableElem.appendChild(tbodyElem);
            var rbodyElem = document.createElement('tr');
            rbodyElem.setAttribute('ng-repeat' , ' obj in datas');
            tbodyElem.appendChild(rbodyElem);
            var tdElem = document.createElement('td');
            rbodyElem.appendChild(tdElem);
             inputElem0 = document.createElement('input');
             inputElem0.setAttribute('type' , 'checkbox');
             inputElem0.setAttribute('ng-model' , 'obj.selected');
             inputElem0.setAttribute('ng-click' , 'onRowCheckboxClick(obj)');
             tdElem.appendChild(inputElem0);
             
             for(var i=0 ; i<$scope.metaData.columns.length;i++){
                  if(angular.isDefined($scope.metaData.columns[i].search)
                        &&($scope.metaData.columns[i].search==true)){
                        var thElem = document.createElement('td');
                        thElem.innerHTML = "{{obj."+$scope.metaData.columns[i].fieldName+"}}";
                        rbodyElem.appendChild(thElem);
                  }//end if(angular.isDefined($scope.metaData.columns[i].search)
             }//end for(var i=0 ; i<$scope.metaData.columns.length;i++){
            var divElem = document.createElement('div');
            divElem.appendChild(tableElem);
            var viewElem = angular.element(divElem.innerHTML);
            var compileFn = $compile(viewElem);
            compileFn($scope);

            var items = $element.find("div");
            for(var i=0; i<items.length;i++){                 
                 if(items.eq(i).attr("id")=="datatable"){
                       items.eq(i).replaceWith(viewElem);
                 }//end if(items.eq(i).attr("id")=="datatable"){ 
            }//end for(var i=0; i<items.length;i++){      
         };

         /**
             Fonction de construction du filtre de recherche
         **/
         $scope.filterOptionsBuilder = function(){
               
               var ulElem = document.createElement('ul');
               ulElem.setAttribute('class','dropdown-menu');
               ulElem.setAttribute('role' , 'menu');
               ulElem.setAttribute('aria-labelledby' , 'filterbtn');
               ulElem.setAttribute('id' , 'filterActionsId');
               ulElem.setAttribute('ng-repeat' , ' obj in metaData');
                
               for(var i=0 ; i< $scope.metaData.columns.length;i++){
                 if(angular.isDefined($scope.metaData.columns[i].search)
                        &&($scope.metaData.columns[i].search==true)){
                   var liElem = document.createElement('li');
                   liElem.setAttribute('role' , 'presentation');
                   ulElem.appendChild(liElem);
                   var aElem = document.createElement('a');
                   aElem.setAttribute('role' , 'menuitem');
                   aElem.setAttribute('tabindex' , '-1');
                   aElem.setAttribute('href' , '#');
                   liElem.appendChild(aElem);
                   var divElem = document.createElement('div');
                   aElem.appendChild(divElem);                   
                   var inputElem = document.createElement('input');
                   divElem.appendChild(inputElem);
                   divElem.setAttribute('style' , 'border:solid 1px red;');
                   inputElem.setAttribute('ng-model' , 'obj.value');
                   inputElem.setAttribute('class' , 'input-sm');
                   inputElem.setAttribute('placeholder' , $scope.metaData.columns[i].fieldLabel);
                   inputElem = document.createElement('input');
                   divElem.appendChild(inputElem);
                   inputElem.setAttribute('type' , 'checkbox');
                   inputElem.setAttribute('class' , 'input-sm');
                   inputElem.setAttribute('placeholder' , $scope.metaData.columns[i].fieldLabel);
                 }
               } 
                var divElem = document.createElement('div');
                divElem.appendChild(ulElem);
                var viewElem = angular.element(divElem.innerHTML);
                var compileFn = $compile(viewElem);
                compileFn($scope);

                var items = $element.find("ul");
                for(var i=0; i<items.length;i++){
                     
                     if(items.eq(i).attr("id")=="filterActionsId"){
                           items.eq(i).replaceWith(viewElem);
                     }  
                }
                //alert(divElem.innerHTML);
         };


          /**
             Application des contraints sur les champs
          **/
         $scope.constraintsProvider = function(field , htmlElem){
            
             if(angular.isObject(field) && htmlElem){
               // console.log("$scope.constraintsProvider = function(field , htmlElem){ ==== "+field.optional+" ==== "+field.fieldName);
                  //Cas des champs obligatoire.
                  if(angular.isDefined(field.optional)&& !field.optional){                    
                      htmlElem.setAttribute("ng-required",true);
                  }

                  if(field.min && angular.isNumber(field.min)){
                      htmlElem.setAttribute("ng-minlength",field.min);
                      if(!angular.isDefined(field.optional) || field.optional){                    
                          htmlElem.setAttribute("ng-required",true);
                      }
                  }

                  if(field.max && angular.isNumber(field.max)){
                      htmlElem.setAttribute("ng-maxlength",field.max);
                  }

                  if(field.pattern && (field.type=="string") && angular.isString(field.pattern)){                    
                      htmlElem.setAttribute("ng-pattern",new RegExp(field.pattern));
                  }
                  
                  //Interdir de modification en mise a jour
                  if($scope.windowType=="update"&&$scope.innerWindowType!='new'){
                      if(!field.updatable){
                          htmlElem.setAttribute("readonly","readonly");
                      }
                  }


             }
         };
         
         /**
          * 
          * @param {type} model
          * @param {type} field
          * @param {type} labelText
          * @param {type} entityName
          * @param {type} type
          * @returns {undefined}
          */
         $scope.richEditorComponent = function(model , field , labelText, entityName,type){
             //console.log('$scope.richEditorComponent = '+model);
             var divElem = document.createElement('div'); //name='"+field.fieldName+"'
             divElem.innerHTML="<div text-angular ng-model="+model+"  ta-html-editor-class='border-around'>  </div>";
             //alert(divElem.innerHTML);
             if(field.hide){
                divElem.setAttribute('ng-hide',true);
            }//end if(field.hide)
            if(field.hidden!=null&&field.hidden.length>0){
                divElem.setAttribute('ng-hide',field.hidden);
            }//end if(field.hidden!=null&&field.hidden.length==0)
             return divElem;
         };
         
         /**
          * 
          * @param {type} model
          * @param {type} field
          * @param {type} labelText
          * @param {type} entityName
          * @param {type} type
          * @returns {principal_L351.principalAnonym$23.controller.$scope.richEditorComponent.divElem|Element}
          */
          $scope.aceEditorComponent = function(model , field , labelText, entityName,type){
             //console.log('$scope.aceEditorComponent = '+model);
             var divElem = document.createElement('div'); //name='"+field.fieldName+"'
             divElem.innerHTML="<div class='editor' ng-model="+model+"  data-ace=''>  </div>";
             //alert(divElem.innerHTML);
             if(field.hide){
                divElem.setAttribute('ng-hide',true);
             }//end if(field.hide)
             if(field.hidden!=null&&field.hidden.length>0){
                divElem.setAttribute('ng-hide',field.hidden);
             }//end if(field.hidden!=null&&field.hidden.length==0)
             return divElem;
         };

         /**
            Creation des composants
            model : field to map
            labelText : the Label of the input
            entityName : name of the entity
            type:type of data can be (text ,search, email ,url,tel,password,number ,
                                     datetime-local , date , month , week , time , color
                                     ,checkbox , radio  )
         ***/
         $scope.textAreaBuilder = function(model , field , labelText, entityName,type){
                   var divElem = document.createElement('div');
                   divElem.setAttribute('class' , 'form-group') ;                   
                   var labelElem = document.createElement('label');
                   labelElem.setAttribute('for' , field.fieldName);
                   labelElem.setAttribute('class' , "trt-label");
//                   labelElem.appendChild(document.createTextNode(labelText));  
                   labelElem.appendChild(document.createTextNode('{{"'+labelText+'" | cut:true:22:"..."}}')); 
                   divElem.appendChild(labelElem);
                   var textareaElem = document.createElement("textarea");
                   textareaElem.setAttribute('class' , 'form-control  trt-input');
                   if(angular.isDefined(field.optional)&&(!field.optional) || field.min){
                         textareaElem.setAttribute('class' , 'form-control required') ;        
                   }//end if(angular.isDefined(field.optional)&&(!field.optional) || field.min){
                   textareaElem.setAttribute('name' , field.fieldName);
                   textareaElem.setAttribute('placeholder' , labelText+" ....");
                   textareaElem.setAttribute('rows' ,'3');
                   textareaElem.setAttribute('ng-model' , model);
                   $scope.constraintsProvider(field , textareaElem);
                   if((($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))||(field.editable==false))){
                        if(($scope.metaData.desableupdate==false && $scope.innerWindowType!='new')){
                            textareaElem.setAttribute('readonly' , 'readonly');
                        }else{
                            if((field.updatable==false)||(field.editable==false)){
                                textareaElem.setAttribute('readonly' , 'readonly');
                            }//end if((field.updatable==false)||(field.editable==false)){
                        }
                    }//end if(($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')
                   divElem.appendChild(textareaElem);
                    if(field.hide){
                        divElem.setAttribute('ng-hide',true);
                    }//end if(field.hide)
                    if(field.hidden!=null&&field.hidden.length>0){
                        divElem.setAttribute('ng-hide',field.hidden);
                    }//end if(field.hidden!=null&&field.hidden.length==0)
                   return divElem;
              } 
        
       /**
        * 
        * @param {type} model
        * @param {type} field
        * @param {type} labelText
        * @param {type} entityName
        * @param {type} type
        * @returns {unresolved}
        */
         $scope.inputTextBuilder = function(model , field , labelText, entityName,type){
                   var divElem = document.createElement('div');
                   divElem.setAttribute('class' , 'form-group form-group-sm col-sm-12 col-md-12  trt-widget') ;                   
                   var labelElem = document.createElement('label');
                   labelElem.setAttribute('for' , field.fieldName);
                   labelElem.setAttribute('class' , "trt-label");
                   labelElem.appendChild(document.createTextNode('{{"'+labelText+'" | cut:true:22:"..."}}')); 
                   //Traitement des observable
                   if(field.observable==true){
                       var observable = new Observable();
                       $scope.observablePools[field.fieldName] = observable;
                   }//end if(field.observable==true)
                   if(field.observer!=null){
                       var observer = new Observer(field.observer,model);
                       if($scope.observablePools[field.observer.observable]){
                           observer.register($scope.observablePools[field.observer.observable]);
                       }else{
                            var observable = new Observable();
                            $scope.observablePools[field.observer.observable] = observable;
                            observer.register($scope.observablePools[field.observer.observable]);
                       }//end if($scope.observablePools[field.fieldName])
                   }//end if(field.observer!=null)
                   divElem.appendChild(labelElem);
                   //Creation du composant input
                    var inputElem = document.createElement('input');
                    inputElem.setAttribute('name' , field.fieldName);    
                    if(type!="checkbox"){
                        inputElem.setAttribute('class' , 'form-control trt-input');
                        inputElem.setAttribute('placeholder' , labelText+" .... ");
                        if(angular.isDefined(field.optional)&&(!field.optional)){
                                inputElem.setAttribute('class' , 'form-control required trt-input');
                                inputElem.setAttribute('ng-required' , 'true');
                         }//end if(angular.isDefined(field.optional)&&(!field.optional)) 
                         if((field.min && field.min>0)){
                             inputElem.setAttribute('ng-minlength' , field.min);
                         }//end if((field.min && field.min>0))
                         if(field.max && field.max>0){
                             inputElem.setAttribute('ng-maxlength' , field.max);
                         }//end if(field.max && field.max>0)
                         if(field.pattern){
                             inputElem.setAttribute('ng-pattern' , field.pattern);
                         }//end if(field.pattern)                         
                                   
                    }//end if(type!="checkbox"){
//                    console.log("================================ "+$scope.innerWindowType+"==============="+($scope.windowType=="view")+"===="+((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))+" === "+(field.editable==false)+" ================= "+(($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))||(field.editable==false)));
                    inputElem.setAttribute('type' , type);
//                    if(type=="file"){
//                         inputElem.setAttribute("onchange","angular.element(this).scope().gererChangementFichier3(event ,'"+model+"')");    
//                    }//end if(type=="file"){
                    inputElem.setAttribute('ng-model' , model);
                    $scope.constraintsProvider(field , inputElem);
                    if((($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))||(field.editable==false))){
                        if(($scope.metaData.desableupdate==false && $scope.innerWindowType!='new')){
                            inputElem.setAttribute('readonly' , 'readonly');
                        }else{
                            if((field.updatable==false)||(field.editable==false)){
                                inputElem.setAttribute('readonly' , 'readonly');
                            }//end if((field.updatable==false)||(field.editable==false)){
                        }
                    }//end if(($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')                    
                    if(field.hide){
                        divElem.setAttribute('ng-hide',true);
                    }//end if(field.hide)
                    if(field.hidden!=null&&field.hidden.length>0){
                        divElem.setAttribute('ng-hide',field.hidden);
                    }//end if(field.hidden!=null&&field.hidden.length==0)
                    divElem.appendChild(inputElem);              
                  return divElem;
              };
              
              /**
               * 
               * @param {type} field
               * @param {type} value
               * @returns {unresolved}
               */
           $scope.lineTextBuilder = function(field , value){
                   var divElem = document.createElement('div');
                   divElem.setAttribute('class' , 'form-group form-group-sm col-sm-12  col-md-12') ;                   
                   var labelElem = document.createElement('span');
//                   labelElem.setAttribute('for' , field.fieldName);
                  labelElem.appendChild(document.createTextNode(field.fieldLabel));
                   divElem.appendChild(labelElem);
                   //Creation du composant input
                    var inputElem = document.createElement('span');
//                    inputElem.setAttribute('name' , field.fieldName);                
//                    console.log("================================ "+$scope.innerWindowType+"==============="+($scope.windowType=="view")+"===="+((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))+" === "+(field.editable==false)+" ================= "+(($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))||(field.editable==false)));
                     if(angular.isObject(value)){
                       inputElem.appendChild(document.createTextNode(value['designation']));
                   }else if(value){
                       inputElem.appendChild(document.createTextNode(value));
                   }else{
                       inputElem.appendChild(document.createTextNode(""));
                   }
                   if(field.hide){
                        divElem.setAttribute('ng-hide',true);
                    }//end if(field.hide)
                    if(field.hidden!=null&&field.hidden.length>0){
                        divElem.setAttribute('ng-hide',field.hidden);
                    }//end if(field.hidden!=null&&field.hidden.length==0)
                    divElem.appendChild(inputElem);              
                  return divElem;
              };

         /**
            Creation des composants
            model : field to map
            labelText : the Label of the input
            entityName : name of the entity
            type:type of data can be (text ,search, email ,url,tel,password,number ,
                                     datetime-local , date , month , week , time , color
                                     ,checkbox , radio  )
         ***/
         $scope.checkboxBuilder = function(model , field , labelText, entityName,type){
                   var divElem = document.createElement('div');
                   divElem.setAttribute('class' , 'form-check  col-sm-12  col-md-12') ;    
//                   divElem.setAttribute('class' , 'form-group  col-sm-12  col-md-12') ;  
                   var labelElem = document.createElement('label');
                   labelElem.setAttribute('class' ,'trt-label');
                   labelElem.setAttribute('for' , field.fieldName);
                   divElem.appendChild(labelElem);
                   //Creation du composant input
                    var inputElem = document.createElement('input');
                    inputElem.setAttribute('type' , 'checkbox');
//                    inputElem.setAttribute('class' ,'form-contol');
                    //inputElem.setAttribute('checked' , '');
                    inputElem.setAttribute('data-toggle' , 'toggle');
                    inputElem.setAttribute('ng-model' , model);
                    inputElem.setAttribute('name' , field.fieldName);       
                    $scope.constraintsProvider(field , inputElem);
                    if(($scope.windowType=="view")||
                            ((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType==false))||(field.editable==false)){
                        if($scope.metaData.desableupdate==false && $scope.innerWindowType!='new'){
                            inputElem.setAttribute('ng-disabled', 'true'); 
                        }//end if($scope.metaData.desableupdate==false){
                    }//end if(($scope.windowType=="view")||
                    divElem.appendChild(inputElem);  
//                    labelElem.appendChild(document.createTextNode(labelText)); 
                    labelElem.appendChild(document.createTextNode('{{"'+labelText+'" | cut:true:22:"..."}}')); 
                    if(field.hide){
                        divElem.setAttribute('ng-hide',true);
                    }//end if(field.hide)
                    if(field.hidden!=null&&field.hidden.length>0){
                        divElem.setAttribute('ng-hide',field.hidden);
                    }//end if(field.hidden!=null&&field.hidden.length==0)
                   //Traitement des observable
                   if(field.observable==true){
                       var observable = new Observable();
                       $scope.observablePools[field.fieldName] = observable;
                   }//end if(field.observable==true)
                   if(field.observer!=null){
                       var observer = new Observer(field.observer,model);
                       if($scope.observablePools[field.observer.observable]){
                           observer.register($scope.observablePools[field.observer.observable]);
                       }else{
                            var observable = new Observable();
                            $scope.observablePools[field.observer.observable] = observable;
                            observer.register($scope.observablePools[field.observer.observable]);
                       }//end if($scope.observablePools[field.fieldName])
                   }//end if(field.observer!=null)
//                    var divElem0 = document.createElement('div');
//                   divElem0.appendChild(divElem);
//                  
//                  alert(divElem0.innerHTML);
                  return divElem;
              } ;
              /**
               * 
               * @param {type} model
               * @param {type} field
               * @param {type} labelText
               * @param {type} entityName
               * @param {type} type
               * @returns {unresolved}
               */
           $scope.radioboxBuilder = function(model , field , labelText, entityName,value){
                   //Input fields
                   var inputs = new Array(); 
                   var divElem = document.createElement('div');
                   divElem.setAttribute('class' , 'form-check  col-sm-12  col-md-12') ;    
//                   divElem.setAttribute('class' , 'form-group  col-sm-12  col-md-12') ;  
                   var labelElem = document.createElement('label');
                   labelElem.setAttribute('class' ,'trt-label');
                   labelElem.setAttribute('for' , field.fieldName);
                   divElem.appendChild(labelElem);
                   var div00 = document.createElement('div');
                   divElem.appendChild(div00);
                   var values = value.split(';');
                   for(var i=0 ; i<values.length;i++){
                       var div001 = document.createElement('div');
                       div001.setAttribute('class' ,'trt-radio');
                       var labelElem = document.createElement('label');
                       div001.appendChild(labelElem);
                       labelElem.setAttribute('class' ,'form-check-label');
                       var inputElem = document.createElement('input');
                       labelElem.appendChild(inputElem);
                       inputs.push(inputElem);
                       labelElem.appendChild(document.createTextNode(values[i]));
                       inputElem.setAttribute('class' , 'form-check-input');
                       inputElem.setAttribute('type' , 'radio');
                       inputElem.setAttribute('name' , field.fieldName);
                       inputElem.setAttribute('id' , field.fieldName+"_"+values[i]);
                       inputElem.setAttribute('data-toggle' , 'toggle');
                       inputElem.setAttribute('ng-model' , model);
                       inputElem.setAttribute('value' , ''+i);
                       div00.appendChild(div001);
                   }//end for(var i=0 ; i<values.length;i++){                   
//                    $scope.constraintsProvider(field , inputElem);
                    if(($scope.windowType=="view")||
                            ((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType==false))||(field.editable==false)){
                        if($scope.metaData.desableupdate==false && $scope.innerWindowType!='new'){
                            for(var i=0;i<inputs.length;i++){
                                inputs[i].setAttribute('ng-disabled', 'true'); 
                            }//end for(var i=0;i<inputs.length;i++){
                        }//end if($scope.metaData.desableupdate==false){
                    }//end if(($scope.windowType=="view")||
                    divElem.appendChild(div00);  
                    labelElem.appendChild(document.createTextNode('{{"'+labelText+'" | cut:true:22:"..."}}')); 
//                    labelElem.appendChild(document.createTextNode(labelText)); 
                    if(field.hide){
                        divElem.setAttribute('ng-hide',true);
                    }//end if(field.hide)
                    if(field.hidden!=null&&field.hidden.length>0){
                        divElem.setAttribute('ng-hide',field.hidden);
                    }//end if(field.hidden!=null&&field.hidden.length==0)
                   //Traitement des observable
                   if(field.observable==true){
                       var observable = new Observable();
                       $scope.observablePools[field.fieldName] = observable;
                   }//end if(field.observable==true)
                   if(field.observer!=null){
                       var observer = new Observer(field.observer,model);
                       if($scope.observablePools[field.observer.observable]){
                           observer.register($scope.observablePools[field.observer.observable]);
                       }else{
                            var observable = new Observable();
                            $scope.observablePools[field.observer.observable] = observable;
                            observer.register($scope.observablePools[field.observer.observable]);
                       }//end if($scope.observablePools[field.fieldName])
                   }//end if(field.observer!=null)
//                    var divElem0 = document.createElement('div');
//                   divElem0.appendChild(divElem);
//                  
//                  alert(divElem0.innerHTML);
                  return divElem;
              } ;
          /**
           * 
           * @param {type} key
           * @returns {undefined}
           */
        $scope.imageClick = function(key){
            $("#"+key).trigger('click');
//            console.log('$scope.imageClick ==========================='+key);
         };
        
         /**
          * 
          * @param {type} imageChooserInput
          * @param {type} imageContent
          * @param {type} apercuImageContent
          * @returns {undefined}
          */ 
        $scope.gererChangementImage = function(event,model,imageChooserInput,imageContent,apercuImageContent,field){
              //Initiallisation du tableau des images
              var part =model.split(",");
              var subpart = part[0].split(".");
              var fileInput = document.querySelector('#'+imageChooserInput);
              var file = event.target.files[0];              
              var allowedTypes = ['png', 'jpg', 'jpeg', 'gif'];
              var imgType = file.name.split(".");
              var date = new Date();
              var filename = date.getTime()+".png";
              field = subpart[1];
              var data = $scope.currentObject;
              if(angular.lowercase(subpart[0])!="currentobject"){
                  data = $scope.temporalData;
              }
//              console.log("$scope.gererChangementImage = function(imageChooserInput,imageContent,apercuImageContent) ======= "+field+" === "+data[field]);
              if(!data[field]||data[field]==""){
                  data[field] = filename;
              }else{
                  filename = data[field];
              }
              imgType = imgType[imgType.length-1].toLowerCase();
              if(allowedTypes.indexOf(imgType)!=-1){
                  var reader = new FileReader();
                  reader.onload = function(){
                      var imgElement = document.querySelector('#'+imageContent);      
		      imgElement.src = this.result;   
                  };
                  reader.readAsDataURL(file);
              }
              if(!$scope.dataCache['resources']){
                  $scope.dataCache['resources'] = new Array();
              }
              if(!$scope.dataCache['names']){
                  $scope.dataCache['names'] = new Array();
              }
//              var map = new Map();
//              map.set(filename,file);
              $scope.dataCache['resources'].push(file);
              $scope.dataCache['names'].push(filename);
              //commonsTools.gererChangementImage(imageChooserInput,imageContent,apercuImageContent);
         };
         
         /**
          * 
          * @param {type} event
          * @param {type} model
          * @param {type} inputID
          * @param {type} imageContent
          * @returns {undefined}
          */
         $scope.gererChangementFichier = function(event){
              //Initiallisation du tableau des images
//              var fileInput = document.querySelector('#'+inputID);
//              console.log("$scope.gererChangementFichier = function(event) =============== ");
             var file = event.target.files[0];              
              var imgType = file.name.split(".");
              imgType = imgType[imgType.length - 1].toLowerCase();
              var date = new Date();
              var filename = date.getTime()+"."+imgType;             
              if(!$scope.dataCache['resources']){
                  $scope.dataCache['resources'] = new Array();
              }
              if(!$scope.dataCache['names']){
                  $scope.dataCache['names'] = new Array();
              }
//              var map = new Map();
//              map.set(filename,file);
              $scope.dataCache['resources'].push(file);
              $scope.dataCache['names'].push(filename);
              //transfert des resources et mise a jour du menu
              var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/piecejointe";
              var data = {id:-1,compareid:-1,designation:"",editTitle:""
                    ,listTitle:"",moduleName:'kerencore',selected:false,createonfield:true,desablecreate:false,
                    serial:"1234",activefilelien:false,desabledelete:false,filename:filename,attachename:file.name,entityserial:$scope.currentObject.serial,entityid:$scope.currentObject.id};
             commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
             $http.post(url,data)
                      .then(function(response){
                           var url2 = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/upload";
                           $http.defaults.headers.common['names']= angular.toJson($scope.dataCache['names']); 
                                                restService.uploadFile($scope.dataCache['resources'])
                                                    .then(function(response){
//                                                        alert(angular.toJson(response))                                                          
                                                        $scope.dataCache['resources'] = new Array();
                                                        $scope.dataCache['names'] = new Array(); 
                                                        commonsTools.hideDialogLoading();
                                                        $scope.piecejointeMenu(null,$scope.currentObject,$scope.metaData);
                                                    },function(error){
                                                        $scope.dataCache['resources'] = new Array();
                                                        $scope.dataCache['names'] = new Array();   
                                                        commonsTools.hideDialogLoading();
                                                        $scope.notifyWindow("ERREUR" ,"Le transfert des ressources a Ã©chouÃ© <br> Veuillez consulter les logs pour plus de dÃ©tails","success");
                                                    });     
                      },function(error){
                          commonsTools.showMessageDialog(error);
                          commonsTools.hideDialogLoading();
                      }); 
             //commonsTools.gererChangementImage(imageChooserInput,imageContent,apercuImageContent);
         
         
         };
         
        /**
         * 
         * @param {type} model
         * @param {type} field
         * @param {type} labelText
         * @param {type} entityName
         * @param {type} type
         * @returns {Element}
         */
        $scope.imageComponentBuilder = function(model , field , labelText, entityName,type){
                   var part = model.split(".");
                   var data = $scope.currentObject;
                   if(angular.lowercase(part[0])!="currentobject"){
                       data = $scope.temporalData;
                   }//end if(angular.lowercase(part[0])!="currentobject"){
//                   var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/png/"+(data[field.fieldName]);
//                   console.log("$scope.imageComponentBuilder ============== "+angular.toJson(data)+"====="+data[field.fieldName]+" ==== "+field.fieldName);  
                   var parts = model.split('.');
                   var divElem = document.createElement('div');
                   divElem.setAttribute('id',parts[1]+'ImageContent');
                   divElem.setAttribute('class','form-group  col-sm-12  col-md-12');
                   //divElem.setAttribute('style','width:10px;');
                   var imgElem = document.createElement('img');
                   imgElem.setAttribute('id',parts[1]+'apercuImageContent');
//                   imgElem.setAttribute('ng-src',url);
                   imgElem.setAttribute('ng-src',"img\\photo.png");
                   imgElem.setAttribute('class','img-responsive');
                   imgElem.setAttribute('alt',field.fieldLabel);
                   imgElem.setAttribute('height','80');
                   imgElem.setAttribute('width','100');
                   imgElem.setAttribute('ng-click',"imageClick('"+parts[1]+"imageChooserInput')");
                   divElem.appendChild(imgElem);
                   var inputElem = document.createElement('input');
                   inputElem.setAttribute('id',parts[1]+'imageChooserInput');
                   inputElem.setAttribute('style','display: none');
                   inputElem.setAttribute('type','file');
                   inputElem.setAttribute('fileinput','file');
                   var vname = field.fieldName;
                   inputElem.setAttribute('onchange',"angular.element(this).scope().gererChangementImage(event,'"+model+","+parts[1]+"imageChooserInput','"+parts[1]+"imageContent' ,'"+parts[1]+"apercuImageContent','"+vname+"')");
                   inputElem.setAttribute('filepreview',"'"+model+"'");
                   inputElem.setAttribute('accept','image/x-png');
                   divElem.appendChild(inputElem);
                   restService.downloadPNG(data[field.fieldName],parts[1]+'apercuImageContent');
//                   var scriptElem = document.createElement('script');
//                   scriptElem.innerHTML="gererChangementImage('"+parts[1]+"imageChooserInput','"+parts[1]+"imageContent' ,'"+parts[1]+"apercuImageContent')";
//                   divElem.appendChild(scriptElem);
//                   var div = document.createElement('div');
//                   div.appendChild(divElem);
//                   alert(div.innerHTML);
                   return divElem;
              };  

/**
 * 
 * @param {type} filename
 * @param {type} position
 * @returns {undefined}
 */
         $scope.imageloader = function(filename, position){
             restService.downloadPNG(filename,position);
             return "img\\photo.png";
         };
        /**
         * 
         * @param {type} model
         * @param {type} field
         * @param {type} labelText
         * @param {type} entityName
         * @param {type} type
         * @returns {Element}
         */
        $scope.emptyComponentBuilder = function(model , field , labelText, entityName,type){
                   var divElem = document.createElement('div');
                   divElem.setAttribute('class' , 'form-group  col-sm-12  col-md-12') ;
                   
                   var labelElem = document.createElement('span');
                   labelElem.setAttribute('for' , field.fieldName);
                   //labelElem.appendChild(document.createTextNode(labelText)); 
                   divElem.appendChild(labelElem);
                   //Creation du composant input
                  var inputElem = document.createElement('label');
                  inputElem.setAttribute('class' , 'form-control-plaintext');
                  //inputElem.setAttribute('style','border-style:none;');
                  //inputElem.setAttribute('name' , entityName);
                  //inputElem.setAttribute('placeholder' , labelText+" .... ");
                   if($scope.windowType=="view"||(field.updatable==false&&$scope.windowType!='new')){
                        inputElem.setAttribute('readonly' , 'readonly');
                    }
                  //inputElem.setAttribute('type' , type);
                  //inputElem.setAttribute('ng-model' , model);
                  divElem.appendChild(inputElem);
                  var divElem0 = document.createElement('div');
                  divElem0.appendChild(divElem);
                  
                  //alert(divElem0.innerHTML);
                  return divElem;
              } ;       
        

/**
 * 
 * @param {type} event
 * @returns {undefined}
 */
   $scope.gererChangementFichier2 = function(event){
              //Initiallisation du tableau des images
//              var fileInput = document.querySelector('#'+inputID);
//              console.log("$scope.gererChangementFichier = function(event) =============== ");
             var file = event.target.files[0];              
              var imgType = file.name.split(".");
              imgType = imgType[imgType.length - 1].toLowerCase();
              var date = new Date();
              var filename = date.getTime()+"."+imgType;             
              if(!$scope.dataCache['resources']){
                  $scope.dataCache['resources'] = new Array();
              }//end if(!$scope.dataCache['resources'])
              if(!$scope.dataCache['names']){
                  $scope.dataCache['names'] = new Array();
              }//end if(!$scope.dataCache['names'])
//              var map = new Map();
//              map.set(filename,file);
              $scope.dataCache['resources'].push(file);
              $scope.dataCache['names'].push(filename);
              //transfert des resources et mise a jour du menu
//              var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/piecejointe";
              var data = {id:-1,compareid:-1,designation:"",editTitle:""
                    ,listTitle:"",moduleName:'kerencore',selected:false,createonfield:true,desablecreate:false,
                    serial:"1234",activefilelien:false,desabledelete:false,filename:filename,attachename:file.name,entityserial:null,entityid:null};
             $scope.dataCache["messageobject"].piecesjointe.push(data);
             commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
//             var url2 = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/temporalupload";
//             console.log("$scope.gererChangementFichier = function(event) =============== "+angular.toJson($scope.dataCache["messageobject"]));
            $http.defaults.headers.common['names']= angular.toJson($scope.dataCache['names']); 
            restService.uploadFile2($scope.dataCache['resources'])
                .then(function(response){//                                                        alert(angular.toJson(response))                                                          
                    $scope.dataCache['resources'] = new Array();
                    $scope.dataCache['names'] = new Array(); 
                    $scope.followerpiecejointeMenu($scope.dataCache["messageobject"]);
                    commonsTools.hideDialogLoading();                                                        
                },function(error){
                    $scope.dataCache['resources'] = new Array();
                    $scope.dataCache['names'] = new Array();   
                    commonsTools.hideDialogLoading();
                    commonsTools.showDialogLoading(error);
//                    commonsTools.notifyWindow("ERREUR" ,"Le transfert des ressources a Ã©chouÃ© <br> Veuillez consulter les logs pour plus de dÃ©tails","success");
                }); 
                      
             //commonsTools.gererChangementImage(imageChooserInput,imageContent,apercuImageContent);
         
         
         };
/**
 * 
 * @param {type} event
 * @returns {undefined}
 */
$scope.gererChangementFichier3 = function(event,model){
              //Initiallisation du tableau des images
//              var fileInput = document.querySelector('#'+inputID);
              var file = event.target.files[0];              
//              console.log("$scope.gererChangementFichier3 = function(event) =============== "+file.name+" === "+model);
              var imgType = file.name.split(".");
              imgType = imgType[imgType.length - 1].toLowerCase();
              var date = new Date();
              var filename = file.name; 
              $scope.dataCache['model'] = model;
              if(!$scope.dataCache['resources']){
                  $scope.dataCache['resources'] = new Array();
              }//end if(!$scope.dataCache['resources'])
              if(!$scope.dataCache['names']){
                  $scope.dataCache['names'] = new Array();
              }//end if(!$scope.dataCache['names'])
//              var map = new Map();
//              map.set(filename,file);
              $scope.dataCache['resources'].push(file);
              $scope.dataCache['names'].push(filename);
              //transfert des resources et mise a jour du menu
//              var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/piecejointe";
//              var data = {id:-1,compareid:-1,designation:"",editTitle:""
//                    ,listTitle:"",moduleName:'kerencore',selected:false,createonfield:true,desablecreate:false,
//                    serial:"1234",activefilelien:false,desabledelete:false,filename:filename,attachename:file.name,entityserial:null,entityid:null};
//             $scope.dataCache["messageobject"].piecesjointe.push(data);
             commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
//             var url2 = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/temporalupload";
//             console.log("$scope.gererChangementFichier = function(event) =============== "+angular.toJson($scope.dataCache["messageobject"]));
            $http.defaults.headers.common['names']= angular.toJson($scope.dataCache['names']); 
            restService.uploadFile2($scope.dataCache['resources'])
                .then(function(response){//                                                        alert(angular.toJson(response))                                                          
                    $scope.dataCache['resources'] = new Array();
                    $scope.dataCache['names'] = new Array(); 
                    var part = $scope.dataCache['model'].split(".");
                    var vmodel = $scope.getParentModel($scope.dataCache['model']);
                    vmodel[part[part.length-1]] = filename;
//                    $scope.followerpiecejointeMenu($scope.dataCache["messageobject"]);
                    commonsTools.hideDialogLoading();                                                        
                },function(error){
                    $scope.dataCache['resources'] = new Array();
                    $scope.dataCache['names'] = new Array();   
                    commonsTools.hideDialogLoading();
                    commonsTools.showDialogLoading(error);
//                    commonsTools.notifyWindow("ERREUR" ,"Le transfert des ressources a Ã©chouÃ© <br> Veuillez consulter les logs pour plus de dÃ©tails","success");
                }); 
                      
             //commonsTools.gererChangementImage(imageChooserInput,imageContent,apercuImageContent);
         
         
         };
         $scope.gererChangementFichier4 = function(event){
              //Initiallisation du tableau des images
//              var fileInput = document.querySelector('#'+inputID);
              var file = event.target.files[0];              
//              console.log("$scope.gererChangementFichier4 = function(event) =============== "+file.name+" === ");
              var imgType = file.name.split(".");
              imgType = imgType[imgType.length - 1].toLowerCase();
              var date = new Date();
              var filename = file.name; 
//              $scope.dataCache['model'] = model;
              if(!$scope.dataCache['resources']){
                  $scope.dataCache['resources'] = new Array();
              }//end if(!$scope.dataCache['resources'])
              if(!$scope.dataCache['names']){
                  $scope.dataCache['names'] = new Array();
              }//end if(!$scope.dataCache['names'])
//              var map = new Map();
//              map.set(filename,file);
              $scope.dataCache['resources'].push(file);
              $scope.dataCache['names'].push(filename);
              //transfert des resources et mise a jour du menu
//              var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/piecejointe";
//              var data = {id:-1,compareid:-1,designation:"",editTitle:""
//                    ,listTitle:"",moduleName:'kerencore',selected:false,createonfield:true,desablecreate:false,
//                    serial:"1234",activefilelien:false,desabledelete:false,filename:filename,attachename:file.name,entityserial:null,entityid:null};
//             $scope.dataCache["messageobject"].piecesjointe.push(data);
             commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
//             var url2 = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/temporalupload";
//             console.log("$scope.gererChangementFichier = function(event) =============== "+angular.toJson($scope.dataCache["messageobject"]));
            $http.defaults.headers.common['names']= angular.toJson($scope.dataCache['names']); 
            restService.uploadFile2($scope.dataCache['resources'])
                .then(function(response){//                                                        alert(angular.toJson(response))                                                          
                    $scope.dataCache['resources'] = new Array();
                    $scope.dataCache['names'] = new Array(); 
//                    var part = $scope.dataCache['model'].split(".");
//                    var vmodel = $scope.getParentModel($scope.dataCache['model']);
//                    vmodel[part[part.length-1]] = filename;
//                    $scope.followerpiecejointeMenu($scope.dataCache["messageobject"]);
                      $scope.importData.fichier = filename;
                    commonsTools.hideDialogLoading();                                                        
                },function(error){
                    $scope.dataCache['resources'] = new Array();
                    $scope.dataCache['names'] = new Array();   
                    commonsTools.hideDialogLoading();
                    commonsTools.showDialogLoading(error);
//                    commonsTools.notifyWindow("ERREUR" ,"Le transfert des ressources a Ã©chouÃ© <br> Veuillez consulter les logs pour plus de dÃ©tails","success");
                }); 
                      
             //commonsTools.gererChangementImage(imageChooserInput,imageContent,apercuImageContent);
         
         
         };
        /**
             Create component for ManyToOne relashion 
             model : field to map
            labelText : the Label of the input
            entityName : name of the entity,
            metaData : MetaData which describe de object
        **/
        $scope.comboBoxComponent = function(model , field , labelText , entityName,value){
               //Creation de l'entree
                //var exprFn = $parse(model) 
                //var data = exprFn($scope);
                var parts = value.split(";");
                
               //console.log("$scope.manyToOneComponent    ===      "+model+" :::::::  !!!!!!!! "+metaData.entityName);
               var divElem = document.createElement('div');
               divElem.setAttribute('class' , 'form-group form-group-sm col-sm-12 col-md-12 trt-widget');
               var labelElem = document.createElement('label');
               labelElem.setAttribute('for' , field.fieldName);
               labelElem.setAttribute('class' , 'trt-label');
//               labelElem.appendChild(document.createTextNode(labelText));
               labelElem.appendChild(document.createTextNode('{{"'+labelText+'" | cut:true:22:"..."}}')); 
               divElem.appendChild(labelElem);
               var divElem_1 = document.createElement('div');
               divElem_1.setAttribute('class','input-group trt-select');
               divElem.appendChild(divElem_1);
               var selectElem = document.createElement('select');
               selectElem.setAttribute('class','form-control');
               selectElem.setAttribute('data-style' , 'btn-default');
               selectElem.setAttribute('ng-model' , model);
               selectElem.setAttribute('ng-change' , "getComboboxData('"+field.fieldName+"')");
               divElem_1.appendChild(selectElem);
              //selectElem.setAttribute('ng-options' , "item as item.designation for item in dataCache."+parts[1]);
              $scope.constraintsProvider(field , selectElem);
//              if($scope.windowType=="view"||(field.updatable&&field.updatable==false&&$scope.windowType!='new'&&$scope.innerWindowType==false)){
//                  selectElem.setAttribute('disabled' , 'disabled');
//              }
              if((($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))||(field.editable==false))){
                    if(($scope.metaData.desableupdate==false && $scope.innerWindowType!='new')){
                       selectElem.setAttribute('disabled' , 'true');
                    }else{
                        if((field.updatable==false)||(field.editable==false)){
                            selectElem.setAttribute('disabled' , 'true');
                        }//end if((field.updatable==false)||(field.editable==false)){
                    }
              }//end if(($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')
              var optionElem = document.createElement('option');
              optionElem.setAttribute('value' , '');
              optionElem.appendChild(document.createTextNode('Please select option'));
              selectElem.appendChild(optionElem);
              for(var i=0 ; i<parts.length;i++){
                  var optionElem = document.createElement('option');
                  optionElem.setAttribute('value' , ""+i);
                  optionElem.appendChild(document.createTextNode(parts[i]));
                  selectElem.appendChild(optionElem);
                  //console.log("comboBoxComponent ===== "+i+" ====== "+parts[i]);   
              }             
              if(field.hide){
                divElem.setAttribute('ng-hide',true);
              }//end if(field.hide)
              if(field.hidden!=null&&field.hidden.length>0){
                    divElem.setAttribute('ng-hide',field.hidden);
              }//end if(field.hidden!=null&&field.hidden.length==0)
              //Traitement des observable
                if(field.observable==true){
                    var observable = new Observable();
                    $scope.observablePools[field.fieldName] = observable;
                }//end if(field.observable==true)
                if(field.observer!=null){
                    var observer = new Observer(field.observer,model);
                    if($scope.observablePools[field.observer.observable]){
                        observer.register($scope.observablePools[field.observer.observable]);
                    }else{
                         var observable = new Observable();
                         $scope.observablePools[field.observer.observable] = observable;
                         observer.register($scope.observablePools[field.observer.observable]);
                    }//end if($scope.observablePools[field.fieldName])
                }//end if(field.observer!=null)
              return divElem;
        };
        
        /**
         * 
         * @param {type} model
         * @param {type} labelText
         * @param {type} entityName
         * @param {type} metaData
         * @param {type} field
         * @param {type} index
         * @param {type} modelpath
         * @returns {unresolved}
         */
        $scope.oneToOneComponent = function(model , labelText , entityName,metaData,field,index,modelpath){ 
//               $scope.currentMetaDataPath = $scope.getMetaDataPath(metaData);
               //Creation de l'entree
               //Filter criteria
               var key = commonsTools.keygenerator(model);
               if(angular.isDefined($scope.filtertemplate)){
                    $scope.filtertemplate[""+key+""] = field.filter ;
               }//end if(angular.isDefined($scope.filtertemplate)){
               var exprFn = $parse(model); 
                var data = exprFn($scope);
                var parts = model.split(".");
//                var key = commonsTools.keygenerator(model);
                if(parts.length>1){
                    $scope.dataCache[""+key+""] = new Array();
                    if(data && angular.isDefined(data.id)){
                      $scope.dataCache[""+key+""].push(data);
                    }
                    var obj = {id:'load' , designation:'Charger les données ....'};
//                    if($scope.dataCache[parts[1]]&&$scope.dataCache[parts[1]].length>0){
//                        obj = {id:'loadwithsearch' , designation:'Chercher plus ...'};
//                    }
                    $scope.dataCache[""+key+""].push(obj);
                }//end if(parts.length>1){
                console.log("$scope.manyToOneComponent ============== filter : "+field.filter+" fieldName :"+field.fieldName+" index : "+index+" ==== model : "+model+" :::: key:"+key+" == "+angular.toJson($scope.dataCache[""+key+""]+" === teplatefilter:"+$scope.filtertemplate[key]));
               //console.log("$scope.manyToOneComponent    ===      "+model+" :::::::  !!!!!!!! "+metaData.entityName);
               var divElem = document.createElement('div');
               divElem.setAttribute('class' , 'form-group form-group-sm col-sm-12  col-md-12 trt-widget');
               var labelElem = document.createElement('label');
               labelElem.setAttribute('for' , entityName);
               labelElem.setAttribute('class' , 'trt-label');
//               labelElem.appendChild(document.createTextNode(labelText));
               labelElem.appendChild(document.createTextNode('{{"'+labelText+'" | cut:true:22:"..."}}')); 
               divElem.appendChild(labelElem);
               var divElem_1 = document.createElement('div');
               divElem_1.setAttribute('class','input-group trt-onetoone');
               divElem_1.setAttribute('id' , 'onetoone-'+field.fieldName);
               divElem.appendChild(divElem_1);
               var selectElem = document.createElement('select');
               selectElem.setAttribute('class','selectpicker form-control trt-onetoone-select');
               selectElem.setAttribute('id' , 'select-'+field.fieldName);
               selectElem.setAttribute('data-style' , 'btn-default');
               selectElem.setAttribute('ng-model' , model);
               if(angular.isString(index)){
                   index = new Number(index);
               }//end if(angular.isString(index)){
               selectElem.setAttribute('ng-options' , "item as item.designation for item in dataCache."+key);              
               selectElem.setAttribute('ng-change'  , "getData('"+model+"',item,'"+metaData.entityName+"','"+metaData.moduleName+"',"+(index+1)+",'"+modelpath+"','"+modelpath+"')");
               selectElem.setAttribute('data-live-search','true');
               divElem_1.appendChild(selectElem);
               var optionElem = document.createElement('option');
              optionElem.setAttribute('value' , '');
              optionElem.appendChild(document.createTextNode('Please select option'));
              selectElem.appendChild(optionElem);
              //if((($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))||(field.editable==false))){
              selectElem.setAttribute('disabled' , 'true');
              //Desactiver la creation
            var spanElem = document.createElement('span');
            spanElem.setAttribute('class' , 'input-group-btn');
            divElem_1.appendChild(spanElem);
            var buttonElem = document.createElement('button');
            buttonElem.setAttribute('class' , 'btn btn-default btn-sm my-group-button');
            var item = $scope.getCurrentModel(model);
            if(item && item.id>0){
               buttonElem.setAttribute('ng-click' , "editDialogBuilder('"+model+"',null,'new','"+metaData.entityName+"','"+metaData.moduleName+"',"+(index+1)+",'"+modelpath+"')"); 
            }else{
                buttonElem.setAttribute('ng-click' , "editDialogBuilder('"+model+"',null,'update','"+metaData.entityName+"','"+metaData.moduleName+"',"+(index+1)+",'"+modelpath+"')");
            }//end if(item && item.id>0){
            buttonElem.setAttribute('data-toggle' , "modal");            
//            buttonElem.setAttribute('data-target' , '#myModal');
            var nextIndex = index+1;            
            if(nextIndex==1){
                buttonElem.setAttribute('data-target', '#myModal');   
            }else if( nextIndex==2){
                buttonElem.setAttribute('data-target', '#globalModal');
            }else if( nextIndex==3){
                buttonElem.setAttribute('data-target', '#myModal1');
            }else if( nextIndex==4){
                buttonElem.setAttribute('data-target', '#myModal2');
            }//end if(index==1)           
            spanElem.appendChild(buttonElem);            
            var spanElem_1 = document.createElement('span');
            spanElem_1.setAttribute('class','glyphicon glyphicon-plus');
            spanElem_1.setAttribute('aria-hidden' , 'true');
            spanElem_1.setAttribute('style' , 'color:blue');
            buttonElem.appendChild(spanElem_1);
            if(($scope.windowType=="view")||(metaData.createonfield==false)||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType==false))){
                buttonElem.setAttribute('disabled' , 'disabled');
            }//end if(($scope.windowType=="view")||(metaData.createonfield==false)  
            if(field.editable==false){
                buttonElem.setAttribute('disabled' , 'disabled');
                selectElem.setAttribute('disabled' , 'true');
            }//end if(field.editable==false)
            if(field.hide){
                divElem.setAttribute('ng-hide',true);
            }//end if(field.hide)
            if(field.hidden!=null&&field.hidden.length>0){
                divElem.setAttribute('ng-hide',field.hidden);
            }//end if(field.hidden!=null&&field.hidden.length==0)
//            console.log("$scope.manyToOneComponent = ======= mode :"+model+" ====== entityname:"+metaData.entityName+" === field:"+field.fieldName+" === index:"+index+" ==== path:"+modelpath+" ===== key:"+key+" ==== observable : "+field.observable+" ==== observer : "+angular.toJson(field.observer));
               //Traitement des observable
            if(field.observable==true){
                var observable = new Observable();
                $scope.observablePools[field.fieldName] = observable;
            }//end if(field.observable==true)
            if(field.observer!=null){
                var observer = new Observer(field.observer,model);
                if($scope.observablePools[field.observer.observable]){
                    observer.register($scope.observablePools[field.observer.observable]);
                }else{
                     var observable = new Observable();
                     $scope.observablePools[field.observer.observable] = observable;
                     observer.register($scope.observablePools[field.observer.observable]);
                }//end if($scope.observablePools[field.fieldName])
            }//end if(field.observer!=null)            
              return divElem;
        };

        /**
             Create component for ManyToOne relashion 
             model : field to map
            labelText : the Label of the input
            entityName : name of the entity,
            metaData : MetaData which describe de object
        **/
        $scope.manyToOneComponent = function(model , labelText , entityName,metaData,field,index,modelpath){ 
//               $scope.currentMetaDataPath = $scope.getMetaDataPath(metaData);
               //Creation de l'entree
               //Filter criteria
               var key = commonsTools.keygenerator(model);
               if(angular.isDefined($scope.filtertemplate)){
                    $scope.filtertemplate[""+key+""] = field.filter ;
               }//end if(angular.isDefined($scope.filtertemplate)){
               var exprFn = $parse(model); 
                var data = exprFn($scope);
                var parts = model.split(".");
//                var key = commonsTools.keygenerator(model);
                if(parts.length>1){
                    $scope.dataCache[""+key+""] = new Array();
                    if(data && angular.isDefined(data.id)){
                      $scope.dataCache[""+key+""].push(data);
                    }
                    var obj = {id:'load' , designation:'Charger les données ....'};
//                    if($scope.dataCache[parts[1]]&&$scope.dataCache[parts[1]].length>0){
//                        obj = {id:'loadwithsearch' , designation:'Chercher plus ...'};
//                    }
                    $scope.dataCache[""+key+""].push(obj);
                }//end if(parts.length>1){
//                console.log("$scope.manyToOneComponent ============== filter : "+field.filter+" fieldName :"+field.fieldName+" index : "+index+" ==== model : "+model+" :::: key:"+key+" == "+angular.toJson($scope.dataCache[""+key+""]+" === teplatefilter:"+$scope.filtertemplate[key]));
               //console.log("$scope.manyToOneComponent    ===      "+model+" :::::::  !!!!!!!! "+metaData.entityName);
               var divElem = document.createElement('div');
               divElem.setAttribute('class' , 'form-group form-group-sm col-sm-12  col-md-12 trt-widget');
               var labelElem = document.createElement('label');
               labelElem.setAttribute('for' , entityName);
               labelElem.setAttribute('class' , 'trt-label');
//               labelElem.appendChild(document.createTextNode(labelText));
               labelElem.appendChild(document.createTextNode('{{"'+labelText+'" | cut:true:22:"..."}}')); 
               divElem.appendChild(labelElem);
               var divElem_1 = document.createElement('div');
               divElem_1.setAttribute('class','input-group trt-manytoone');
               divElem_1.setAttribute('id' , 'manytoone-'+field.fieldName);
               divElem.appendChild(divElem_1);
               var selectElem = document.createElement('select');
               selectElem.setAttribute('class','selectpicker form-control trt-manytoone-select');
               selectElem.setAttribute('id' , 'select-'+field.fieldName);
               selectElem.setAttribute('data-style' , 'btn-default');
               selectElem.setAttribute('ng-model' , model);
               if(angular.isString(index)){
                   index = new Number(index);
               }//end if(angular.isString(index)){
               selectElem.setAttribute('ng-options' , "item as item.designation for item in dataCache."+key);              
               selectElem.setAttribute('ng-change'  , "getData('"+model+"',item,'"+metaData.entityName+"','"+metaData.moduleName+"',"+(index+1)+",'"+modelpath+"','"+modelpath+"')");
               selectElem.setAttribute('data-live-search','true');
               divElem_1.appendChild(selectElem);
               var optionElem = document.createElement('option');
              optionElem.setAttribute('value' , '');
              optionElem.appendChild(document.createTextNode('Please select option'));
              selectElem.appendChild(optionElem);
              //if((($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))||(field.editable==false))){
             if((($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))||(field.editable==false))){
                if(($scope.metaData.desableupdate==false && $scope.innerWindowType!='new')){
                    selectElem.setAttribute('disabled' , 'true');
////                    buttonElem.setAttribute('disabled' , 'disabled');
                }else{
                    if((field.updatable==false)||(field.editable==false)){
                       selectElem.setAttribute('disabled' , 'true');
////                    buttonElem.setAttribute('disabled' , 'disabled');
                    }//end if((field.updatable==false)||(field.editable==false)){
                }
            }//end if(($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')
              //Desactiver la creation
            var spanElem = document.createElement('span');
            spanElem.setAttribute('class' , 'input-group-btn');
            divElem_1.appendChild(spanElem);
            var buttonElem = document.createElement('button');
            buttonElem.setAttribute('class' , 'btn btn-default btn-sm my-group-button');
            buttonElem.setAttribute('ng-click' , "editDialogBuilder('"+model+"',null,'new_entity','"+metaData.entityName+"','"+metaData.moduleName+"',"+(index+1)+",'"+modelpath+"')");
            buttonElem.setAttribute('data-toggle' , "modal");            
//            buttonElem.setAttribute('data-target' , '#myModal');
            var nextIndex = index+1;            
            if(nextIndex==1){
                buttonElem.setAttribute('data-target', '#myModal');   
            }else if( nextIndex==2){
                buttonElem.setAttribute('data-target', '#globalModal');
            }else if( nextIndex==3){
                buttonElem.setAttribute('data-target', '#myModal1');
            }else if( nextIndex==4){
                buttonElem.setAttribute('data-target', '#myModal2');
            }//end if(index==1)           
            spanElem.appendChild(buttonElem);            
            var spanElem_1 = document.createElement('span');
            spanElem_1.setAttribute('class','glyphicon glyphicon-plus');
            spanElem_1.setAttribute('aria-hidden' , 'true');
            spanElem_1.setAttribute('style' , 'color:blue');
            buttonElem.appendChild(spanElem_1);
            if(($scope.windowType=="view")||(metaData.createonfield==false)||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType==false))){
                buttonElem.setAttribute('disabled' , 'disabled');
            }//end if(($scope.windowType=="view")||(metaData.createonfield==false)  
            if(field.editable==false){
                buttonElem.setAttribute('disabled' , 'disabled');
                selectElem.setAttribute('disabled' , 'true');
            }//end if(field.editable==false)
            if(field.hide){
                divElem.setAttribute('ng-hide',true);
            }//end if(field.hide)
            if(field.hidden!=null&&field.hidden.length>0){
                divElem.setAttribute('ng-hide',field.hidden);
            }//end if(field.hidden!=null&&field.hidden.length==0)
//            console.log("$scope.manyToOneComponent = ======= mode :"+model+" ====== entityname:"+metaData.entityName+" === field:"+field.fieldName+" === index:"+index+" ==== path:"+modelpath+" ===== key:"+key+" ==== observable : "+field.observable+" ==== observer : "+angular.toJson(field.observer));
               //Traitement des observable
            if(field.observable==true){
                var observable = new Observable();
                $scope.observablePools[field.fieldName] = observable;
            }//end if(field.observable==true)
            if(field.observer!=null){
                var observer = new Observer(field.observer,model);
                if($scope.observablePools[field.observer.observable]){
                    observer.register($scope.observablePools[field.observer.observable]);
                }else{
                     var observable = new Observable();
                     $scope.observablePools[field.observer.observable] = observable;
                     observer.register($scope.observablePools[field.observer.observable]);
                }//end if($scope.observablePools[field.fieldName])
            }//end if(field.observer!=null)            
              return divElem;
        };

/**
 * 
 * @param {type} model
 * @param {type} labelText
 * @param {type} entityName
 * @param {type} metaData
 * @param {type} field
 * @param {type} index
 * @param {type} modelpath
 * @returns {unresolved}
 */
       $scope.fileLinkComponent = function(model , labelText , entityName,metaData,field,index,modelpath){ 
//               $scope.currentMetaDataPath = $scope.getMetaDataPath(metaData);              
//                console.log("$scope.manyToOneComponent ============== filter : "+field.filter+" fieldName :"+field.fieldName+" index : "+index+" ==== model : "+model+" :::: key:"+key+" == "+angular.toJson($scope.dataCache[""+key+""]+" === teplatefilter:"+$scope.filtertemplate[key]));
    
            var divElem = document.createElement('div');
            divElem.setAttribute('class' , 'form-group form-group-sm col-sm-12  col-md-12');
            var labelElem = document.createElement('label');
            labelElem.setAttribute('for' , field.fieldName+"_lb");
//            labelElem.appendChild(document.createTextNode(labelText));
            labelElem.appendChild(document.createTextNode("{{'"+labelText+"' | cut:true:22:'...'}}")); 
            divElem.appendChild(labelElem);
            var divElem_1 = document.createElement('div');
            divElem_1.setAttribute('class','input-group');
            divElem.appendChild(divElem_1);
            labelElem = document.createElement('label');
            labelElem.setAttribute('for' , field.fieldName+"_fe");
            var aElem = document.createElement("a");
            aElem.setAttribute("href","");
            aElem.setAttribute("ng-click","downloadAction('"+model+"' ,'"+field.fieldName+"')");
            aElem.appendChild(document.createTextNode("{{"+model+"}}"));
            labelElem.appendChild(aElem);
            divElem_1.appendChild(labelElem);
              //Desactiver la creation
            var spanElem = document.createElement('span');
            spanElem.setAttribute('class' , 'input-group-btn');
            divElem_1.appendChild(spanElem);
            var buttonElem = document.createElement('button');$scope.imageClick()
            buttonElem.setAttribute('class' , 'btn btn-default btn-sm my-group-button');
            buttonElem.setAttribute('ng-click' , "imageClick('"+field.fieldName+"_pj')");
            buttonElem.setAttribute('data-toggle' , "modal");            
//            buttonElem.setAttribute('data-target' , '#myModal');           
            spanElem.appendChild(buttonElem);            
            var spanElem_1 = document.createElement('span');
            spanElem_1.setAttribute('class','glyphicon glyphicon-paperclip');
            spanElem_1.setAttribute('aria-hidden' , 'true');
            spanElem_1.setAttribute('style' , 'color:blue');
            buttonElem.appendChild(spanElem_1);
            if(($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType==false))){
                buttonElem.setAttribute('disabled' , 'disabled');
            }//end if(($scope.windowType=="view")||(metaData.createonfield==false)|  
            if(field.editable==false){
                buttonElem.setAttribute('disabled' , 'disabled');               
            }//end if(field.editable==false)
            if(field.hide){
                divElem.setAttribute('ng-hide',true);
            }//end if(field.hide)
            if(field.hidden!=null&&field.hidden.length>0){
                divElem.setAttribute('ng-hide',field.hidden);
            }//end if(field.hidden!=null&&field.hidden.length==0)   
            var inputElem = document.createElement("input");
            inputElem.setAttribute("type", "file");
            inputElem.setAttribute("onchange", "angular.element(this).scope().gererChangementFichier3(event,'"+model+"')");
            inputElem.setAttribute("id",field.fieldName+"_pj");
            inputElem.setAttribute("ng-hide","true") ;
            divElem.appendChild(inputElem);
           return divElem;
        };

         /**
          * 
          * @param {type} model
          * @param {type} labelText
          * @param {type} entityName
          * @param {type} metaData
          * @param {type} field
          * @param {type} index
          * @param {type} modelpath
          * @returns {Element}
          */
        $scope.manyToManyComponent = function(model , labelText , entityName,metaData,field,index,modelpath){
               var exprFn = $parse(model) 
                var data = exprFn($scope);
                var parts = model.split(".");
                var key = commonsTools.keygenerator(model);
                if(parts.length>1){
                    $scope.dataCache[""+key+""] = new Array();
                    if(data){
                       for(var i=0 ; i<data.length;i++){
                           $scope.dataCache[""+key+""].push(data[i]);
                       }                       
                    }
                    var obj = {id:'load' , designation:'Charger les donnÃ©es ....'};
//                    if($scope.dataCache[parts[1]]&&$scope.dataCache[parts[1]].length>0){
//                        obj = {id:'loadwithsearch' , designation:'Chercher plus ....'};
//                    }
                    $scope.dataCache[""+key+""].push(obj);
                }
//                console.log("$scope.manyToManyComponent = === "+model+" ==== "+parts[1]);
//               $scope.currentMetaDataPath = $scope.getMetaDataPath(metaData);
               var divElem = document.createElement('div');
               divElem.setAttribute('class' , 'form-group form-group-sm col-sm-12  col-md-12 trt-widget');
               var labelElem = document.createElement('label');
               labelElem.setAttribute('for' , entityName);
               labelElem.setAttribute('class' , 'trt-label');
               labelElem.appendChild(document.createTextNode('{{"'+labelText+'" | cut:true:22:"..."}}'));  
//               labelElem.appendChild(document.createTextNode(labelText));
               divElem.appendChild(labelElem);
               var divElem_1 = document.createElement('div');
               divElem_1.setAttribute('class','input-group trt-manytoone');
               divElem_1.setAttribute('id','manytomany-'+field.fieldName);
               divElem.appendChild(divElem_1);
               var selectElem = document.createElement('select');
               selectElem.setAttribute('class','selectpicker form-control trt-manytoone-select');
               selectElem.setAttribute('id' , 'select-'+field.fieldName);
               selectElem.setAttribute('multiple' , 'multiple');
               selectElem.setAttribute('data-style' , 'btn-default');
               selectElem.setAttribute('data-selected-text-format' , 'count > 4');
               selectElem.setAttribute('data-live-search','true');
               selectElem.setAttribute('ng-model' , model);
               selectElem.setAttribute('ng-change' , "getData('"+model+"',item,'"+metaData.entityName+"','"+metaData.moduleName+"',"+(index+1)+",'"+modelpath+"')");
               divElem_1.appendChild(selectElem);  
//               if(($scope.windowType=="view")||
//                        ((angular.isDefined(field) &&angular.isDefined(field.updatable) && field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType==false))){
//                    selectElem.setAttribute('disabled' , 'true');                    
//                }
                if((($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType!='new'))||(field.editable==false))){
                    if(($scope.metaData.desableupdate==false && $scope.innerWindowType!='new')){
                        selectElem.setAttribute('disabled' , 'true'); 
                    }else{
                        if((field.updatable==false)||(field.editable==false)){
                            selectElem.setAttribute('disabled' , 'true'); 
                        }//end if((field.updatable==false)||(field.editable==false)){
                    }
                }//end if(($scope.windowType=="view")||((field.updatable==false)&&($scope.windowType!='new')
               var key = commonsTools.keygenerator(model);
               $scope.filtertemplate[key] = field.filter ;
              selectElem.setAttribute('ng-options' , "item as item.designation for item in dataCache."+key);
              var optionElem = document.createElement('option');
              optionElem.setAttribute('value' , '');
              optionElem.appendChild(document.createTextNode('Please select option'));
              selectElem.appendChild(optionElem);
              //Desactiver la creation
              
                var spanElem = document.createElement('span');
                spanElem.setAttribute('class' , 'input-group-btn');
                divElem_1.appendChild(spanElem);
                var buttonElem = document.createElement('button');
                buttonElem.setAttribute('class' , 'btn btn-default btn-sm my-group-button');
                buttonElem.setAttribute('ng-click' , "editDialogBuilder('"+model+"',null,'new_entity','"+metaData.entityName+"','"+metaData.moduleName+"',"+(index+1)+",'"+modelpath+"')");
                buttonElem.setAttribute('data-toggle' , "modal");
//                buttonElem.setAttribute('data-target' , '#myModal');
                var nextIndex = index+1;   
                if(nextIndex==1){
                    buttonElem.setAttribute('data-target', '#myModal');   
                }else if( nextIndex==2){
                    buttonElem.setAttribute('data-target', '#globalModal');
                }else if( nextIndex==3){
                    buttonElem.setAttribute('data-target', '#myModal1');
                }else if( nextIndex==4){
                    buttonElem.setAttribute('data-target', '#myModal2');
                }//end if(index==1)           
                spanElem.appendChild(buttonElem);
                
                var spanElem_1 = document.createElement('span');
                spanElem_1.setAttribute('class','glyphicon glyphicon-plus');
                spanElem_1.setAttribute('aria-hidden' , 'true');
                spanElem_1.setAttribute('style' , 'color:blue');
                buttonElem.appendChild(spanElem_1);
//                console.log("ManyToMany =================== "+angular.toJson(field));
                if(($scope.windowType=="view"||metaData.createonfield==false)||((field.updatable==false)&&($scope.windowType!='new')&&($scope.innerWindowType==false))){
                    buttonElem.setAttribute('disabled' , 'disabled');
                }   
                if(field.editable==false){
                    buttonElem.setAttribute('disabled' , 'disabled');
                    selectElem.setAttribute('disabled' , 'true');
                }//end if(field.editable==false)
                if(field.hide){
                    divElem.setAttribute('ng-hide',true);
                }//end if(field.hide)
                if(field.hidden!=null&&field.hidden.length>0){
                      divElem.setAttribute('ng-hide',field.hidden);
                }//end if(field.hidden!=null&&field.hidden.length==0)
                //Traitement des observable
                if(field.observable==true){
                    var observable = new Observable();
                    $scope.observablePools[field.fieldName] = observable;
                }//end if(field.observable==true)
                if(field.observer!=null){
                    var observer = new Observer(field.observer,model);
                    if($scope.observablePools[field.observer.observable]){
                        observer.register($scope.observablePools[field.observer.observable]);
                    }else{
                         var observable = new Observable();
                         $scope.observablePools[field.observer.observable] = observable;
                         observer.register($scope.observablePools[field.observer.observable]);
                    }//end if($scope.observablePools[field.fieldName])
                }//end if(field.observer!=null)
                return divElem;
        };
 
        /**
          Construction du chemin de la metadata
          @metaData : 
        **/
        $scope.getMetaDataPath = function(metaData){
             //console.log('Cas des groupes' +$scope.metaData.groups);
             var path = 'metaData';             

             if(($scope.metaData.entityName==metaData.entityName)){
                  return path;
             }else{
                 var subPath = '';
                 //Recherche parmi les columns
                 if(angular.isDefined($scope.metaData.columns)&&($scope.metaData.columns.length>0)){
                      for(var i=0 ; i< $scope.metaData.columns.length;i++){
                           if(($scope.metaData.columns[i].type=='array')||($scope.metaData.columns[i].type=='object')){
                                 if($scope.metaData.columns[i].metaData.entityName==metaData.entityName){
                                   // console.log(metaData.entityName+" ===== "+$scope.metaData.columns[i].metaData.entityName);
                                      subPath = 'metaData.columns['+i+'].metaData';
                                      return subPath;
                                 }//end if
                           }//end if
                      }//end for
                 }// end if

                 //Recherche dans les groupes
                 if(angular.isDefined($scope.metaData.groups)&&($scope.metaData.groups.length>0)){
                      
                      for(var i=0 ; $scope.metaData.groups.length ; i++){                             
                          //Cas des metaArray
                          if($scope.metaData.groups[i]&&$scope.metaData.groups[i].metaArray){
                             if($scope.metaData.groups[i].metaArray.metaData.entityName==metaData.entityName){
                                    return 'metaData.groups['+i+'].metaArray.metaData';
                             }
                         }//end if($scope.metaData.groups[i]&&$scope.metaData.groups[i].metaArray)
                          //Cas des columns
                         if($scope.metaData.groups[i]&&$scope.metaData.groups[i].columns&&($scope.metaData.groups[i].columns.length>0)){
                               for(var j=0 ; j< $scope.metaData.groups[i].columns.length;j++){
                                   if(($scope.metaData.groups[i].columns[j].type=='array')||($scope.metaData.groups[i].columns[j].type=='object')){                                       
                                       //  console.log($scope.metaData.groups[i].columns[j].type+" =====  entiyName :"+$scope.metaData.groups[i].columns[j].metaData.entityName+" == metaData.entityName : "+metaData.entityName);
                                        if($scope.metaData.groups[i].columns[j].metaData.entityName!=metaData.entityName){                                              
                                              subPath = 'metaData.groups['+i+'].columns['+j+'].metaData';
                                              return subPath;
                                         }//end if

                                   }//end if
                              }//end for
                         }
                      }
                 }
             }
        };

        /**
         * 
         * @param {type} model
         * @param {type} labelText
         * @param {type} entityName
         * @param {type} metaData
         * @param {type} field
         * @param {type} index
         * @param {type} modelpath
         * @param {type} editable
         * @returns {undefined}
         */
        $scope.oneToManyComponent = function(model , labelText , entityName ,metaData,field,index,modelpath,editable){
//            console.log("$scope.oneToManyComponent = function(model , labelText , entityName ,metaData,field,index,modelpath,editable) =========== "+editable);
            if(angular.isDefined(editable) && editable==true){
                return $scope.oneToManyComponentEditable(model , labelText , entityName ,metaData,field,index,modelpath);
            }else{
                return $scope.oneToManyComponentNoneditable(model , labelText , entityName ,metaData,field,index,modelpath);
            }//end if(angular.isDefined(editable) && editable==true)
        };//$scope.oneToManyComponent = function(model , labelText , entityName ,metaData,field,index,modelpath)
        
        /**
            Creation d'un composant table avec possibilte ajout modif suppression et consultation
            model : field to map
            labelText : the Label of the input
            entityName : name of the entity,
            metaData : MetaData which describe de object
        **/
        $scope.oneToManyComponentNoneditable = function(model , labelText , entityName ,metaData,field,index,modelpath){
            
//             $scope.currentMetaDataPath = $scope.getMetaDataPath(metaData);
//              console.log("$scope.oneToManyComponent = === "+model+"==="+labelText+" == "+"=== "+entityName+" == "+index+" === field : "+); 
             var divElem = document.createElement('div');
             divElem.setAttribute('class' , 'table-responsive');
             //Ajout d'un champs input de type hidden pour stocker le model
             var inputHidden = document.createElement('input');
             ///inputHidden.setAttribute('type' , 'hidden')
             //inputHidden.setAttribute('id',)
             var tableElem = document.createElement('table');
             tableElem.setAttribute('class','table table-sm table-striped table-bordered table-hover table-condensed');
             divElem.appendChild(tableElem);
             var theadElem = document.createElement('thead');
             tableElem.appendChild(theadElem);
             var trElem = document.createElement('tr');
             trElem.setAttribute('class' , 'table-header');
             theadElem.appendChild(trElem);
             //console.log(metaData);
             var columnNumber = 0 ;
             var fieldnames = new Array();
             for(var i = 0 ; i < metaData.columns.length;i++){
                 if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search){
                   var thElem = document.createElement('th');
                   thElem.setAttribute("ng-click","tableSorter('"+model+"' , '"+metaData.columns[i].fieldName+"')");
                   //Span Glyphicon
                   thElem.innerHTML = metaData.columns[i].fieldLabel+" <span ng-show=down('"+metaData.columns[i].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.columns[i].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                   trElem.appendChild(thElem);
                   fieldnames.push(metaData.columns[i].fieldName);
                   columnNumber++;
                 }//end if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i]
             }//end for(var i = 0 ; i < metaData.columns.length;i++){
             //Traitement  des champs des groupes
             if(metaData.groups&&metaData.groups.length>0){
                 for(var i=0;i<metaData.groups.length;i++){
                     //Cas des columns
                     if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                          for(var j = 0 ; j < metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search){
                              var thElem = document.createElement('th');
                              thElem.setAttribute("ng-click","tableSorter('"+model+"' , '"+metaData.groups[i].columns[j].fieldName+"')");
                              thElem.innerHTML = metaData.groups[i].columns[j].fieldLabel+" <span ng-show=down('"+metaData.groups[i].columns[j].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.groups[i].columns[j].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                              trElem.appendChild(thElem);
                              fieldnames.push(metaData.groups[i].columns[j].fieldName);
                              columnNumber++;
                            }//end  if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search)
                        }//end for(var j = 0 ; j < metaData.groups[i].columns.length;j++)
                     }//end if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0)                     
                 }//end for(var i=0;i<metaData.groups.length;i++)
             }//end if(metaData.groups&&metaData.groups.length>0){
             var thElem = document.createElement('th');
             trElem.appendChild(thElem);
             //alert(columnNumber);
             var nextIndex = index +1 ;
             //Creation du corps du tableau
             var tbodyElem = document.createElement('tbody');
             tableElem.appendChild(tbodyElem);
              if(metaData.createonfield==true){  
                    //Creation de la ligne des actions
                    var trElem = document.createElement('tr');
                    trElem.setAttribute("ng-hide","windowType=='view'");
                    tbodyElem.appendChild(trElem);
                    var tdElem = document.createElement('td');
                    trElem.appendChild(tdElem);
                    tdElem.setAttribute("colspan" , columnNumber+1);                   
                    if(($scope.windowType!="view")
                            ||($scope.metaData.desableupdate==true&&($scope.innerWindowType=="new"||$scope.innerWindowType=="update"))){
                        var aElem = document.createElement('a');
                        tdElem.appendChild(aElem);
                        aElem.setAttribute('href' , '#');
                        //Diseable si ajout impossible               
                       aElem.setAttribute('disabled' , 'disabled');
                       aElem.setAttribute('data-toggle' , "modal");
                       if(nextIndex==1){
                           aElem.setAttribute('data-target', '#myModal');   
                       }else if( nextIndex==2){
                           aElem.setAttribute('data-target', '#globalModal');
                       }else if( nextIndex==3){
                           aElem.setAttribute('data-target', '#myModal1');
                       }else if( nextIndex==4){
                           aElem.setAttribute('data-target', '#myModal2');
                       }//end if(index==1)           
                       aElem.setAttribute('ng-click' , "editDialogBuilder('"+model+"',null,'new',null,null,+"+(nextIndex)+",'"+modelpath+"')");                      
                       aElem.appendChild(document.createTextNode("Ajouter un element"));
                       aElem.setAttribute('disabled' , 'disabled');                  
                    }//end if($scope.windowType=="view"){           
               }//end if(metaData.createonfield==true)
             
             //Construction du corps du tableau
             trElem = document.createElement('tr');
             trElem.setAttribute('style' ,"cursor: pointer;");
             tbodyElem.appendChild(trElem);
             trElem.setAttribute('ng-repeat' , 'item in '+model);
             //alert(metaData.columns.length);
             for(var i=0 ; i< metaData.columns.length;i++){
                if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search){
                     var tdElem = document.createElement('td');
                     if(metaData.columns[i].type!='array'&& metaData.columns[i].type!='object'&& metaData.columns[i].type!='combobox'&&metaData.columns[i].type!='boolean'){
                         if(metaData.columns[i].type=='number'){
                            tdElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+'}}'));
                            tdElem.setAttribute('class','text-right');
                         }else if(metaData.columns[i].type=='date'){
                             if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                 tdElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+' | date:"'+$rootScope.globals.langue.formatDate+'"}}'));
                             }else{
                                 tdElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+' | date:"dd-MM-yyyy"}}'));
                             }//end if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                         }else{
                             tdElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+'}}'));
                         }//end if(metaData.columns[i].type=='number'){
                     }else if(metaData.columns[i].type=='object'){
                          //console.log("$scope.oneToManyComponent ============= "+"{{item."+metaData.columns[i].fieldName+"['designation']}}");
                          tdElem.appendChild(document.createTextNode("{{item."+metaData.columns[i].fieldName+"['designation']}}"));
                     }else if(metaData.columns[i].type=='combobox'){
                         tdElem.appendChild(document.createTextNode("{{comboboxselctionvalues(item."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}"));
                     }else if(metaData.columns[i].type=='boolean'){
                         var input = document.createElement('input');
                         input.setAttribute('type' , 'checkbox');
                         input.setAttribute('ng-model' , 'item.'+metaData.columns[i].fieldName);
                         tdElem.appendChild(input);
                     }//end if(metaData.columns[i].type!='array'&& metaData.columns[i].type!='object')
                     tdElem.setAttribute('data-toggle' , "modal");
                     //tdElem.setAttribute('data-target' , '#myModal');
                     if(nextIndex==1){
                        tdElem.setAttribute('data-target', '#myModal');   
                     }else if( nextIndex==2){
                        tdElem.setAttribute('data-target', '#globalModal');
                     }else if( nextIndex==3){
                        tdElem.setAttribute('data-target', '#myModal1');
                     }else if( nextIndex==4){
                        tdElem.setAttribute('data-target', '#myModal2');
                     }//end if(index==1)           
                     tdElem.setAttribute('ng-click',"editDialogBuilder('"+model+"' ,item,'update',null,null,"+(nextIndex)+",'"+modelpath+"')");    
                     trElem.appendChild(tdElem);
                 }//end if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search)
             }//end for(var i=0 ; i< metaData.columns.length;i++){
             //Traitement  des champs des groupes
             if(metaData.groups&&metaData.groups.length>0){
                 for(var i=0;i<metaData.groups.length;i++){
                     //Cas des columns
                     if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                          for(var j = 0 ; j < metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search){
                                var tdElem = document.createElement('td');
                                if(metaData.groups[i].columns[j].type!='array'&& metaData.groups[i].columns[j].type!='object'
                                        && metaData.groups[i].columns[j].type!='combobox' && metaData.groups[i].columns[j].type!='boolean'){
                                    if(metaData.groups[i].columns[j].type=='date'){
                                        if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                            tdElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+' | date:"'+$rootScope.globals.langue.formatDate+'"}}')); 
                                        }else{
                                            tdElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+' | date:"dd-MM-yyyy"}}'));  
                                        }//end if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){                                                                             
                                    }else if(metaData.groups[i].columns[j].type=='number'){
                                        tdElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+'}}'));
                                        tdElem.setAttribute('class','text-right');
                                    }else{
                                        tdElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+'}}'));
                                    }//end if(metaData.groups[i].columns[j].type=='number'){
                                }else if(metaData.groups[i].columns[j].type=='object'){
                                    tdElem.appendChild(document.createTextNode("{{item."+metaData.groups[i].columns[j].fieldName+"['designation']}}"));
                                }else if(metaData.groups[i].columns[j].type=='combobox'){
                                    tdElem.appendChild(document.createTextNode("{{comboboxselctionvalues(item."+metaData.groups[i].columns[j].fieldName+",'"+metaData.groups[i].columns[j].value+"')}}"));
                                }else if(metaData.groups[i].columns[j].type=='boolean'){
                                    var input = document.createElement('input');
                                    input.setAttribute('type' , 'checkbox');
                                    input.setAttribute('ng-model' , 'item.'+metaData.groups[i].columns[j].fieldName);
                                    tdElem.appendChild(input);
                                }//end if(metaData.columns[i].type!='array'&& metaData.columns[i].type!='object')
                                tdElem.setAttribute('data-toggle' , "modal");
                                 if(nextIndex==1){
                                    tdElem.setAttribute('data-target', '#myModal');   
                                 }else if( nextIndex==2){
                                    tdElem.setAttribute('data-target', '#globalModal');
                                 }else if( nextIndex==3){
                                    tdElem.setAttribute('data-target', '#myModal1');
                                 }else if( nextIndex==4){
                                    tdElem.setAttribute('data-target', '#myModal2');
                                 }//end if(index==1)           
                                tdElem.setAttribute('ng-click',"editDialogBuilder('"+model+"' ,item,'update',null,null,"+(nextIndex)+",'"+modelpath+"')");    
                                trElem.appendChild(tdElem);
                            }//end if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search)
                        }//end for(var j = 0 ; j < metaData.groups[i].columns.length;j++)
                     }//end if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0)                     
                 }//end for(var i=0;i<metaData.groups.length;i++)
             }
             var key = commonsTools.keygenerator(modelpath);
            //construction du pied de tableau            
             if(field.customfooter==false){
                var sources = model.split(".");    
                $scope.dataCache[key+"foot"] = null;
                var footerElem = document.createElement('tfoot');
                footerElem.setAttribute("id",key);
                if(fieldnames.length>0){
                    for(var i=0 ;  i<fieldnames.length ; i++){
                        var thelem = document.createElement('th');
                        footerElem.appendChild(thelem);
                        var data = $scope.currentObject;
                        if(sources[0]!='currentObject'){
                            data = $scope.dataCache[""+key];
                        }//end if(model!='currentObject')
//                        console.log("$scope.oneToManyComponent &&&&&& === "+fieldnames[i]+"===="+field.fieldName+"===="+angular.toJson(data));
                        if(data){
                            var total = commonsTools.sumTableField(fieldnames[i],data[field.fieldName]);
                            if(total){
                                thelem.appendChild(document.createTextNode(total));
                                thelem.setAttribute('class','text-center');
                            }//end if(total)
                        }//end if(data)
                    }//end for(var i=0 ;  i<fieldnames.length ; i++)
                    tableElem.appendChild(footerElem);
                }//end if(fieldnames.length>0)
            }else{
                var sources = model.split(".");   
                $scope.dataCache[key+"foot"] = field.footerScript;
                var data = $scope.currentObject;
                if(sources[0]!='currentObject'){
                     data = $scope.dataCache[""+key];//data = $scope.temporalData;
                }//end if(model!='currentObject')
                if(data){
//                    var piedElem = commonsTools.tableFooterBuilder(field.footerScript,data[field.fieldName],sources[1],key);  
                    var piedElem = commonsTools.tableFooterBuilder(field.footerScript,data[field.fieldName],sources[1],$scope.currentObject,$scope.currentUser);  
                    tableElem.appendChild(piedElem);
                }//end if(data)
            }//end if(field.customfooter)
            if(metaData.createonfield==true && !$scope.isviewOperation()){
             //Suppression
                tdElem = document.createElement('td');
                trElem.appendChild(tdElem);
                aElem = document.createElement('a');
                aElem.setAttribute('href' , '#');
                aElem.setAttribute('ng-click' , "removeFromTable('"+model+"',item,'"+modelpath+"')"); 
                tdElem.appendChild(aElem);
                var spanElem = document.createElement('span');
                spanElem.setAttribute('class' , 'glyphicon glyphicon-trash');
                spanElem.setAttribute('aria-hidden' , 'true');
                aElem.appendChild(spanElem);
                if(($scope.windowType=="view")){
                     aElem.setAttribute('disabled' , 'disabled');                  
                 }//end if($scope.windowType=="view"){            
            }else{
                tdElem = document.createElement('td');
                trElem.appendChild(tdElem);
            }//end if(metaData.createonfield==true)
            if(field.hide){
               divElem.setAttribute('ng-hide',true);
            }//end if(field.hide)
            if(field.hidden!=null&&field.hidden.length>0){
                   divElem.setAttribute('ng-hide',field.hidden);
            }//end if(field.hidden!=null&&field.hidden.length==0)
            //Traitement des observable
            if(field.observable==true){
                var observable = new Observable();
                $scope.observablePools[field.fieldName] = observable;
            }//end if(field.observable==true)
            if(field.observer!=null){
                var observer = new Observer(field.observer,model);
                if($scope.observablePools[field.observer.observable]){
                    observer.register($scope.observablePools[field.observer.observable]);
                }else{
                     var observable = new Observable();
                     $scope.observablePools[field.observer.observable] = observable;
                     observer.register($scope.observablePools[field.observer.observable]);
                }//end if($scope.observablePools[field.fieldName])
            }//end if(field.observer!=null)
             /*alert($scope.currentObject.actions);
             var divElem0 = document.createElement('div');
             divElem0.appendChild(divElem);
             alert(divElem0.innerHTML);*/
             return divElem;
        };
        
        /**
         * 
         * @param {type} model
         * @param {type} fieldname
         * @returns {undefined}
         */
        $scope.tableSorter = function(model , fieldname){
//            console.log("$scope.tableSorter = function(model , fieldname) ============ model : "+model+" ========= champs : "+fieldname);
            var part = model.split(".");
            var datas = $scope.getParentModel(model);
             if($scope.currentSort.column==fieldname){
                 $scope.currentSort.reverse = !$scope.currentSort.reverse;
             }else{
                 $scope.currentSort.column = fieldname;
                 $scope.currentSort.reverse = false;
             }//end if($scope.currentSort.column==fieldname)
//             console.log("$scope.listeSorter = function(fieldname)============= column : "+$scope.currentSort.column+"  reverse : "+$scope.currentSort.reverse);
             datas[part[part.length-1]] = $filter('orderBy')(datas[part[part.length-1]],fieldname,$scope.currentSort.reverse);
//             if($scope.currentSort.reverse==true){
//                  datas[part[part.length-1]] = $filter('orderBy')( datas[part[part.length-1]],"-"+fieldname,false);
//             }else {
//                    datas[part[part.length-1]] = $filter('orderBy')( datas[part[part.length-1]],fieldname,false);
//             }//end if($scope.currentSort.reverse==true)
        };
        /**
         * 
         * @param {type} model
         * @param {type} labelText
         * @param {type} entityName
         * @param {type} metaData
         * @param {type} field
         * @param {type} index
         * @param {type} modelpath
         * @returns {unresolved}
         */
        $scope.oneToManyComponentEditable = function(model , labelText , entityName ,metaData,field,index,modelpath){
//             $scope.currentMetaDataPath = $scope.getMetaDataPath(metaData);
//              console.log("$scope.oneToManyComponent = === "+model+"==="+labelText+" == "+"=== "+entityName+" == "+index); 
             $scope.dataCache[modelpath+"_field"] = field;
//             var divElem = document.createElement('div');
//             divElem.setAttribute('class' , 'table-responsive');
             //Ajout d'un champs input de type hidden pour stocker le model
             var inputHidden = document.createElement('input');
             ///inputHidden.setAttribute('type' , 'hidden')
             //inputHidden.setAttribute('id',)
             var tableElem = document.createElement('table');
             tableElem.setAttribute('class','table table-sm table-striped table-bordered table-hover table-condensed');
//             divElem.appendChild(tableElem);
             var theadElem = document.createElement('thead');
             tableElem.appendChild(theadElem);
             var trElem = document.createElement('tr');
             trElem.setAttribute('class' , 'table-header');
             theadElem.appendChild(trElem);
             //console.log(metaData);
             var columnNumber = 0 ;
             var fieldnames = new Array();
             for(var i = 0 ; i < metaData.columns.length;i++){
                 if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search){
                   var thElem = document.createElement('th');
                    thElem.setAttribute("ng-click","tableSorter('"+model+"' , '"+metaData.columns[i].fieldName+"')");
                   //Span Glyphicon
                   thElem.innerHTML = metaData.columns[i].fieldLabel+" <span ng-show=down('"+metaData.columns[i].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.columns[i].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                   trElem.appendChild(thElem);
                   fieldnames.push(metaData.columns[i].fieldName);
                   columnNumber++;
                 }//end if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search){
             }
             //Traitement  des champs des groupes
             if(metaData.groups&&metaData.groups.length>0){
                 for(var i=0;i<metaData.groups.length;i++){
                     //Cas des columns
                     if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                          for(var j = 0 ; j < metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search){
                              var thElem = document.createElement('th');
                               thElem.setAttribute("ng-click","tableSorter('"+model+"' , '"+metaData.groups[i].columns[j].fieldName+"')");
                               //Span Glyphicon
                               thElem.innerHTML = metaData.columns[i].fieldLabel+" <span ng-show=down('"+metaData.groups[i].columns[j].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.groups[i].columns[j].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                               trElem.appendChild(thElem);
                              fieldnames.push(metaData.groups[i].columns[j].fieldName);
                              columnNumber++;
                            }//end  if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search)
                        }//end for(var j = 0 ; j < metaData.groups[i].columns.length;j++)
                     }//end if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0)                     
                 }//end for(var i=0;i<metaData.groups.length;i++)
             }//end if(metaData.groups&&metaData.groups.length>0){
             var thElem = document.createElement('th');
             trElem.appendChild(thElem);
             //alert(columnNumber);
             var nextIndex = index +1 ;
             //Creation du corps du tableau
             var tbodyElem = document.createElement('tbody');
             tableElem.appendChild(tbodyElem);
              if(metaData.createonfield==true && field.editable==true){  
                    //Creation de la ligne des actions
                    var trElem = document.createElement('tr');
                    tbodyElem.appendChild(trElem);
                    trElem.setAttribute("ng-hide","windowType=='view'");
                    var tdElem = document.createElement('td');
                    trElem.appendChild(tdElem);
                    tdElem.setAttribute("colspan" , columnNumber+1);
                    var aElem = document.createElement('a');
                    tdElem.appendChild(aElem);
                    aElem.setAttribute('href' , '#');
                    if(($scope.windowType!="view")
                            ||($scope.metaData.desableupdate==true&&($scope.innerWindowType=="new"||$scope.innerWindowType=="update"))){
                       //Diseable si ajout impossible               
                        aElem.setAttribute('disabled' , 'disabled');
                        aElem.setAttribute('ng-click' , "addnewLine('"+model+"')");                      
                        aElem.appendChild(document.createTextNode("Ajouter un element"));
                        aElem.setAttribute('disabled' , 'disabled');                  
                    }//end if($scope.windowType=="view"){            
               }//end if(metaData.createonfield==true)               
             //Construction du corps du tableau
             trElem = document.createElement('tr');
             trElem.setAttribute('style' ,"cursor: pointer;");
             tbodyElem.appendChild(trElem);
             trElem.setAttribute('ng-repeat' , 'item in '+model);
             var key = commonsTools.keygenerator(modelpath);
             $scope.dataCache["row"+key] = null;
             $scope.displayTemplate(metaData,model,modelpath,trElem,"row"+key,index);
//             $scope.editTemplate(metaData,model,modelpath,index,trElem,"row"+key);
            //construction du pied de tableau            
            if(field.customfooter==false){
                var sources = model.split(".");    
                $scope.dataCache[key+"foot"] = null;
                var footerElem = document.createElement('tfoot');
                footerElem.setAttribute("id",key);
                if(fieldnames.length>0){
                    for(var i=0 ;  i<fieldnames.length ; i++){
                        var thelem = document.createElement('th');
                        footerElem.appendChild(thelem);
                        var data = $scope.currentObject;
                        if(sources[0]!='currentObject'){
                            data = $scope.dataCache[""+key];
                        }//end if(model!='currentObject')
//                        console.log("$scope.oneToManyComponent &&&&&& === "+fieldnames[i]+"===="+field.fieldName+"===="+angular.toJson(data));
                        if(data){
                            var total = commonsTools.sumTableField(fieldnames[i],data[field.fieldName]);
                            if(total){
                                thelem.appendChild(document.createTextNode(total));
                                thelem.setAttribute('class','text-center');
                            }//end if(total)
                        }//end if(data)
                    }//end for(var i=0 ;  i<fieldnames.length ; i++)
                    thelem = document.createElement('th');
                    footerElem.appendChild(thelem);
                    tableElem.appendChild(footerElem);
                }//end if(fieldnames.length$>0)
            }else{
                var sources = model.split(".");   
                $scope.dataCache[key+"foot"] = field.footerScript;
                var data = $scope.currentObject;
                if(sources[0]!='currentObject'){
                     data = $scope.dataCache[""+key];//data = $scope.temporalData;
                }//end if(model!='currentObject')
                if(data){
//                    var piedElem = commonsTools.tableFooterBuilder(field.footerScript,data[field.fieldName],sources[1],key);  
                    var piedElem = commonsTools.tableFooterBuilder(field.footerScript,data[field.fieldName],sources[1],$scope.currentObject,$scope.currentUser);  
                    tableElem.appendChild(piedElem);
                }//end if(data)
            }//end if(field.customfooter)
           
            if(field.hide){
               tableElem.setAttribute('ng-hide',true);
            }//end if(field.hide)
            if(field.hidden!=null&&field.hidden.length>0){
                   tableElem.setAttribute('ng-hide',field.hidden);
            }//end if(field.hidden!=null&&field.hidden.length==0)
            //Traitement des observable
            if(field.observable==true){
                var observable = new Observable();
                $scope.observablePools[field.fieldName] = observable;
            }//end if(field.observable==true)
            if(field.observer!=null){
                var observer = new Observer(field.observer,model);
                if($scope.observablePools[field.observer.observable]){
                    observer.register($scope.observablePools[field.observer.observable]);
                }else{
                     var observable = new Observable();
                     $scope.observablePools[field.observer.observable] = observable;
                     observer.register($scope.observablePools[field.observer.observable]);
                }//end if($scope.observablePools[field.fieldName])
            }//end if(field.observer!=null)
//            var compileFn = $compile(divElem);
//            compileFn($scope);
             /*alert($scope.currentObject.actions);*/
//             var divElem0 = document.createElement('div');
//             divElem0.appendChild(divElem);
//             console.log(divElem0.innerHTML);             
             return tableElem;
        };
        
        /**
         * 
         * @param {type} field
         * @param {type} fieldName
         * @returns {undefined}
         */
        $scope.getField = function(metaData,fieldName){
            //Recherche dans les col
            for(var i = 0 ;i<metaData.columns.length;i++){
                if(metaData.columns[i].fieldName==fieldName){
                    return metaData.columns[i];
                }
            }//end for(var i = 0 ;i<metaData.columns.length;i++){
            for(var i=0;i<metaData.groups.length;i++){
                var group = metaData.groups[i];
                if(group.metaArray){                    
                    var field = $scope.getField(group.metaArray.metaData,fieldName);
                    if(field){
                        return field;
                    }                    
                }//end if(group.metaArray){
                if(group.columns){
                    for(var j=0;j<group.columns.length;j++){
                        var column = group.columns[j];
                        if(column.fieldName==fieldName){
                            return column;
                        }//end if(column.fieldName==fieldName){
                    }//end for(var j=0;j<group.columns.length;j++){
                }//end if(group.columns){
            }//end for(var i=0;i<metaData.groups.length;i++){
        };
        /**
         * 
         * @param {type} model
         * @returns {undefined}
         */
        $scope.addnewLine = function(model){
            var metaData = $scope.getCurrentMetaData(model);
            var data = $scope.createFreeEmptyObject(metaData);
            var date = new Date();
            data.id = -date.getTime();
            data.compareid = data.id;
            var datamodel = $scope.getCurrentModel(model);
//            console.log("$scope.addnewLine = function(model) =======  model : "+model+" ==== data : "+angular.toJson(data));            
            datamodel.unshift(data);
        };
        /**
         * 
         * @param {type} item
         * @param {type} fieldname
         * @param {type} key
         * @param {type} model
         * @param {type} modelpath
         * @param {type} index
         * @param {type} col
         * @returns {undefined}
         */
        $scope.getTemplate = function(item,fieldname,key,model,modelpath,index,col){
            var metaData = $scope.getCurrentMetaData(modelpath);
            var oldItem = $scope.dataCache[key];
            var oldfieldname = $scope.dataCache[key+"_fieldname"];               
            var id = "td"+Math.abs(item.compareid)+"_"+fieldname;
            var oldId = null;
            if(oldItem!=null){
                oldId = "td"+Math.abs(oldItem.compareid)+"_"+oldfieldname;
            }//end if(oldItem!=null)
//            console.log("$scope.getTemplate = function(item) =========  ==== new : "+fieldname+" ==== old :"+oldfieldname+" === "+key+" ======= new : "+id+" :::: old : "+oldId+" ======== "+model+" :::: "+modelpath+" :::: "+index+" === "+angular.toJson(item));            
            //Recherche du span contenant 
            var spanElem = null ;
            var oldspanElem = null ;
            var items = $(document).find("span");
            for(var i=0; i<items.length;i++){
                 if(items.eq(i).attr("id")==id){
                       spanElem =items.eq(i) ;
//                       console.log(" ======================= on a trouve report  span identifiant : "+id);
                 }//end if(items.eq(i).attr("id")=="innerpanel")  
                 if(oldId!=null && oldId!=id){
                     if(items.eq(i).attr("id")==oldId){
                            oldspanElem =items.eq(i) ;
//                            console.log(" ======================= on a trouve report Old  span identifiant : "+oldId);
                      }//end if(items.eq(i).attr("id")=="innerpanel")  
                 }//end if(oldId!=null){
            }//end if(items.eq(i).attr("id")=="innerpanel")
//             spanElem = $("#"+id)
//             if(oldId!=null && oldId!=id){
//                 oldspanElem = $("#"+oldId);
//             }//end if(oldId!=null && oldId!=id){
            if(oldItem!=null && oldspanElem!=null&&(oldId != id)){
                var data = oldItem[oldfieldname];
                var spanelem = document.createElement("span");
                spanelem.setAttribute("id",oldId); 
                if(angular.isArray(data)){
                    var text = "";
                    for(var i=0;i<data.length;i++){
                        text +=data[i].designation;
                    }//end for(var i=0;i<data.length;i++){
                    spanelem.appendChild(document.createTextNode(text));
                }else if(angular.isObject(data)){
                    spanelem.appendChild(document.createTextNode(data['designation']));
                }else{
                    var field = $scope.getField(metaData,oldfieldname);
                    /**if(field.type=='boolean'){
                         var input = document.createElement('input');
                         input.setAttribute('type' , 'checkbox');
                         input.setAttribute('value' , data);
                         spanelem.appendChild(input);
                    }else**/ 
                    if(field.type=='number'){
                        spanelem.appendChild(document.createTextNode("{{"+data+" | number:0}}"));
                    }else if(field.type!='combobox'){
                        spanelem.appendChild(document.createTextNode(data));
                    }else {
                        var values = field.value.split(';');
                        spanelem.appendChild(document.createTextNode(values[Number(data)]));
                    }//end if(field.type!='combobox'){
                }//end if(angular.isObject(data))               
                oldspanElem.replaceWith(spanelem);
            }//end if(oldItem!=null)
            //Traitement de la cellule selectionnÃ©e
            if(id != oldId){
                var data  = $scope.getCurrentModel(model);                
                var pos = 0;
                for(var i=0 ;i<data.length;i++){
                    if(data[i].id == item.id){
                        pos = i ;break;
                    }//end if(data[i].id == item.id){
                }//end for(var i=0 ;i<data.length;i++)
                var field = $scope.getField(metaData,fieldname);
                var htmlElem = null;
                if(modelpath==='currentObject'){
                     $scope.templateData = item;
                     htmlElem = $scope.getIhmComponent('templateData',field,null,null,index,'templateData');
                }else{
//                    $scope.templateData = $scope.getCurrentModel(model+'['+pos+']');
                    htmlElem = $scope.getIhmComponent(model+'['+pos+']',field,null,null,index,modelpath);
//                    htmlElem = $scope.getIhmComponent(modelpath+'['+pos+']',field,null,null,index,modelpath);
                }//end if(modelpath==='currentObject'){
//                console.log("principal.getTemplate ========= model :"+model+" ==== modelpath : "+modelpath+" field name : "+fieldname+" ====  ID :"+id+" Meta :"+angular.toJson(field));
                var spanelem = document.createElement("span");
                spanelem.setAttribute("id",id);
                spanelem.appendChild(htmlElem);
                var compileFn = $compile(spanelem);
                compileFn($scope);
                spanElem.replaceWith(spanelem);
                $scope.dataCache[key] = item;
                $scope.dataCache[key+"_fieldname"] = fieldname;
                $timeout(function() {
                    $('.selectpicker').selectpicker('refresh');
                    $scope.refreshtable(item,metaData,model,modelpath);
                    commonsTools.selectpickerKeyup(metaData,modelpath,$scope);
                });
            }//end if(id != oldId){
            
        };
        /**
         * 
         * @param {type} item
         * @returns {undefined}
         */
        $scope.editRow = function(item,key){
            if($scope.dataCache[key]==null){
                return false;
            }//end if($scope.dataCache[key]==null){
            if(item.id==$scope.dataCache[key].id){
                return true;
            }//end if(item.id==$scope.dataCache[key].id){
            return false;
        };
        /**
         * 
         * @param {type} item
         * @returns {undefined}
         */
        $scope.noteditRow = function(item,key){
            if($scope.dataCache[key] ==null){
                return true;
            }
            if(item.id==$scope.dataCache[key].id){
                return false;
            }
            return true;
        };
        /**
         * Edit Template Row
         * @param {type} metaData
         * @param {type} id
         * @returns {unresolved}
         */
        $scope.editTemplate = function(metaData,model,modelpath,index,trEleme,key){
            var scriptelem = trEleme ; //document.createElement("span");
//            scriptelem.setAttribute('type','text/ng-template');
//            scriptelem.setAttribute("ng-show","editRow(item)");
            for(var i=0 ; i< metaData.columns.length;i++){
                 if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search){
                     var tdElem = document.createElement('td');
                     if(metaData.columns[i].type!='array'){
                         if(metaData.columns[i].type!='object'){
                                var colmodel = model;
                                var htmlElem = $scope.getIhmComponent('item',metaData.columns[i],metaData.entityName,metaData.entityName,index,modelpath);
                                tdElem.appendChild(htmlElem);
                         }else{
                                var colmodel = model;
                                var htmlElem = $scope.getIhmComponent('item',metaData.columns[i],metaData.entityName,metaData.entityName,index,'item');
                                tdElem.appendChild(htmlElem);
                         }//end if(metaData.columns[i].type!='object'){
                     }//end if(metaData.columns[i].type!='array')
                     tdElem.setAttribute('ng-show' , "editRow(item,'"+key+"')");                    
                     tdElem.setAttribute('ng-click',"getTemplate(item,'"+key+"')");
                     scriptelem.appendChild(tdElem);
                 }//end if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search)
            }//end for(var i=0 ; i< metaData.columns.length;i++)
            //Traitement  des champs des groupes
             if(metaData.groups&&metaData.groups.length>0){
                 for(var i=0;i<metaData.groups.length;i++){
                     //Cas des columns
                     if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                          for(var j = 0 ; j < metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search){
                                var tdElem = document.createElement('td');
                                if(metaData.groups[i].columns[j].type!='array'){ 
                                    if(metaData.groups[i].columns[j].type!='object'){
                                        var colmodel = 'item';                                    
                                        var htmlElem = $scope.getIhmComponent(colmodel,metaData.groups[i].columns[j],metaData.groups[i].columns[j].metaData.entityName,metaData.entityName,index,modelpath);
                                        tdElem.appendChild(htmlElem);  
                                    }else{
                                        var colmodel = 'item';                                    
                                        var htmlElem = $scope.getIhmComponent(colmodel,metaData.groups[i].columns[j],metaData.groups[i].columns[j].metaData.entityName,metaData.entityName,index,modelpath);
                                        tdElem.appendChild(htmlElem);  
                                    }//end if(metaData.groups[i].columns[j].type!='object')
                                }//end if(metaData.groups[i].columns[j].type!='array')       
                                tdElem.setAttribute('ng-show' , "editRow(item,'"+key+"')");                         
                                tdElem.setAttribute('ng-click',"getTemplate(item,'"+key+"')");   
                                scriptelem.appendChild(tdElem);
                            }//end if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search)
                        }//end for(var j = 0 ; j < metaData.groups[i].columns.length;j++)
                     }//end if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0)                     
                 }//end for(var i=0;i<metaData.groups.length;i++)
             }//end if(metaData.groups&&metaData.groups.length>0){
             if(metaData.createonfield==true){
             //Suppression
                tdElem = document.createElement('td');
                tdElem.setAttribute('ng-show' , "editRow(item,'"+key+"')");          
                scriptelem.appendChild(tdElem);
                var aElem = document.createElement('a');
                aElem.setAttribute('href' , '#');
                aElem.setAttribute('ng-click' , "removeFromTable('"+model+"',item,'"+modelpath+"')"); 
                tdElem.appendChild(aElem);
                var spanElem = document.createElement('span');
                spanElem.setAttribute('class' , 'glyphicon glyphicon-trash');
                spanElem.setAttribute('aria-hidden' , 'true');
                aElem.appendChild(spanElem);
                if($scope.windowType=="view"){
                     aElem.setAttribute('disabled' , 'disabled');                  
                 }            
            }//end if(metaData.createonfield==true){
            return scriptelem;
        };
        /**
         * 
         * @param {type} item
         * @param {type} index
         * @returns {String}
         */
        $scope.identfiantenerator = function(item,index){
//             var date = new Date();
             var id = "td"+Math.abs(item.compareid)+"_"+index;
             return id ;
        };
        /**
         * Build Display Row
         * @param {type} metaData
         * @returns {undefined}
         */
        $scope.displayTemplate = function(metaData,model,modelpath,trEleme,key,index){
//            console.log("principal.displayTemplate =============================== "+model+" ===== modelpath : "+modelpath)
            var scriptelem = trEleme ; //document.createElement("span");
            for(var i=0 ; i< metaData.columns.length;i++){
                 if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search){
                     var tdElem = document.createElement('td');
//                     tdElem.setAttribute("ng-keyup","refreshTable('"+model+"','"+modelpath+"')");
                     if(metaData.columns[i].type!='array'&& metaData.columns[i].type!='object'
                              && metaData.columns[i].type!='combobox'){
                         var spanElem = document.createElement("span");
                         spanElem.setAttribute("ng-keyup","refreshTable('"+model+"','"+modelpath+"')");
                         spanElem.setAttribute("id","{{identfiantenerator(item , '"+metaData.columns[i].fieldName+"')}}");                         
                         if(metaData.columns[i].type=='number'){
                             spanElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+'|number:0}}'));
                            tdElem.setAttribute('class','text-center');
                         }else if(metaData.columns[i].type=='date'){
                             if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                 spanElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+' | date:"'+$rootScope.globals.langue.formatDate+'"}}'));
                             }else{
                                 spanElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+' | date:"dd-MM-yyyy"}}'));
                             }//end if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){                             
                         }else{
                             spanElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+'}}'));
                         }//end if(metaData.columns[i].type=='number'){
                         tdElem.appendChild(spanElem);                         
                     }else if(metaData.columns[i].type=='object'){
                          //console.log("$scope.oneToManyComponent ============= "+"{{item."+metaData.columns[i].fieldName+"['designation']}}");
                          var spanElem = document.createElement("span");
                          spanElem.setAttribute("ng-keyup","refreshTable('"+model+"','"+modelpath+"')");
                          spanElem.setAttribute("id","{{identfiantenerator(item , '"+metaData.columns[i].fieldName+"')}}");
                          spanElem.appendChild(document.createTextNode("{{item."+metaData.columns[i].fieldName+"['designation']}}"));
                          tdElem.appendChild(spanElem);
                     }else if(metaData.columns[i].type=='combobox'){
                          //console.log("$scope.oneToManyComponent ============= "+"{{item."+metaData.columns[i].fieldName+"['designation']}}");
                          var spanElem = document.createElement("span");
                          spanElem.setAttribute("ng-keyup","refreshTable('"+model+"','"+modelpath+"')");
                          spanElem.setAttribute("id","{{identfiantenerator(item , '"+metaData.columns[i].fieldName+"')}}");
                          spanElem.appendChild(document.createTextNode("{{comboboxselctionvalues(item."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}"));
                          tdElem.appendChild(spanElem);
                     }else if(metaData.columns[i].type=='array'){
                          var spanElem = document.createElement("span");
                          spanElem.setAttribute("ng-keyup","refreshTable('"+model+"','"+modelpath+"')");
                          spanElem.setAttribute("id","{{identfiantenerator(item , '"+metaData.columns[i].fieldName+"')}}");
                          spanElem.appendChild(document.createTextNode("{{arrayValues(item."+metaData.columns[i].fieldName+")}}"));
                          tdElem.appendChild(spanElem);
                     }
//                     tdElem.setAttribute('ng-show' , "noteditRow(item,'"+key+"','"+id+"')");                           
                     tdElem.setAttribute('ng-click',"getTemplate(item,'"+metaData.columns[i].fieldName+"','"+key+"', '"+model+"' , '"+modelpath+"','"+index+"','"+i+"')"); 
                     scriptelem.appendChild(tdElem);
                 }//end if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search)
                 $scope.addObserver(model,metaData.columns[i],$scope);
            }//end for(var i=0 ; i< metaData.columns.length;i++)
            //Traitement  des champs des groupes
             if(metaData.groups&&metaData.groups.length>0){
                 for(var i=0;i<metaData.groups.length;i++){
                     //Cas des columns
                     if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                          for(var j = 0 ; j < metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search){
                                var tdElem = document.createElement('td');
                                if(metaData.groups[i].columns[j].type!='array'&& metaData.groups[i].columns[j].type!='object' 
                                        && metaData.groups[i].columns[j].type!='combobox'){
                                    var spanElem = document.createElement("span");
                                    spanElem.setAttribute("ng-keyup","refreshTable('"+model+"','"+modelpath+"')");
                                    spanElem.setAttribute("id","{{identfiantenerator(item , '"+metaData.columns[i].fieldName+"')}}");                                    
                                    if(metaData.groups[i].columns[j].type=='number'){
                                        spanElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+'|number:0}}'));
                                        tdElem.setAttribute('class','text-center');
                                    }else if(metaData.groups[i].columns[j].type=='date'){
                                        if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                             spanElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+' | date:"'+$rootScope.globals.langue.formatDate+'"}}'));
                                        }else{
                                             spanElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+' | date:"dd-MM-yyyy"}}'));
                                        }//end if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){                                       
                                    }else{
                                        spanElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+'}}'));
                                    }//end if(metaData.groups[i].columns[j].type=='number'){
                                    tdElem.appendChild(spanElem);
                                }else if(metaData.groups[i].columns[j].type=='object'){
                                    var spanElem = document.createElement("span");
                                    spanElem.setAttribute("ng-keyup","refreshTable('"+model+"','"+modelpath+"')");
                                    spanElem.setAttribute("id","{{identfiantenerator(item , '"+metaData.columns[i].fieldName+"')}}");
                                    spanElem.appendChild(document.createTextNode("{{item."+metaData.groups[i].columns[j].fieldName+"['designation']}}"));
                                    tdElem.appendChild(spanElem);
                                }else if(metaData.groups[i].columns[j].type=="combobox"){
                                    var spanElem = document.createElement("span");
                                    spanElem.setAttribute("ng-keyup","refreshTable('"+model+"','"+modelpath+"')");
                                    spanElem.setAttribute("id","{{identfiantenerator(item , '"+metaData.columns[i].fieldName+"')}}");
                                    spanElem.appendChild(document.createTextNode("{{comboboxselctionvalues(item."+metaData.groups[i].columns[j].fieldName+",'"+metaData.groups[i].columns[j].value+"')}}"));
                                    tdElem.appendChild(spanElem);                              
                                }else if(metaData.groups[i].columns[j].type=="array"){
                                    var spanElem = document.createElement("span");
                                    spanElem.setAttribute("ng-keyup","refreshTable('"+model+"','"+modelpath+"')");
                                    spanElem.setAttribute("id","{{identfiantenerator(item , '"+metaData.columns[i].fieldName+"')}}");
                                    spanElem.appendChild(document.createTextNode("{{arrayValues(item."+metaData.groups[i].columns[j].fieldName+")}}"));
                                    tdElem.appendChild(spanElem);                              
                                } //end if(metaData.groups[i].columns[j].type!='array'&& metaData.groups[i].columns[j].type!='object'){    
//                                tdElem.setAttribute('ng-show' , "noteditRow(item,'"+key+"','"+id+"')"); 
                                tdElem.setAttribute('ng-click',"getTemplate(item,'"+metaData.columns[i].fieldName+"','"+key+"', '"+model+"' , '"+modelpath+"','"+index+"','"+i+"')"); 
                                scriptelem.appendChild(tdElem);
                            }//end if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search)
                            $scope.addObserver(model,metaData.groups[i].columns[j],$scope);
                        }//end for(var j = 0 ; j < metaData.groups[i].columns.length;j++)
                     }//end if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0)                     
                 }//end for(var i=0;i<metaData.groups.length;i++)
             }//end if(metaData.groups&&metaData.groups.length>0){
             if((metaData.createonfield==true) && !$scope.isviewOperation()){
             //Suppression
                tdElem = document.createElement('td');
//                tdElem.setAttribute('ng-show' , "noteditRow(item,'"+key+"')");
                scriptelem.appendChild(tdElem);
                var aElem = document.createElement('a');
                aElem.setAttribute('href' , '#');
                aElem.setAttribute('ng-click' , "removeFromTable('"+model+"',item,'"+modelpath+"')"); 
                tdElem.appendChild(aElem);
                var spanElem = document.createElement('span');
                spanElem.setAttribute('class' , 'glyphicon glyphicon-trash');
                spanElem.setAttribute('aria-hidden' , 'true');
                aElem.appendChild(spanElem);
                if(($scope.windowType=="view")){
                     aElem.setAttribute('disabled' , 'disabled');                  
                }//end if($scope.windowType=="view"){            
            }else{
                tdElem = document.createElement('td');
                scriptelem.appendChild(tdElem);
            }//end if(metaData.createonfield==true){
            
            return scriptelem;
        };
        /**
         * 
         * @param {type} model
         * @param {type} modelpath
         * @returns {undefined}
         */
        $scope.refreshtable = function(item,metaData,model,modelpath){
            var key = commonsTools.keygenerator(modelpath);
            var data = $scope.getCurrentModel(modelpath);
            commonsTools.compteField(item,$scope.currentObject,$scope.currentUser,metaData);
//            console.log("principal.refreshTable ====== model : "+model+" ====== modelpath : "+modelpath);
            $rootScope.$broadcast("tablefooter" , {metaData:metaData,model:model,modelpath:modelpath}); 
                    
        };
         /**
         * Build Display Row
         * @param {type} metaData
         * @returns {undefined}
         */
        $scope.listDisplayTemplate = function(metaData,trEleme,key,index){
            var scriptelem = trEleme ; //document.createElement("span");
            var tdElem = document.createElement('td');
            scriptelem.appendChild(tdElem);
//            rbodyElem.setAttribute('style' , "cursor: pointer;");
            var inputElem0 = document.createElement('input');
            inputElem0.setAttribute('type' , 'checkbox');
            inputElem0.setAttribute('ng-model' , 'obj.selected');
            inputElem0.setAttribute('ng-click' , 'onRowCheckboxClick(obj)');
            tdElem.appendChild(inputElem0);
            for(var i=0 ; i< metaData.columns.length;i++){
                 if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search){
                     var tdElem = document.createElement('td');
                     if(metaData.columns[i].type!='array'&& metaData.columns[i].type!='object'
                              && metaData.columns[i].type!='combobox' && metaData.columns[i].type!='color'
                              && metaData.columns[i].type!='radio'){
                         var spanElem = document.createElement("span");
                         spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.columns[i].fieldName+"')}}");
                         if(metaData.columns[i].type=='number'){
                             spanElem.appendChild(document.createTextNode('{{obj.'+metaData.columns[i].fieldName+' | number:0}}'));
                            tdElem.setAttribute('class','text-center');
                         }else if(metaData.columns[i].type=='date'){
                             if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                 spanElem.appendChild(document.createTextNode('{{obj.'+metaData.columns[i].fieldName+' | date:"'+$rootScope.globals.langue.formatDate+'"}}'));
                             }else{
                                 spanElem.appendChild(document.createTextNode('{{obj.'+metaData.columns[i].fieldName+' | date:"dd-MM-yyyy"}}'));
                             }//end if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){                             
                         }else{
                             spanElem.appendChild(document.createTextNode('{{obj.'+metaData.columns[i].fieldName+'}}'));
                         }//end if(metaData.columns[i].type=='number'){
                         tdElem.appendChild(spanElem);
                     }else if(metaData.columns[i].type=='radio'){
                            var spanElem = document.createElement("span");
                            spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.columns[i].fieldName+"')}}");
                            spanElem.appendChild(document.createTextNode("{{radioselctionvalues(obj."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}"));
                            tdElem.appendChild(spanElem);
                     }else if(metaData.columns[i].type=='color'){
                          var spanElem = document.createElement("span");
                          spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.columns[i].fieldName+"')}}");
                          spanElem.appendChild(document.createTextNode('{{obj.'+metaData.columns[i].fieldName+'}}'));
                          tdElem.appendChild(spanElem);
                          tdElem.setAttribute('style',"background-color:{{obj."+metaData.columns[i].fieldName+"}};");
//                            thElem.innerHTML = "{{comboboxselctionvalues(obj."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}";
                     }else if(metaData.columns[i].type=='object'){
                          //console.log("$scope.oneToManyComponent ============= "+"{{item."+metaData.columns[i].fieldName+"['designation']}}");
                          var spanElem = document.createElement("span");
                          spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.columns[i].fieldName+"')}}");
                          spanElem.appendChild(document.createTextNode("{{obj."+metaData.columns[i].fieldName+"['designation']}}"));
                          tdElem.appendChild(spanElem);
                     }else if(metaData.columns[i].type=='combobox'){
                          //console.log("$scope.oneToManyComponent ============= "+"{{item."+metaData.columns[i].fieldName+"['designation']}}");
                          var spanElem = document.createElement("span");
                          spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.columns[i].fieldName+"')}}");
                          spanElem.appendChild(document.createTextNode("{{comboboxselctionvalues(obj."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}"));
                          tdElem.appendChild(spanElem);
                     }else if(metaData.columns[i].type=='array'){
                          //console.log("$scope.oneToManyComponent ============= "+"{{item."+metaData.columns[i].fieldName+"['designation']}}");
                          var spanElem = document.createElement("span");
                          spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.columns[i].fieldName+"')}}");
                          spanElem.appendChild(document.createTextNode("{{arrayValues(obj."+metaData.columns[i].fieldName+")}}"));
                          tdElem.appendChild(spanElem);
                     }
//                     tdElem.setAttribute('ng-show' , "noteditRow(item,'"+key+"','"+id+"')");                           
                     tdElem.setAttribute('ng-click',"getTemplate(obj,'"+metaData.columns[i].fieldName+"','"+key+"', 'currentObject' , 'currentObject','0','"+i+"')"); 
                     scriptelem.appendChild(tdElem);
                 }//end if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search)
            }//end for(var i=0 ; i< metaData.columns.length;i++)
            //Traitement  des champs des groupes
             if(metaData.groups&&metaData.groups.length>0){
                 for(var i=0;i<metaData.groups.length;i++){
                     //Cas des columns
                     if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                          for(var j = 0 ; j < metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search){
                                var tdElem = document.createElement('td');
                                if(metaData.groups[i].columns[j].type!='array'&& metaData.groups[i].columns[j].type!='object' 
                                        && metaData.groups[i].columns[j].type!='combobox'){
                                    var spanElem = document.createElement("span");
                                    spanElem.setAttribute("id","{{identfiantenerator(item , '"+metaData.columns[i].fieldName+"')}}");                                    
                                    if(metaData.groups[i].columns[j].type=='number'){
                                        spanElem.appendChild(document.createTextNode('{{obj.'+metaData.groups[i].columns[j].fieldName+' | nimber:0}}'));
                                        tdElem.setAttribute('class','text-center');
                                    }else if(metaData.groups[i].columns[j].type=='date'){
                                        if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                            spanElem.appendChild(document.createTextNode('{{obj.'+metaData.groups[i].columns[j].fieldName+' | date:"'+$rootScope.globals.langue.formatDate+'"}}')); 
                                        }else{
                                            spanElem.appendChild(document.createTextNode('{{obj.'+metaData.groups[i].columns[j].fieldName+' | date:"dd-MM-yyyy"}}')); 
                                        }//end if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){                                       
                                    }else{
                                        spanElem.appendChild(document.createTextNode('{{obj.'+metaData.groups[i].columns[j].fieldName+'}}'));
                                    }//end if(metaData.groups[i].columns[j].type=='number'){
                                    tdElem.appendChild(spanElem);
                                }else if(metaData.groups[i].columns[j].type=='radio'){
                                        var spanElem = document.createElement("span");
                                        spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.groups[i].columns[j].fieldName+"')}}");
                                        spanElem.appendChild(document.createTextNode("{{radioselctionvalues(obj."+metaData.groups[i].columns[j].fieldName+",'"+metaData.groups[i].columns[j].value+"')}}"));
                                        tdElem.appendChild(spanElem);
                                 }else if(metaData.groups[i].columns[j].type=='color'){
                                      var spanElem = document.createElement("span");
                                      spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.groups[i].columns[j].fieldName+"')}}");
                                      spanElem.appendChild(document.createTextNode('{{obj.'+metaData.groups[i].columns[j].fieldName+'}}'));
                                      tdElem.appendChild(spanElem);
                                      tdElem.setAttribute('style',"background-color:{{obj."+metaData.groups[i].columns[j].fieldName+"}};");
//                                      spanElem.setAttribute('style',"background-color:{{obj."+metaData.groups[i].columns[j].fieldName+"}};");
                                 }else if(metaData.groups[i].columns[j].type=='object'){
                                    var spanElem = document.createElement("span");
                                    spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.columns[i].fieldName+"')}}");
                                    spanElem.appendChild(document.createTextNode("{{obj."+metaData.groups[i].columns[j].fieldName+"['designation']}}"));
                                    tdElem.appendChild(spanElem);
                                }else if(metaData.groups[i].columns[j].type=="combobox"){
                                    var spanElem = document.createElement("span");
                                    spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.columns[i].fieldName+"')}}");
                                    spanElem.appendChild(document.createTextNode("{{comboboxselctionvalues(obj."+metaData.groups[i].columns[j].fieldName+",'"+metaData.groups[i].columns[j].value+"')}}"));
                                    tdElem.appendChild(spanElem);                              
                                }else if(metaData.groups[i].columns[j].type=="array"){
                                    var spanElem = document.createElement("span");
                                    spanElem.setAttribute("id","{{identfiantenerator(obj , '"+metaData.columns[i].fieldName+"')}}");
                                    spanElem.appendChild(document.createTextNode("{{arrayValues(obj."+metaData.groups[i].columns[j].fieldName+")}}"));
                                    tdElem.appendChild(spanElem);                              
                                } //end if(metaData.groups[i].columns[j].type!='array'&& metaData.groups[i].columns[j].type!='object'){    
//                                tdElem.setAttribute('ng-show' , "noteditRow(item,'"+key+"','"+id+"')"); 
                                tdElem.setAttribute('ng-click',"getTemplate(obj,'"+metaData.columns[i].fieldName+"','"+key+"', 'currentObject' , 'currentObject','0','"+i+"')"); 
                                scriptelem.appendChild(tdElem);
                            }//end if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search)
                        }//end for(var j = 0 ; j < metaData.groups[i].columns.length;j++)
                     }//end if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0)                     
                 }//end for(var i=0;i<metaData.groups.length;i++)
             }//end if(metaData.groups&&metaData.groups.length>0){
             var tdelem = document.createElement('td');
             commonsTools.menusActions($scope,tdelem,1,'obj');
             scriptelem.appendChild(tdelem);
             return scriptelem;
        };
        /**
         * 
         * @param {type} items
         * @returns {undefined}
         */
        $scope.arrayValues = function(items){
            var value = new String();
            for(var i=0;i<items.length;i++){
                value+=items[i].designation+" ; ";
            }
            return value;
        };
        /**
         * 
         * @param {type} model
         * @param {type} labelText
         * @param {type} entityName
         * @param {type} metaData
         * @param {type} field
         * @param {type} index
         * @param {type} modelpath
         * @returns {undefined}
         */
        $scope.manyToManyListComponent = function(model , labelText , entityName ,metaData,field,index,modelpath,editable){
             if(angular.isDefined(editable) && editable==true){
                return $scope.manyToManyListComponentEditable(model , labelText , entityName ,metaData,field,index,modelpath);
            }else{
                return $scope.manyToManyListComponentNoneditable(model , labelText , entityName ,metaData,field,index,modelpath);
            }//end if(angular.isDefined(editable) && editable==true)
        };
         /**
          * Creation d'un composant table avec possibilte ajout modif suppression et consultation
            model : field to map
            labelText : the Label of the input
            entityName : name of the entity,
            metaData : MetaData which describe de object
          * @param {type} model
          * @param {type} labelText
          * @param {type} entityName
          * @param {type} metaData
          * @param {type} field
          * @param {type} index
          * @param {type} modelpath
          * @returns {unresolved}
          */
        $scope.manyToManyListComponentEditable = function(model , labelText , entityName ,metaData,field,index,modelpath){
//              console.log("$scope.manyToManyListComponent =before === "+model+"==="+labelText+" == "+"=== "+entityName+" == "+index+" === "+modelpath); 
//             $scope.currentMetaDataPath = $scope.getMetaDataPath(metaData);
             $scope.dataCache[modelpath+"_field"] = field;
             var divElem = document.createElement('div');
//             divElem.setAttribute('class' , 'table-responsive');
             //Ajout d'un champs input de type hidden pour stocker le model
             var inputHidden = document.createElement('input');
             ///inputHidden.setAttribute('type' , 'hidden')
             //inputHidden.setAttribute('id',)
             var tableElem = document.createElement('table');
             tableElem.setAttribute('class','table table-sm table-striped table-bordered table-hover table-condensed');
             divElem.appendChild(tableElem);
             var theadElem = document.createElement('thead');
             tableElem.appendChild(theadElem);
             var trElem = document.createElement('tr');
             trElem.setAttribute('class' , 'table-header');
             theadElem.appendChild(trElem);
             //console.log(metaData);
             var columnNumber = 0 ;
             var fieldnames = new Array();
             for(var i = 0 ; i < metaData.columns.length;i++){
                 if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search){
                   var thElem = document.createElement('th');
                   thElem.setAttribute("ng-click","tableSorter('"+model+"' , '"+metaData.columns[i].fieldName+"')");
                   //Span Glyphicon
                   thElem.innerHTML = metaData.columns[i].fieldLabel+" <span ng-show=down('"+metaData.columns[i].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.columns[i].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                   trElem.appendChild(thElem);
                   fieldnames.push(metaData.columns[i].fieldName);
                   columnNumber++;
                 }//end if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search)
             }//end for(var i = 0 ; i < metaData.columns.length;i++){
             //Traitement  des champs des groupes
             if(metaData.groups&&metaData.groups.length>0){
                 for(var i=0;i<metaData.groups.length;i++){
                     //Cas des columns
                     if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                          for(var j = 0 ; j < metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search){
                              var thElem = document.createElement('th');
                              thElem.setAttribute("ng-click","tableSorter('"+model+"' , '"+metaData.groups[i].columns[j].fieldName+"')");
                               //Span Glyphicon
                              thElem.innerHTML = metaData.groups[i].columns[j].fieldLabel+" <span ng-show=down('"+metaData.groups[i].columns[j].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.groups[i].columns[j].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                              trElem.appendChild(thElem);
                              fieldnames.push(metaData.groups[i].columns[j].fieldName);
                              columnNumber++;
                            }//end if(angular.isDefined(metaData.groups[i].columns[j].search)
                        }//end for(var j = 0 ; j < metaData.groups[i].columns.length;j++)
                     }//end if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                     
                 }//end for(var i=0;i<metaData.groups.length;i++)
             }//end if(metaData.groups&&metaData.groups.length>0)
             //alert(columnNumber);
             var endIndex = index+1;
             //Creation du corps du tableau
             var tbodyElem = document.createElement('tbody');
             tableElem.appendChild(tbodyElem);
             if(metaData.createonfield==true && field.editable==true){  
                    //Creation de la ligne des actions
                    var trElem = document.createElement('tr');
                    tbodyElem.appendChild(trElem);
                    var tdElem = document.createElement('td');
                    trElem.appendChild(tdElem);
                    tdElem.setAttribute("colspan" , columnNumber);
                    var aElem = document.createElement('a');
                    tdElem.appendChild(aElem);
                    aElem.setAttribute('href' , '#');
                    //Diseable si ajout impossible     
                    var modalID = "";
                    if(endIndex==1){
                        modalID="myModal";
                    }else if(endIndex==2){
                        modalID="globalModal";
                    }else if(endIndex==3){
                        modalID="myModal1";
                    }else if(endIndex==4){
                        modalID="myModal2";
                    }//end if(endIndex==1)
                   aElem.setAttribute('disabled' , 'disabled');
                   aElem.setAttribute('data-toggle' , "modal");
                   aElem.setAttribute('data-target' , '#'+modalID); 
                   if(($scope.windowType!="view")
                            ||($scope.metaData.desableupdate==true&&($scope.innerWindowType=="new"||$scope.innerWindowType=="update"))){
                        if(($scope.metaData.desableupdate==false && $scope.innerWindowType!='new')){
                            aElem.setAttribute('disabled' , 'disabled');
                            aElem.setAttribute('ng-click' , "listDialogBuilder('"+model+"',"+(index+1)+",'"+modelpath+"')");                      
                            aElem.appendChild(document.createTextNode("Ajouter un element"));      
                        }else{
                            if((field.updatable==false)||(field.editable==false)){
                                aElem.setAttribute('disabled' , 'disabled');
                                aElem.setAttribute('ng-click' , "listDialogBuilder('"+model+"',"+(index+1)+",'"+modelpath+"')");                      
                                aElem.appendChild(document.createTextNode("Ajouter un element"));    
                            }//end if((field.updatable==false)||(field.editable==false)){
                        }                                    
                   }//end if($scope.windowType=="view"){            
               }//end if(metaData.createonfield==true)             
             //Construction du corps du tableau
             trElem = document.createElement('tr');
             trElem.setAttribute('style' ,"cursor: pointer;");
             tbodyElem.appendChild(trElem);
             trElem.setAttribute('ng-repeat' , 'item in '+model);
             //alert(metaData.columns.length);
             var key = commonsTools.keygenerator(modelpath);
             $scope.dataCache["row"+key] = null;
             $scope.displayTemplate(metaData,model,modelpath,trElem,"row"+key,index);
             //Building table footer
             if(field.customfooter==false){
                var sources = model.split(".");    
                $scope.dataCache[key+"foot"] = null;
                var footerElem = document.createElement('tfoot');
                footerElem.setAttribute("id",key);
                if(fieldnames.length>0){
                    for(var i=0 ;  i<fieldnames.length ; i++){
                        var thelem = document.createElement('th');
                        footerElem.appendChild(thelem);
                        var data = $scope.currentObject;
                        if(sources[0]!='currentObject'){
                            data = $scope.dataCache[""+key];
                        }//end if(model!='currentObject')
//                        console.log("$scope.oneToManyComponent &&&&&& === "+fieldnames[i]+"===="+field.fieldName+"===="+angular.toJson(data));
                        if(data){
                            var total = commonsTools.sumTableField(fieldnames[i],data[field.fieldName]);
                            if(total){
                                thelem.appendChild(document.createTextNode(total));
                                thelem.setAttribute('class','text-right');
                            }//end if(total)
                        }//end if(data)
                    }//end for(var i=0 ;  i<fieldnames.length ; i++)
                    tableElem.appendChild(footerElem);
                }//end if(fieldnames.length>0)
            }else{
                var sources = model.split(".");   
                $scope.dataCache[key+"foot"] = field.footerScript;
                var data = $scope.currentObject;
                if(sources[0]!='currentObject'){
                     data = $scope.dataCache[""+key];//data = $scope.temporalData;
                }//end if(model!='currentObject')
                if(data){
                    var piedElem = commonsTools.tableFooterBuilder(field.footerScript,data[field.fieldName],sources[1],key);  
                    tableElem.appendChild(piedElem);
                }//end if(data)
            }//end if(field.customfooter)
//            if(metaData.createonfield==true && !$scope.isviewOperation()){
//             //Suppression
//                tdElem = document.createElement('td');
//                trElem.appendChild(tdElem);
//                aElem = document.createElement('a');
//                aElem.setAttribute('href' , '#');
//                aElem.setAttribute('ng-click' , "removeFromTable('"+model+"',item,'"+modelpath+"')"); 
//                tdElem.appendChild(aElem);
//                var spanElem = document.createElement('span');
//                spanElem.setAttribute('class' , 'glyphicon glyphicon-trash');
//                spanElem.setAttribute('aria-hidden' , 'true');
//                aElem.appendChild(spanElem);
//                if($scope.windowType=="view"){
//                     aElem.setAttribute('disabled' , 'disabled');                  
//                 }//end if($scope.windowType=="view"){            
//            }else{
//                tdElem = document.createElement('td');
//                trElem.appendChild(tdElem);
//            }//end if(metaData.createonfield==true)
            //Filter criteria
            var key = commonsTools.keygenerator(model);
            $scope.filtertemplate[key] = field.filter ;
//             alert($scope.currentObject.actions);é
//             var divElem0 = document.createElement('div');
//             divElem0.appendChild(divElem);
//             alert(divElem0.innerHTML);
            if(field.hide){
               divElem.setAttribute('ng-hide',true);
            }//end if(field.hide)
            if(field.hidden!=null&&field.hidden.length>0){
                   divElem.setAttribute('ng-hide',field.hidden);
            }//end if(field.hidden!=null&&field.hidden.length==0)
            //Traitement des observable
            if(field.observable==true){
                var observable = new Observable();
                $scope.observablePools[field.fieldName] = observable;
            }//end if(field.observable==true)
            if(field.observer!=null){
                var observer = new Observer(field.observer,model);
                if($scope.observablePools[field.observer.observable]){
                    observer.register($scope.observablePools[field.observer.observable]);
                }else{
                     var observable = new Observable();
                     $scope.observablePools[field.observer.observable] = observable;
                     observer.register($scope.observablePools[field.observer.observable]);
                }//end if($scope.observablePools[field.fieldName])
            }//end if(field.observer!=null)
             return divElem;
        };
        /**
         * 
         * @param {type} model
         * @param {type} labelText
         * @param {type} entityName
         * @param {type} metaData
         * @param {type} field
         * @param {type} index
         * @param {type} modelpath
         * @returns {unresolved}
         */
        $scope.manyToManyListComponentNoneditable = function(model , labelText , entityName ,metaData,field,index,modelpath){
//              console.log("$scope.manyToManyListComponent =before === "+model+"==="+labelText+" == "+"=== "+entityName+" == "+index+" === "+modelpath); 
//             $scope.currentMetaDataPath = $scope.getMetaDataPath(metaData);
             var divElem = document.createElement('div');
//             divElem.setAttribute('class' , 'table-responsive');
             //Ajout d'un champs input de type hidden pour stocker le model
             var inputHidden = document.createElement('input');
             ///inputHidden.setAttribute('type' , 'hidden')
             //inputHidden.setAttribute('id',)
             var tableElem = document.createElement('table');
             tableElem.setAttribute('class','table table-sm table-striped table-bordered table-hover table-condensed');
             divElem.appendChild(tableElem);
             var theadElem = document.createElement('thead');
             tableElem.appendChild(theadElem);
             var trElem = document.createElement('tr');
             trElem.setAttribute('class' , 'table-header');
             theadElem.appendChild(trElem);
             //console.log(metaData);
             var columnNumber = 0 ;
             var fieldnames = new Array();
             for(var i = 0 ; i < metaData.columns.length;i++){
                 if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search){
                   var thElem = document.createElement('th');
                   thElem.setAttribute("ng-click","tableSorter('"+model+"' , '"+metaData.columns[i].fieldName+"')");
                   //Span Glyphicon
                   thElem.innerHTML = metaData.columns[i].fieldLabel+" <span ng-show=down('"+metaData.columns[i].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.columns[i].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                   trElem.appendChild(thElem);
                   fieldnames.push(metaData.columns[i].fieldName);
                   columnNumber++;
                 }//end if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search)
             }//end for(var i = 0 ; i < metaData.columns.length;i++){
             //Traitement  des champs des groupes
             if(metaData.groups&&metaData.groups.length>0){
                 for(var i=0;i<metaData.groups.length;i++){
                     //Cas des columns
                     if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                          for(var j = 0 ; j < metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search){
                              var thElem = document.createElement('th');
                              thElem.setAttribute("ng-click","tableSorter('"+model+"' , '"+metaData.groups[i].columns[j].fieldName+"')");
                               //Span Glyphicon
                              thElem.innerHTML = metaData.groups[i].columns[j].fieldLabel+" <span ng-show=down('"+metaData.groups[i].columns[j].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.groups[i].columns[j].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                              trElem.appendChild(thElem);
                              fieldnames.push(metaData.groups[i].columns[j].fieldName);
                              columnNumber++;
                            }//end if(angular.isDefined(metaData.groups[i].columns[j].search)
                        }//end for(var j = 0 ; j < metaData.groups[i].columns.length;j++)
                     }//end if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                     
                 }//end for(var i=0;i<metaData.groups.length;i++)
             }//end if(metaData.groups&&metaData.groups.length>0)
             //alert(columnNumber);
             var endIndex = index+1;
             //Creation du corps du tableau
             var tbodyElem = document.createElement('tbody');
             tableElem.appendChild(tbodyElem);
             if(metaData.createonfield==true && field.editable==true){  
                    //Creation de la ligne des actions
                    var trElem = document.createElement('tr');
                    tbodyElem.appendChild(trElem);
                    var tdElem = document.createElement('td');
                    trElem.appendChild(tdElem);
                    tdElem.setAttribute("colspan" , columnNumber);
                    var aElem = document.createElement('a');
                    tdElem.appendChild(aElem);
                    aElem.setAttribute('href' , '#');
                    //Diseable si ajout impossible     
                    var modalID = "";
                    if(endIndex==1){
                        modalID="myModal";
                    }else if(endIndex==2){
                        modalID="globalModal";
                    }else if(endIndex==3){
                        modalID="myModal1";
                    }else if(endIndex==4){
                        modalID="myModal2";
                    }//end if(endIndex==1)
                   aElem.setAttribute('disabled' , 'disabled');
                   aElem.setAttribute('data-toggle' , "modal");
                   aElem.setAttribute('data-target' , '#'+modalID); 
                   if(($scope.windowType!="view")
                            ||($scope.metaData.desableupdate==true&&($scope.innerWindowType=="new"||$scope.innerWindowType=="update"))){
                        if(($scope.metaData.desableupdate==false && $scope.innerWindowType!='new')){
                            aElem.setAttribute('disabled' , 'disabled');
                            aElem.setAttribute('ng-click' , "listDialogBuilder('"+model+"',"+(index+1)+",'"+modelpath+"')");                      
                            aElem.appendChild(document.createTextNode("Ajouter un element"));      
                        }else{
                            if((field.updatable==false)||(field.editable==false)){
                                aElem.setAttribute('disabled' , 'disabled');
                                aElem.setAttribute('ng-click' , "listDialogBuilder('"+model+"',"+(index+1)+",'"+modelpath+"')");                      
                                aElem.appendChild(document.createTextNode("Ajouter un element"));    
                            }//end if((field.updatable==false)||(field.editable==false)){
                        }                                    
                   }//end if($scope.windowType=="view"){            
               }//end if(metaData.createonfield==true)             
             //Construction du corps du tableau
             trElem = document.createElement('tr');
             trElem.setAttribute('style' ,"cursor: pointer;");
             tbodyElem.appendChild(trElem);
             trElem.setAttribute('ng-repeat' , 'item in '+model);
             //alert(metaData.columns.length);
             for(var i=0 ; i< metaData.columns.length;i++){
                if(angular.isDefined(metaData.columns[i].search) && metaData.columns[i].search){
                     var tdElem = document.createElement('td');
                     if(metaData.columns[i].type!='array'&& metaData.columns[i].type!='object' 
                             && metaData.columns[i].type!='combobox'){                         
                         if(metaData.columns[i].type=='number'){
                             tdElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+'}}'));
                            tdElem.setAttribute('class','text-right');
                         }else if(metaData.columns[i].type=='date'){
                             if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                 tdElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+' | date:"'+$rootScope.globals.langue.formatDate+'"}}'));  
                             }else{
                                 tdElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+' | date:"dd-MM-yyyy"}}'));  
                             }//end if($rootScope.globals.langue && $rootScope.globals.langue.formatDate)                           
                         }else{
                             tdElem.appendChild(document.createTextNode('{{item.'+metaData.columns[i].fieldName+'}}'));
                         }//end if(metaData.columns[i].type=='number')
                     }else if(metaData.columns[i].type=='object'){
                          //console.log("$scope.oneToManyComponent ============= "+"{{item."+metaData.columns[i].fieldName+"['designation']}}");
                          tdElem.appendChild(document.createTextNode("{{item."+metaData.columns[i].fieldName+"['designation']}}"));
                     }else if(metaData.columns[i].type=='combobox'){
                         tdElem.appendChild(document.createTextNode("{{comboboxselctionvalues(item."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}"));
                     }//end if(metaData.columns[i].type!='array'&& metaData.columns[i].type!='object')
                     tdElem.setAttribute('data-toggle' , "modal");
                     tdElem.setAttribute('data-target' , '#'+modalID);
                     tdElem.setAttribute('ng-click',"editDialogBuilder('"+model+"' ,item,'update',null,null,"+(index+1)+",'"+modelpath+"')");    
                     trElem.appendChild(tdElem);
                 }
             }
             //Traitement  des champs des groupes
             if(metaData.groups&&metaData.groups.length>0){
                 for(var i=0;i<metaData.groups.length;i++){
                     //Cas des columns
                     if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                          for(var j = 0 ; j < metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search) && metaData.groups[i].columns[j].search){
                                var tdElem = document.createElement('td');
                                if(metaData.groups[i].columns[j].type!='array'&& metaData.groups[i].columns[j].type!='object' 
                                        && metaData.groups[i].columns[j].type!='combobox'){                                    
                                    if(metaData.groups[i].columns[j].type=='number'){
                                        tdElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+'}}'));
                                        tdElem.setAttribute('class','text-right');
                                     }else if(metaData.groups[i].columns[j].type=='date'){
                                         if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                             tdElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+' | date:"'+$rootScope.globals.langue.formatDate+'"}}'));
                                         }else{
                                           tdElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+' | date:"dd-MM-yyyy"}}'));
                                         }//end if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                     }else{
                                         tdElem.appendChild(document.createTextNode('{{item.'+metaData.groups[i].columns[j].fieldName+'}}'));
                                     }//end if(metaData.groups[i].columns[j].type=='number'){
                                }else if(metaData.groups[i].columns[j].type=='object'){
                                    tdElem.appendChild(document.createTextNode("{{item."+metaData.groups[i].columns[j].fieldName+"['designation']}}"));
                                }else if(metaData.groups[i].columns[j].type=='combobox'){
                                    tdElem.appendChild(document.createTextNode("{{comboboxselctionvalues(item."+metaData.groups[i].columns[j].fieldName+",'"+metaData.groups[i].columns[j].value+"')}}"));
                                }//end if(metaData.columns[i].type!='array'&& metaData.columns[i].type!='object')
                                tdElem.setAttribute('data-toggle' , "modal");
                                tdElem.setAttribute('data-target' , '#'+modalID);
                                //tdElem.setAttribute('ng-click',"editDialogBuilder('"+model+"' ,item,'update')");    
                                trElem.appendChild(tdElem);
                            }
                        }//end for(var j = 0 ; j < metaData.groups[i].columns.length;j++){
                     }//end if(metaData.groups[i].columns&&metaData.groups[i].columns.length>0){
                     
                 }//end for(var i=0;i<metaData.groups.length;i++){
             }//end if(metaData.groups&&metaData.groups.length>0){
             var key = commonsTools.keygenerator(modelpath);
             //Building table footer
             if(field.customfooter==false){
                var sources = model.split(".");    
                $scope.dataCache[key+"foot"] = null;
                var footerElem = document.createElement('tfoot');
                footerElem.setAttribute("id",key);
                if(fieldnames.length>0){
                    for(var i=0 ;  i<fieldnames.length ; i++){
                        var thelem = document.createElement('th');
                        footerElem.appendChild(thelem);
                        var data = $scope.currentObject;
                        if(sources[0]!='currentObject'){
                            data = $scope.dataCache[""+key];
                        }//end if(model!='currentObject')
//                        console.log("$scope.oneToManyComponent &&&&&& === "+fieldnames[i]+"===="+field.fieldName+"===="+angular.toJson(data));
                        if(data){
                            var total = commonsTools.sumTableField(fieldnames[i],data[field.fieldName]);
                            if(total){
                                thelem.appendChild(document.createTextNode(total));
                                thelem.setAttribute('class','text-right');
                            }//end if(total)
                        }//end if(data)
                    }//end for(var i=0 ;  i<fieldnames.length ; i++)
                    tableElem.appendChild(footerElem);
                }//end if(fieldnames.length>0)
            }else{
                var sources = model.split(".");   
                $scope.dataCache[key+"foot"] = field.footerScript;
                var data = $scope.currentObject;
                if(sources[0]!='currentObject'){
                     data = $scope.dataCache[""+key];//data = $scope.temporalData;
                }//end if(model!='currentObject')
                if(data){
                    var piedElem = commonsTools.tableFooterBuilder(field.footerScript,data[field.fieldName],sources[1],key);  
                    tableElem.appendChild(piedElem);
                }//end if(data)
            }//end if(field.customfooter)
            if(metaData.createonfield==true && !$scope.isviewOperation()){
             //Suppression
                tdElem = document.createElement('td');
                trElem.appendChild(tdElem);
                aElem = document.createElement('a');
                aElem.setAttribute('href' , '#');
                aElem.setAttribute('ng-click' , "removeFromTable('"+model+"',item,'"+modelpath+"')"); 
                tdElem.appendChild(aElem);
                var spanElem = document.createElement('span');
                spanElem.setAttribute('class' , 'glyphicon glyphicon-trash');
                spanElem.setAttribute('aria-hidden' , 'true');
                aElem.appendChild(spanElem);
                if($scope.windowType=="view"){
                     aElem.setAttribute('disabled' , 'disabled');                  
                 }//end if($scope.windowType=="view"){            
            }else{
                tdElem = document.createElement('td');
                trElem.appendChild(tdElem);
            }//end if(metaData.createonfield==true)
            //Filter criteria
            var key = commonsTools.keygenerator(model);
            $scope.filtertemplate[key] = field.filter ;
//             alert($scope.currentObject.actions);é
//             var divElem0 = document.createElement('div');
//             divElem0.appendChild(divElem);
//             alert(divElem0.innerHTML);
            if(field.hide){
               divElem.setAttribute('ng-hide',true);
            }//end if(field.hide)
            if(field.hidden!=null&&field.hidden.length>0){
                   divElem.setAttribute('ng-hide',field.hidden);
            }//end if(field.hidden!=null&&field.hidden.length==0)
            //Traitement des observable
            if(field.observable==true){
                var observable = new Observable();
                $scope.observablePools[field.fieldName] = observable;
            }//end if(field.observable==true)
            if(field.observer!=null){
                var observer = new Observer(field.observer,model);
                if($scope.observablePools[field.observer.observable]){
                    observer.register($scope.observablePools[field.observer.observable]);
                }else{
                     var observable = new Observable();
                     $scope.observablePools[field.observer.observable] = observable;
                     observer.register($scope.observablePools[field.observer.observable]);
                }//end if($scope.observablePools[field.fieldName])
            }//end if(field.observer!=null)
             return divElem;
        };
       $scope.showheaderwidget = function(roles ,role){
           return role=="administrateur" || commonsTools.containsLiteral(roles,role);
       }
        /**
         * Build t edit formhe header of th
         * @param {type} model
         * @param {type} metaData
         * @param {type} windowType
         * @returns {undefined}
         */
        $scope.editPanelHeader = function(model , metaData,index,extern){
            //Recuperation du model
            if($scope.windowType==='new'){
                return ;
            }//end if($scope.windowType==='new'){
            var data = $scope.getCurrentModel(model);
            if(metaData && metaData.header && metaData.header.length>0){
                var divElem = document.createElement('div');
                divElem.setAttribute('class','panel panel-default col-sm-12  col-md-12 workflowbar');
//                divElem.setAttribute('style','margin-top: 8px;margin-bottom: 0px;border-top: solid 1px #a8a8a8;background-color: #f0eeee;background-image: linear-gradient(to bottom, #fcfcfc, #dedede);');
                var header = document.createElement('div');
                divElem.appendChild(header);
                header.setAttribute('class','collapse navbar-collapse');
                header.setAttribute('style','position:center;');
//                var navElem = document.createElement('nav');
//                navElem.setAttribute('class','navbar navbar-sm');
//                header.appendChild(navElem);
                var ulElem = document.createElement('ul');
                ulElem.setAttribute('class','nav navbar-nav navbar-left left-menu-bar');
                header.appendChild(ulElem);
                var staturbar = null;
                for(var i=0 ; i<metaData.header.length;i++){
                    //Verified if the user role can access this action
//                    console.log("$scope.getModuleClass = function(module) ========= Roles ===== "+$scope.currentModule.roles+" test== header roles : "+metaData.header[i].roles);                  
                    if(metaData.header[i].hidden!=null){
                        var expr = angular.fromJson(metaData.header[i].hidden);
                        var exprValue = commonsTools.evaluateExpression(data,expr);
                        if(exprValue==false){
//                            console.log("principal.$scope.editPanelHeader = function(model , metaData,index,extern) =============== "+expr+" ===== state : "+expr[0].fieldname+" ==== indexof : "+exprValue);
                            continue;
                        }//end if(exprValue==false){
                        
                    }//end if(metaData.header[i].hidden!=null){
                    var states = metaData.header[i].states;
                    if(metaData.header[i].type=='header'){continue;}
                    if((metaData.header[i].target=='workflow'||(states && states.length>0 && data.state))
                            && commonsTools.containsLiteral(metaData.header[i].states,data.state)==false){
                                                    continue;
                    }//end if(metaData.header[i].target=='workflow'){
                    if(metaData.header[i].type!='workflow' 
                            && $scope.showheaderwidget(metaData.header[i].roles,$scope.currentModule.roles)){
                      var liElem =document.createElement('li');
                      ulElem.appendChild(liElem);
                      var aElem = document.createElement('button');
                      ulElem.appendChild(aElem);
                      var clasElem = 'btn btn-default  btn-sm';
                      if(metaData.header[i].pattern&&metaData.header[i].pattern.length>0){
                          clasElem = "'"+metaData.header[i].pattern+" btn-sm'";
                      }//end if(metaData.header[i].pattern&&metaData.header[i].pattern.length>0){
                      //Verifier si l'etat est autorise
                      if(metaData.header[i].states && metaData.header[i].states.length>0){
                          aElem.setAttribute('ng-click',"buttonAction("+metaData.header[i].value+" , '"+metaData.header[i].target+"','"+angular.toJson(metaData.header[i].states)+"','"+index+"',"+extern+")");
                      }else{
                          aElem.setAttribute('ng-click',"buttonAction("+metaData.header[i].value+" , '"+metaData.header[i].target+"',null,'"+index+"',"+extern+")");
                      }//end if(metaData.header[i].states && metaData.header[i].states.length>0)
                      aElem.setAttribute('class',clasElem);
                      aElem.setAttribute('style','margin-right: 5px;');
                      aElem.innerHTML=metaData.header[i].fieldLabel; 
                   }else{
                      staturbar = metaData.header[i]; 
                   }//end if(metaData.header[i].type!='workflow'){
                }//end for(var i=0 ; i<metaData.header.length;i++)
                
                //Creation de workflow
                if(staturbar!=null){
                    if(data.states && data.states.length>0){
                        var statusElem = document.createElement('ul');
                        statusElem.setAttribute("class","nav navbar-nav navbar-right right-menu-bar");
                        for(var i=0 ; i<data.states.length;i++){
                            var liElem = document.createElement('li');
                            if(data && data[staturbar.fieldName]
                                    && data[staturbar.fieldName]==data.states[i].code){
                               liElem.setAttribute('style','display: inline-block;background-color:#337ab7;height: 30px;font-size: 85%;border-top-right-radius:  50%;border-bottom-right-radius: 50%;padding-left: 5px;padding-right: 5px;');
                           }else{
                               liElem.setAttribute('style','display: inline-block;background-color:#d9d9d9;height: 30px;font-size: 85%;border-top-right-radius:  50%;border-bottom-right-radius: 50%;padding-left: 5px;padding-right: 5px;');
                           }
                            statusElem.appendChild(liElem);
                            var spanElem = document.createElement('span');
                            liElem.appendChild(spanElem);
                            spanElem.setAttribute('class','workflow');
                            if(data && data[staturbar.fieldName]
                                   && data[staturbar.fieldName]==data.states[i].code){
                                spanElem.setAttribute('style','color: white;');
                            }else{
                                spanElem.setAttribute('style','color: black;');
                            }//end if(data && data[staturbar.fieldName]
                            spanElem.appendChild(document.createTextNode(data.states[i].intitule));
                        }//end for(var i=0 ; i<metaData.states.length;i++)
                        header.appendChild(statusElem);
                    }//end if(metaData.states && metaData.states.length>0)
                }//end if(staturbar!=null)
                return divElem;
            }
            
        };

       /**
        * 
        * @param {type} model
        * @param {type} metaData
        * @param {type} windowType
        * @param {type} index
        * @param {type} modelpath
        * @returns {Element}
        */
        $scope.editPanelComponent = function(model , metaData , windowType,index,modelpath,extern){             
                $scope.filtertemplate = new Object(); 
//                console.log("principal.editPanelComponent ============= "+angular.toJson(metaData));
//                metaData = angular.fromJson(metaData);
              var data = $scope.getCurrentModel(model);
              data = angular.fromJson(angular.toJson(data));
              var divElem = null ;
             if(angular.isDefined(metaData)){
                  divElem = document.createElement('div');
                  divElem.setAttribute('class' , 'panel-body');
                  divElem.setAttribute("style","height:100%;overflow-y:initial;");
                  /**
                   * CONSTRUCTION DU HEADER
                   * @type @exp;document@call;createElement
                   */
                  var headerDiv = document.createElement('div');
                  headerDiv.setAttribute("class","col-sm-12 col-md-12");
                  headerDiv.setAttribute("id","detail-panel-body-header");
                  headerDiv.setAttribute("style","padding-bottom:10px;text-align: right;");
                  var imgspan = document.createElement('div');
                  imgspan.setAttribute('class','col-sm-4 col-md-4');
                  imgspan.setAttribute('id','detail-panel-body-header-img');
                  headerDiv.appendChild(imgspan);
                  var actionsspan = document.createElement('div');
                  actionsspan.setAttribute('class','col-sm-6 col-md-6');
                  actionsspan.setAttribute('id','detail-panel-body-header-act');
                  actionsspan.setAttribute('style','text-align: right;float:right;');
                  headerDiv.appendChild(actionsspan);
                  divElem.appendChild(headerDiv);
                  var formElem = document.createElement('form');
                  divElem.appendChild(formElem);
                  formElem.setAttribute('role' , 'form');
                  formElem.setAttribute('class' , 'form-horizontal');
                  formElem.setAttribute('name' , metaData.entityName);
                  formElem.setAttribute("novalidate" , "novalidate");
                  formElem.setAttribute("style","margin-left:15px;");
                  //Construction du header
                 for(var j=0 ; j<metaData.header.length;j++){                      
                      var header = metaData.header[j];                     
                      if(header.type=='header'){                            
                            var span001 = document.createElement('span');
                            span001.setAttribute('class','trt-itemsContent');
                            var span002 = document.createElement('span');
                            span001.appendChild(span002);
                            span002.setAttribute('class','trt-itemImageAndDescriptionContent');
                            var span003 = document.createElement('span');
                            span002.appendChild(span003);
                            var i = document.createElement('i');
                            span003.appendChild(i);
                            i.setAttribute('class',header.pattern);
                            span003.setAttribute('class','trt-itemImage');
                            var span004 = document.createElement('span');
                            span002.appendChild(span004);
                            span004.setAttribute('class','trt-itemDescription');
                            var div01 = document.createElement('div');
                            span004.appendChild(div01);
                            div01.setAttribute('class','trt-itemDescriptionOne');
                            var label = header['label'];                            
//                            console.log("$scope.editPanelComponent ==== "+label+" ===== entrer : === currentObject : "+data[label]+" === data : "+angular.toJson(data));
                            if(angular.isDefined(label) 
                                    && angular.isDefined(data[label])){
                                div01.appendChild(document.createTextNode(data[label]));
                            }//end if(angular.isDefined(header.label)                            
                            var div02 = document.createElement('div');
                            span004.appendChild(div02);
                            div02.setAttribute('class','trt-itemDescriptiontwo');
                            div02.appendChild(document.createTextNode(header.fieldLabel));
                            actionsspan.appendChild(span001);
                            if(header.states && header.states.length>0){
                                span001.setAttribute('ng-click',"buttonAction("+header.value+" , '"+header.target+"','"+angular.toJson(header.states)+"','"+index+"',"+extern+")");
                            }else{
                                span001.setAttribute('ng-click',"buttonAction("+header.value+" , '"+header.target+"',null,'"+index+"',"+extern+")");
                            }//end if(metaData.header[i].states && metaData.header[i].states.length>0)
                      }//end if(metaData.header[i].type=='header'){
                  }//end for(var i=0 ; i<metaData.header.length;i++){
//                  console.log("For editPanelComponent 00i init ::::: "+model+" === Panel edit ::: "+angular.toJson(metaData.columns));
                  //Construction des champs
                  if(angular.isDefined(metaData.columns) && (metaData.columns.length>0)){
                      $scope.panelComponent(model , metaData.columns , metaData.entityName , formElem,divElem,index ,modelpath);                      
                  }//end if(angular.isDefined(metaData.columns) && (metaData.columns.length>0))
//                  console.log("For editPanelComponent ::::: "+model+" === Panel edit");
                 //Construction des tabpane
                 if(angular.isDefined(metaData.groups) && (metaData.groups.length > 0)){
                      //$scope.tabPaneComponent = function(model , labelText , entityName ,groups )
                      metaData.groups = $filter('orderBy')(metaData.groups,'groupName',false);
                      var divElem_2 = $scope.tabPaneComponent(model , metaData.entityName , metaData.entityName , metaData.groups,index ,modelpath);
                      if(angular.isDefined(divElem_2) && (divElem_2 != null)){
                          formElem.appendChild(divElem_2);
                      }//end if(angular.isDefined(divElem_2) && (divElem_2 != null)){
                 }//end if(angular.isDefined(metaData.groups) && (metaData.groups.length > 0)){
//                 console.log("For editPanelComponent ::::: "+model+" === tabPaneComponent");

//                 var divElem0 = document.createElement('div');
//                 divElem0.appendChild(divElem);
//                 console.log(divElem0.innerHTML);

                 return divElem;
 
             }
           
        };
        
       /**
        * 
        * @param {type} model
        * @param {type} metaData
        * @param {type} windowType
        * @returns {Element}
        */
        $scope.editReportPanelComponent = function(metaData){
              
              var divElem = null ;
             if(angular.isDefined(metaData)){
                  divElem = document.createElement('div');
                  divElem.setAttribute('class' , 'panel-body'); 
                  //Construction des champs
                  if(angular.isDefined(metaData.columns) && (metaData.columns.length>0)){
                     //$scope.panelComponent = function(model , fields , entityName)
                       $scope.panelReportComponent($scope.currentObject , metaData.columns  , divElem );                      
                  }
                  //console.log("For editPanelComponent ::::: "+model+" === Panel edit");
                 //Construction des tabpane
                 if(angular.isDefined(metaData.groups) && (metaData.groups.length > 0)){
                      //$scope.tabPaneComponent = function(model , labelText , entityName ,groups )
                      var divElem_2 = $scope.tabPaneReportComponent($scope.currentObject , metaData.groups);
                      if(angular.isDefined(divElem_2) && (divElem_2 != null)){
                          divElem.appendChild(divElem_2);
                      }
                 }
                 //console.log("For editPanelComponent ::::: "+model+" === tabPaneComponent");

                 var divElem0 = document.createElement('div');
                 divElem0.appendChild(divElem);
//                 console.log(divElem0.innerHTML);
                 document.getElementById("report_template").innerHTML = divElem0.innerHTML;
                 return divElem;
 
             }
           
        };

/**
 * 
 * @param {type} model
 * @param {type} fields
 * @param {type} entityName
 * @param {type} viewElem
 * @param {type} metaDataName
 * @returns {@var;viewElem}
 */
      $scope.panelReportComponent = function(model , fields , viewElem ){
              
            if(angular.isDefined(viewElem) && (viewElem!=null)){  
              var divElem = viewElem;
              var row  = document.createElement("div");
              row.setAttribute("class","row");
//              var spanElem_1 = document.createElement('div') ;
//              spanElem_1.setAttribute('class' , 'col-md-6 text-center');
//              divElem.appendChild(spanElem_1);
//              var spanElem_2 = document.createElement('div');
//              spanElem_2.setAttribute('class' , 'col-md-6 text-center');
//              divElem.appendChild(spanElem_2);
              if(fields.length % 2 ==1){
                //fields.push({type:"emailpty" , search:true ,fieldName:" " , fieldLabel:" "})
              }
              if(angular.isDefined(fields)){
                  //Sort of array
                  fields = $filter('orderBy')(fields,'sequence',false);
                  //console.log("$scope.panelComponent :::: "+model+" == "+fields[i]+" == "+entityName+" == "+metaDataName+" == "+angular.toJson(fields[i]));
                  if(fields.length==1){
                      var field = fields[0];
                      var key = field.fieldName ;
                      var col6 = document.createElement("div");
                      col6.setAttribute("class","col-md-6 text-center");
                      var span1 = document.createElement("span");
                      var strong = document.createElement("strong");
                      strong.appendChild(document.createTextNode(field.fieldLabel));
                      span1.appendChild(strong);
                      col6.appendChild(span1);
                      var span2 = document.createElement("span");
                      col6.appendChild($scope.lineTextBuilder(fields[0] , model[key]));
                      row.appendChild(col6);
                      return row;
                  }
                  var start = 0 ;
//                  if(fields[0].type=='image'){
//                      divElem.appendChild($scope.getIhmComponent(model , fields[0] , entityName , metaDataName));
//                      start = 1 ;
//                  }
                  for(var i = start ; i<fields.length ; i++){
                      if(fields[i].type != 'array'|| fields[i].type!='textarea'|| fields[i].type!='richeditor'||fields[i].target=='many-to-many'){
                           var field = fields[i];
                            var key = field.fieldName ;
                            var col6 = document.createElement("div");
                            if(i%2==0){
                                col6.setAttribute("class","col-md-6");
                            }else{
                                col6.setAttribute("class","col-md-6 text-center");
                            }
                            var span1 = document.createElement("span");
                            var strong = document.createElement("strong");
                            strong.appendChild(document.createTextNode(field.fieldLabel));
                            span1.appendChild(strong);
                            col6.appendChild(span1);
                            var br = document.createElement("br");
                            col6.appendChild(br);
                            var span2 = document.createElement("span");
                            var value = model[key];
                            if(angular.isObject(model[key])){
                               span2.appendChild(document.createTextNode(value['designation']));
                            }else if(model[key]){
                               span2.appendChild(document.createTextNode(value)); 
                            }else{
                                span2.appendChild(document.createTextNode(''));
                            }
                            col6.appendChild(span2);
                            row.appendChild(col6);
                        }else{
                            
                           divElem.appendChild($scope.lineTextBuilder(fields[i] , model[key]));
                           
                        }
                  }
              }
              divElem.appendChild(row)
             /* var divElem0 = document.createElement('div');
             divElem0.appendChild(divElem);
             console.log(divElem0.innerHTML);*/
              return divElem;
            }
        };
        /**
             Create component tabPane
             model : field to map
            labelText : the Label of the input
            entityName : name of the entity,
            metaData : MetaData which describe de object
        **/
        $scope.tabPaneReportComponent = function(model,groups ){
            var divElem = document.createElement('div');
            document.createElement('div');
            for(var i=0;i<groups.length;i++){
                if(groups[i].metaArray){
                    var group = groups[i];
//                    console.log("$scope.tabPaneReportComponent == "+angular.toJson(group));
                    var key = group.metaArray['fieldName'];
                    var table = $scope.tableComponentReport(model[key],group.metaArray['metaData']);
                    divElem.appendChild(table);
                }//end if(groups[i].metaArray)
            }
             //divElem0.appendChild(divElem);
             //console.log(divElem0.innerHTML);

            return divElem;

        };
        
           /**
          * 
          * @param {type} model
          * @param {type} metaData
          * @returns {Element}
          */
       $scope.tableComponentReport = function(model,metaData){
//           console.log("$scope.tableComponentReport ========= "+metaData);
            var divresponsive = document.createElement("div");
            divresponsive.setAttribute("class","table-responsive");
             var tableElem = document.createElement('table');
//             tableElem.setAttribute('style','border:solid 1px;')
             divresponsive.appendChild(tableElem);     
             var columns = new Array();
             tableElem.setAttribute('class' , 'table  table-condensed');
             tableElem.setAttribute('style' , 'width: 100%;');
             tableElem.setAttribute('id' , 'table');
             //Creation du table header
             var theadElem = document.createElement('thead');
//             theadElem.setAttribute('style','display: table-header-group;vertical-align: middle; border-color: inherit;');
             tableElem.appendChild(theadElem);
             //Creation entete
             var  rheadElem = document.createElement('tr');
//             rheadElem.setAttribute('class' , 'small');
             theadElem.appendChild(rheadElem);
//             rheadElem.setAttribute('style','border:solid 5px;position: center;');
            //Traitement des champs columns
            if(metaData.columns){
                //Sort of array
                metaData.columns = $filter('orderBy')(metaData.columns,'colsequence',false);  
                var k =0;
                for(var i=0 ; i< metaData.columns.length;i++){
                  if(angular.isDefined(metaData.columns[i].search)
                            &&(metaData.columns[i].search==true)){
                      if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'&&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'){  
                            var thElem = document.createElement('th');
                            thElem.setAttribute("style","font-size: small;");
                            thElem.setAttribute("class","text-center small");
                            thElem.appendChild(document.createTextNode(metaData.columns[i].fieldLabel))  ;
                            columns[k]=metaData.columns[i].fieldName;
                            k++;
                            rheadElem.appendChild(thElem);
                       }//end if(metaData.columns[i].type!='array'
                     }//end if(angular.isDefined(metaData.columns[i].search)
                }
            }
            //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){
                                 if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image'
                                         &&metaData.groups[i].columns[j].type.type!='textarea'&&metaData.groups[i].columns[j].type.type!='richeditor'){   
                                    var thElem = document.createElement('th');
                                    thElem.setAttribute("style","font-size: small;");
                                    thElem.setAttribute("class","text-center small");
                                    thElem.appendChild(document.createTextNode(metaData.groups[i].columns[j].fieldLabel));
                                    columns[k]=metaData.groups[i].columns[j].fieldName;
                                     k++;
                                    rheadElem.appendChild(thElem);
                                }
                            }
                        }//end For
                    }//Fin traitement des colommes
                }
            }

            //Creation du corps du tableau
            var tbodyElem = document.createElement('tbody');
            tableElem.appendChild(tbodyElem);            
 
            for(var i=0 ; i< model.length;i++){
                    var data = model[i];
                    var rbodyElem = document.createElement('tr');   
                    //rbodyElem.setAttribute('class','small');
                    tbodyElem.appendChild(rbodyElem);
                    for(var j=0 ; j<columns.length;j++){ 
                        /*if(data[columns[j]])*/{   
                             var tdElem = document.createElement('td');
                            rbodyElem.appendChild(tdElem);
                            tdElem.setAttribute("style","font-size: small;");
                            tdElem.setAttribute("class","text-center small");
                            var col = data[columns[j]];
                            //console.log(columns[j]+"=============="+angular.toJson(col));                        
                            if(angular.isObject(col)){
                                tdElem.appendChild(document.createTextNode(col['designation']));
                            }else if(col){
                                 tdElem.appendChild(document.createTextNode(col));
//                                tdElem.innerHTML = col;
                                 if(angular.isNumber(col)){
                                     tdElem.setAttribute("class","text-right small");
                                 }//end if(angular.isNumber(col))
                            }else{
                                tdElem.appendChild(document.createTextNode(""));
                            }//end if(col['designation'])
                            //var tdElem = document.createElement('td');
                            //rbodyElem.appendChild(tdElem);
                        }
                       
                    }
                    
             }//construction du tableau        

//            var divElem = document.createElement('div');
//            divElem.appendChild(divresponsive);
//            console.log(divElem.innerHTML);
            return divresponsive;
         };

        
        /**
         * Fonction qui renvoie un composant en fonction de la valeur d'un champs
         * @param {type} model
         * @param {type} field
         * @param {type} entityName
         * @param {type} metaDataName
         * @param {type} index
         * @param {type} modelpath
         * @returns {Element|principal_L470.principalAnonym$31.controller.$scope.aceEditorComponent.divElem|principal_L351.principalAnonym$23.controller.$scope.richEditorComponent.divElem|undefined|principal_L470.principalAnonym$31.controller.$scope.richEditorComponent.divElem}
         */
         $scope.getIhmComponent = function(model , field , entityName , metaDataName,index,modelpath){
//               console.log("$scope.getIhmComponent = function(model , field , entityName , metaDataName) === "+field.fieldName+" ===== "+field.target+" ===== "+field.type+" == "+index);
               if(field.type==='empty'){
                   return $scope.emptyComponentBuilder(model+'.'+field.fieldName, field , field.fieldLabel , field.fieldName , 'empty');
               }else if(field.type==='string'){
                   return $scope.inputTextBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'text');
               }else if(field.type==='number'){
                   return $scope.inputTextBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'number');
               }else if (field.type==='date') {
                   return $scope.inputTextBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'date');
               }else if (field.type==='tel') {
                   return $scope.inputTextBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'tel');
               }else if (field.type==='email') {
                   return $scope.inputTextBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'email');
               }else if (field.type==='url') {
                   return $scope.inputTextBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'url');
               }else if (field.type==='time') {
                   return $scope.inputTextBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'time');
               }else if (field.type==='datetime') {
                   return $scope.inputTextBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'datetime-local');
               }else if (field.type==='password') {
                   return $scope.inputTextBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'password');
               }else if (field.type==='color') {
                   return $scope.inputTextBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'color');
               }else if (field.type==='boolean') {
                   return $scope.checkboxBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'checkbox');
               }else if (field.type==='radio') {
                   return $scope.radioboxBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , field.value);
               }else if (field.type==='combobox') {
                   return $scope.comboBoxComponent(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , field.value);
               }else if (field.type==='textarea') {
                   return $scope.textAreaBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'textarea');
               }else if (field.type==='richeditor') {
                   return $scope.richEditorComponent(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'richeditor');
               }else if (field.type==='aceeditor') {
                   return $scope.aceEditorComponent(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'richeditor');
               }else if (field.type==='image') {
                   return $scope.imageComponentBuilder(model+'.'+field.fieldName , field , field.fieldLabel , field.fieldName , 'textarea');
               }else if((field.type==='file')){                         
                  return $scope.fileLinkComponent(model+'.'+field.fieldName , field.fieldLabel , field.fieldName , field.metaData,field,index,modelpath+'.'+field.fieldName);
               }else if((field.type==='object') && angular.isDefined(field.metaData)){   
                  if(field.target==='one-to-one'){
                      return $scope.oneToOneComponent(model+'.'+field.fieldName , field.fieldLabel , field.fieldName , field.metaData,field,index,modelpath+'.'+field.fieldName);
                  }else{
                     return $scope.manyToOneComponent(model+'.'+field.fieldName , field.fieldLabel , field.fieldName , field.metaData,field,index,modelpath+'.'+field.fieldName);
                  }//end if(field.target==='one-to-one'){
               }else if((field.type === 'array') && (angular.isDefined(field.metaData))){
                    if(field.target === 'many-to-many'){
                       return $scope.manyToManyComponent(model+'.'+field.fieldName , field.fieldLabel , field.fieldName , field.metaData ,field,index,modelpath+'.'+field.fieldName);
                    }else if(field.target === 'one-to-many'){
                       return $scope.oneToManyComponent(model+'.'+field.fieldName , field.fieldLabel , field.fieldName , field.metaData,field,index,modelpath+'.'+field.fieldName,field.edittable);
                    }else if(field.target === 'many-to-many-list'){
                       return $scope.manyToManyListComponent(model+'.'+field.fieldName , field.fieldLabel , field.fieldName , field.metaData,field,index,modelpath+'.'+field.fieldName,field.edittable);
                    }//end if(field.target === 'many-to-many')
               }
        };

       /**
        * 
        * @param {type} model
        * @param {type} fields
        * @param {type} entityName
        * @param {type} viewElem
        * @param {type} metaDataName
        * @param {type} index
        * @param {type} modelpath
        * @returns {@var;viewElem}
        */
        $scope.panelComponent = function(model , fields , entityName , viewElem , elem,index,modelpath){
//            console.log("$scope.panelComponent ========== "+angular.toJson(fields));
            if(angular.isDefined(viewElem) && (viewElem!=null)){  
              var divElem = viewElem;
              var spanElem_1 = document.createElement('span') ;
              spanElem_1.setAttribute('style' , 'display: inline-block;margin-right: 20px;width: 48%;');
              divElem.appendChild(spanElem_1);
              var spanElem_2 = document.createElement('span');
              spanElem_2.setAttribute('style' , 'display: inline-block;width: 48%;');
              divElem.appendChild(spanElem_2);
              
              if(angular.isDefined(fields)){                  //Sort of array
                  fields = $filter('orderBy')(fields,'sequence',false);
//                  console.log(" $scope.tabPaneComponent =  "+angular.toJson(fields[0]));         
                  if(fields.length==1){
                      var spanElem_1 = document.createElement('span') ;
                      spanElem_1.setAttribute('style' , 'display: inline-block;margin-right: 20px;width: 96%;');
                      spanElem_1.appendChild($scope.getIhmComponent(model , fields[0] , entityName , null,index,modelpath));
                      divElem.appendChild(spanElem_1);
                      return divElem;
                  }//end if(fields.length==1){
                  var start = 0 ;                  
//                  if(fields[0].type=='image'){
//                      divElem.appendChild($scope.getIhmComponent(model , fields[0] , entityName , metaDataName));
//                      start = 1 ;
//                  }
                  for(var i = 0 ; i<fields.length ; i++){
                      //zend if(group==false){
//                      console.log("$scope.panelComponent ===== "+fields[i].fieldName+" ======= type :"+fields[i].type);
                       if(fields[i].type==='state' || fields[i].hide===true){
                           continue;
                       }//end if(fields[i].type==='image'){
                       if(fields[i].type==='image'){
                                var spanElem = document.createElement('span');
//                                spanElem.setAttribute('id','display: inline-block;margin-right: 20px;width: 48%;float: left;');
                                spanElem.append($scope.getIhmComponent(model , fields[i], entityName , null,index,modelpath));
                                var imgdiv = document.createElement('div');
                                imgdiv.setAttribute('class','pull-left');
                                imgdiv.setAttribute('id','detail-panel-body-header-img');
                                imgdiv.append(spanElem);
                                var items = angular.element(elem).find("div");
                                for(var j=0; j<items.length;j++){                 
                                  if(items.eq(j).attr("id")=="detail-panel-body-header-img"){
      //                                console.log("Youpiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
                                        items.eq(j).append(imgdiv);                      
                                  }//end if(items.eq(i).attr("id")=="detail-panel-body"){  
                                }//end for(var i=0; i<items.length;i++){ 
                       }else if(fields[i].type!= 'array'|| fields[i].type!='richeditor'){
                           if(i%2 == 0){
                                spanElem_1.appendChild($scope.getIhmComponent(model , fields[i], entityName , null,index,modelpath));
                            }else{
                               spanElem_2.appendChild($scope.getIhmComponent(model , fields[i] , entityName , null,index,modelpath));
                            }//end if(i%2 == 0){
                      }else{
                         divElem.appendChild($scope.getIhmComponent(model , fields[i] , entityName , null,index,modelpath));
                      }//end  if($scope.panelComponent.type != 'array'|| fields[i].type!='textarea'|| fields[i].type!='richeditor'||fields[i].target=='many-to-many'){
                  }//end for(var i = 0 ; i<fields.length ; i++){
              }
             /* var divElem0 = document.createElement('div');
             divElem0.appendChild(divElem);
             console.log(divElem0.innerHTML);*/
              return divElem;
            }
        };


        /**
             Create component tabPane
             model : field to map
            labelText : the Label of the input
            entityName : name of the entity,
            metaData : MetaData which describe de object
        **/
        $scope.tabPaneComponent = function(model , labelText , entityName ,groups ,index,modelpath){
//            console.log("$scope.tabPaneComponent ================= "+index);
            var id = generateurId();
            var divElem = document.createElement('div');
            divElem.setAttribute('role' , 'tabpanel');
            var ulElem = document.createElement('ul');
            ulElem.setAttribute('class' , 'nav  nav-tabs');
            ulElem.setAttribute('role' , 'tablelist');            
            divElem.appendChild(ulElem);
            //Sort of array
            groups = $filter('orderBy')(groups,'sequence',false);
            for(var i=0 ; i < groups.length;i++){
               var liElem = document.createElement('li');
               ulElem.appendChild(liElem);
               liElem.setAttribute('role' , 'presentation');
               var aElem = document.createElement('a');
               liElem.appendChild(aElem);
               aElem.setAttribute('href' , '#'+groups[i].groupName+id);
               aElem.setAttribute('aria-control' , groups[i].groupName+id);
               aElem.setAttribute('role' , 'tab');
               aElem.setAttribute('data-toggle' , 'tab');
               aElem.appendChild(document.createTextNode(groups[i].groupLabel));
            } //end for(var i=0 ; i < groups.length;i++){             
            //Creation du contenu de panel
            var divElem_1 = document.createElement('div');
            divElem.appendChild(divElem_1);
            divElem_1.setAttribute('class' , 'tab-content');
            divElem.appendChild(divElem_1);

            for(var i=0 ; i< groups.length;i++){
                  var divElem_2 = document.createElement('div');
                  divElem_2.setAttribute('role' , 'tabpanel');
                  if(i==0){ 
                        divElem_2.setAttribute('class' , 'tab-pane active');
                  }else{
                       divElem_2.setAttribute('class' , 'tab-pane');
                  }//end if(i==0){
                  divElem_2.setAttribute('id' , groups[i].groupName+id);
                  //Construction du corps      
                  if(angular.isDefined(groups[i].columns)&&groups[i].columns.length>0){              
                      $scope.panelComponent(model , groups[i].columns,entityName , divElem_2 ,null,index,modelpath);
                  }//end if(angular.isDefined(groups[i].columns)&&groups[i].columns.length>0){ 
                 if(angular.isDefined(groups[i].metaArray) && (groups[i].metaArray.length>0)){
                     for(var j=0 ; j<groups[i].metaArray.length;j++){
                            var header = null;
                            if(groups[i].metaArray[j].fieldLabel!=""){
                                header = document.createElement('div');
                                var labelElem = document.createElement('label');
                                labelElem.appendChild(document.createTextNode("{{'"+groups[i].metaArray[j].fieldLabel+"' | translate}}"));
                                header.appendChild(labelElem);
                            }//end if(groups[i].metaArray[i].fieldName!=""){
                            //Cas des donnÃ©es de type oneToManay et ManyToMany
                            var tableElem = null;
//                            console.log(angular.toJson(groups[i].metaArray));  
                            if(groups[i].metaArray[j].target == 'one-to-many'){
                                tableElem = $scope.oneToManyComponent(model+'.'+groups[i].metaArray[j].fieldName 
                                                  , labelText 
                                                  , groups[i].metaArray[j].metaData.entityName
                                                  ,groups[i].metaArray[j].metaData
                                                  ,groups[i].metaArray[j],index
                                                  ,modelpath+'.'+groups[i].metaArray[j].fieldName
                                                  ,groups[i].metaArray[j].edittable);
                            }else if(groups[i].metaArray[j].target == 'many-to-many-list'){
                                tableElem = $scope.manyToManyListComponent(model+'.'+groups[i].metaArray[j].fieldName 
                                                  , labelText 
                                                  , groups[i].metaArray[j].metaData.entityName
                                                  ,groups[i].metaArray[j].metaData
                                                  ,groups[i].metaArray[j],index
                                                  ,modelpath+'.'+groups[i].metaArray[j].fieldName
                                                  ,groups[i].metaArray[j].edittable);
                            }//end if(groups[i].metaArray[j].target == 'one-to-many'){
                            if(angular.isDefined(tableElem)&&tableElem!=null){
                              var divElem_3 = document.createElement('div');
//                              divElem_3.setAttribute('class' , ' col-sm-12  col-md-12');
                              if(header!=null){
                                  divElem_3.appendChild(header);
                              }//end if(header!=null){
                              divElem_3.appendChild(tableElem);
                              divElem_2.appendChild(divElem_3);
                            }//end if(angular.isDefined(tableElem)&&tableElem!=null){
                     }//end  for(var i=0 ; i<groups[i].metaArray.length;i++){
                      
                  }//end if(angular.isDefined(groups[i].metaArray) && (groups[i].metaArray.length>0)){                 

                  divElem_1.appendChild(divElem_2);
            }//end for(var i=0 ; i< groups.length;i++){

             //var divElem0 = document.createElement('div');
             //divElem0.appendChild(divElem);
             //console.log(divElem0.innerHTML);

            return divElem;

        };
        
 
      /**
        Template provider :provide the template for view builder
        @type : template type (list , detail ,kaban , calendar)
      **/
      $scope.viewSelector = function(type){                                 
                                   var content  = null ;
                                   if(type==='list'){    
                                      if($rootScope.globals.theme!=null && $rootScope.globals.theme.tree){
                                          content = $rootScope.globals.theme.tree;
                                      }else{
                                        content ="<div class='panel panel-default container-panel  table-responsive'  id='innerpanel' style='height: 100%;width: 100%;'> <div class='container-heading-panel'> <nav id='listebar' class='navbar navbar-default container-heading-panel'  role='navigation'> <div class='col-sm-12  col-md-12  nav nav-justified navbar-nav container-heading-panel'> <div class='navbar-header col-sm-6 col-md-5  container-heading-panel'> <button type='button'  class='navbar-toggle' data-toggle='collapse'  data-target='#Navbar'> <span class='sr-only'>Toggle Navigation</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a  class='navbar-brand' href='#'>{{metaData.listTitle}}</a>  </div> <div class='col-sm-6 col-md-7  container-heading-panel'> <form class='navbar-form navbar-search  navbar-right' role='Search' id='filtercontainer' style='width: 100%;' > <div class='input-group' style='width: 100%;'> <span class='input-group-btn pull-left'  style='display: inline-block;width: 20%;'> <button type='button' class='btn btn-search btn-sm btn-default dropdown-toggle' data-toggle='dropdown' id='filtertbtn' style='width: 100%;'> <span class='glyphicon glyphicon-filter'></span> <span class='label-icon'>{{'Filtres' | translate}}</span> <span class='caret'></span> </button> <ul class='dropdown-menu' role='menu'  id='filterActionsId'> <li> <a href='#'> <span class='glyphicon glyphicon-user'></span> <span class='label-icon'>Search By User</span> </a> </li> <li> <a href='#'> <span class='glyphicon glyphicon-book'></span> <span class='label-icon'>Search By Organization</span> </a> </li> </ul> </span> <span class='input-group-btn  pull-left' style='display: inline-block;width: 80%;'> <input type='text' ng-model='searchCriteria' id='search-text-id' class='form-control input-sm' style='width: 93%;'> <button type='button' class='btn btn-search btn-sm btn-default' ng-click='searchAction()'> <span class='glyphicon glyphicon-search'></span> </button> </span>  </div>  </form> </div> <br /><br /><br /> <div class='btn-toolbar' role='toolbar'  aria-label='Toolbar1'><div class='btn-group'  role='group'  aria-label='group 1' ng-hide='showback==false'> <button type='button'  class='btn btn-primary btn-sm' ng-click='backAction()'>{{'Quitter' | translate}}</button> </div><div class='btn-group'  role='group'  aria-label='group 1' ng-hide='desablecreate'> <button type='button'  class='btn btn-primary btn-sm' ng-click='addElementAction()'>{{'Creer' | translate}}</button> </div><div class='btn-group'  role='group'  aria-label='group 1' ng-hide='desableupdate'> <button type='button'  class='btn btn-default btn-sm'  ng-click='importAction()'  id='importerbtn'>{{'Importer' | translate}}</button> </div>  <div class='btn-group  dropdown'    role='group'  aria-label='group 2' ng-hide='desableprint'> <button type='button'  class='btn btn-default btn-sm dropdown dropdown-toggle' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='imprimerbtn'> {{'Imprimer' | translate}} <span class='caret'></span> </button> <ul id='print_menus' class='dropdown-menu'  role='menu'  aria-labelledby='imprimerbtn'> <li role='presentation'> <a role='menuitem' tabindex='-1' href='#' ng-click='printAction()'> {{'Imprimer' | translate}} </a> </li> </ul> </div>  <div class='btn-group  dropdown'    role='group'  aria-label='group 2' ng-hide='desableprint'> <button type='button'  class='btn btn-default btn-sm dropdown dropdown-toggle' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='actionsbtn'  ng-show='showActions()'> {{'Actions' | translate}} <span class='caret'></span> </button> <ul class='dropdown-menu'  role='menu'  aria-labelledby='actionsbtn' id='actions_menu'> <li role='presentation'> <a role='menuitem' tabindex='-1' href='#'  ng-click='exportAction()'>{{exportbtnlabel | translate}}</a> </li> <li role='presentation' ng-hide='desableupdate'> <a role='menuitem' tabindex='-1' href='#'  ng-click='updateAction()'> {{updatebtnlabel | translate}}</a> </li> <li role='presentation'  ng-hide='desabledelete'> <a role='menuitem' tabindex='-1' href='#'  ng-click='deleteListAction()'>{{deletebtnlabel | translate}}</a> </li> </ul> </div>  <span class='pull-right'> <div class='btn-group'  role='group'  aria-label='group 3'> <span class='btn btn-default btn-sm'>{{pagination.currentPage}}-{{pagination.endIndex}} / {{pagination.totalPages}}</span> <button type='button'  class='btn btn-default btn-sm' ng-click='pagination.previous()'  ng-disabled='!pagination.hasprevious()'> <span class='glyphicon glyphicon-chevron-left'  aria-hidden='true'></span> </button> <button type='button'  class='btn btn-default btn-sm' ng-click='pagination.next()' ng-disabled='!pagination.hasnext()'> <span class='glyphicon glyphicon-chevron-right'  aria-hidden='true'></span> </button> </div> <div id='viewmodeid'></div></span>  </div> </div> </nav> </div><div class='panel-body container-body-panel'  id='datatable' style='height: 82%;overflow: hidden;margin-top: -10px;'><div id='datawidget'> <table class='table table-striped table-hover table-responsive table-sm  table-header'  style='margin-top: -10px;' id='table'> <thead> <tr id='rowheader'> <th><input type='checkbox' ng-model='tableheaderselected' ng-click='onCheckboxClick()'></th> <th>Module Name</th> <th>Module Description</th> </tr> </thead> <tbody id='tablebody'> <tr  ng-repeat=' module in modules' > <td><input type='checkbox' ng-model='module.selected'  ng-click='onRowCheckboxClick(module)'></td> <td>{{module.name}}</td> <td>{{module.shortDescription}}</td> </tr> </tbody> </table></div></div></div>"     ;
                                      }//end if($rootScope.globals.theme!==null&&$rootScope.globals.theme.tree){
                                   }else if(type==='detail'){
                                       if($rootScope.globals.theme!=null && $rootScope.globals.theme.form){
                                           content = $rootScope.globals.theme.form;
                                       }else{
                                          content = "<div class='panel panel-default' id='innerpanel' style='padding:0;height:100%;'> <div class='panel-container' style='height: 100% ;border:0px;'> <nav id='listebar' class='navbar navbar-default detail-heading'  role='navigation'> <div class='navbar-header  col-sm-12  col-md-12'> <button type='button'  class='navbar-toggle' data-toggle='collapse'  data-target='#Navbar'> <span class='sr-only'>Toggle Navigation</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a  class='navbar-brand' href='#'  >{{metaData.editTitle}} / {{suffixedittitle}}</a> </div> <div class='btn-toolbar' role='toolbar'  aria-label='Toolbar1'> <div class='btn-group'  role='group'  aria-label='group 1' ng-hide='desablecreateedit'> <button type='button'  class='btn btn-primary btn-sm' ng-click ='saveOrUpdate()'>{{'Enregistrer' | translate}}</button> </div> <div class='btn-group'  role='group'  aria-label='group 1'> <button type='button'  class='btn btn-default btn-sm' ng-hide='hideannuler==true' ng-click='annulerAction()'>{{'Quitter' | translate}}</button> </div> <div class='btn-group  dropdown'    role='group'  aria-label='group 2'   ng-hide='desableprintedit'> <button type='button'  class='btn btn-default dropdown dropdown-toggle btn-sm' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='imprimerbtn'> {{'Imprimer' | translate}} <span class='caret'></span> </button> <ul  id='print_menus'  class='dropdown-menu'  role='menu'  aria-labelledby='imprimerbtn'> <li role='presentation'> <a role='menuitem' tabindex='-1' href='#'  ng-click='printAction()'> {{'Imprimer' | translate}} </a> </li> </ul> </div> <div class='btn-group  dropdown'    role='group'  aria-label='group 2'   ng-hide='iscreateOperation()'> <button type='button'  class='btn btn-default dropdown dropdown-toggle btn-sm' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='imprimerbtn' ng-show='showpjmenu==true'> {{'PJ' | translate}} <span class='caret'></span> </button> <ul class='dropdown-menu'  role='menu'  aria-labelledby='piecejointebtn' id='pj_menus_id'> <li role='presentation'> <span style='display: inline-block;'> <span style='display: inline-block;margin-right: 15px;'> <a role='menuitem' tabindex='-1' href='#' ng-click='printAction()'> Contrat de travail </a> </span> <span style='display: inline-block;'> <a style='margin-right: 50;'> <span class='glyphicon glyphicon-trash'  aria-hidden='true'></span> </a> </span> </span> </li> <li role='presentation'> <a role='menuitem' tabindex='-1' href='#' ng-click='printAction()'> {{'Ajouter' | translate}} </a> </li> </ul> <input type='file' id='pj_file_input' style='display: none' fileinput='file'  onchange='angular.element(this).scope().gererChangementFichier(event)'> </div> <div class='btn-group  dropdown'    role='group'  aria-label='group 2'   ng-hide='hideMenuActions()'> <button type='button'  class='btn btn-default btn-sm dropdown dropdown-toggle' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='actionsbtn'> {{'Actions' | translate}} <span class='caret'></span> </button> <ul class='dropdown-menu'  role='menu'  aria-labelledby='actionsbtn' id='actions_menu'> <li role='presentation'  ng-hide='showApplication==false'> <a role='menuitem' tabindex='-1' href='#'  ng-click='installAction()'> {{exportbtnlabel | translate}} </a> </li><li role='presentation'  ng-hide='desableupdateedit'> <a role='menuitem' tabindex='-1' href='#'  ng-click='updateAction()'> {{updatebtnlabel | translate}} </a> </li><li role='presentation'  ng-hide='desableupdateedit'> <a role='menuitem' tabindex='-1' href='#'  ng-click='dupliquerAction()'> {{'Dupliquer' | translate}} </a> </li><li role='presentation'  ng-hide='desableupdateedit'> <a role='menuitem' tabindex='-1' href='#'  ng-click='addElementAction()'> {{'Creer' | translate}} </a> </li><li role='presentation' ng-hide='desabledeleteedit'> <a role='menuitem' tabindex='-1' href='#'  ng-click='deleteAction()'> {{deletebtnlabel | translate}} </a> </li> </ul> </div> <span class='pull-right'   ng-hide='iscreateOperation()'> <div class='btn-group'  role='group'  aria-label='group 3'> <span class='btn btn-default btn-sm'>{{pagination.currentPage}} / {{pagination.totalPages}}</span> <button type='button'  class='btn btn-default  btn-sm' ng-click='pagination.previousPage()' ng-disabled='!pagination.hasPreviousPage()'> <span class='glyphicon glyphicon-chevron-left'  aria-hidden='true'></span> </button> <button type='button'  class='btn btn-default btn-sm' ng-click='pagination.nextPage()' ng-disabled='!pagination.hasNextPage()'> <span class='glyphicon glyphicon-chevron-right'  aria-hidden='true'></span> </button> </div> </span> <div id='workflow_menu_id'></div> </div> </nav><div id='detail-panel-header'></div> <div class='panel-body panel-container' style='padding:0;border:0px;height:85%; margin-top: -15px;' > <div class='panel panel-default col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1' ><div class='panel-body'  id='detail-panel-body'><div id='detail-panel-body-header'></div><form role='form' class='form-horizontal'  name='myForm' novalidate> <span style='display: inline-block;margin-right: 20px;width: 48%;'> <div class='form-group  col-sm-12  col-md-12'> <img src='img\photo.png'  class='img-responsive' alt='Image '> </div> <div class='form-group  col-sm-12  col-md-12'> <label for='name'>Nom</label> <input type='text' class='form-control'  id='name' placeholder='Votre Nom' ng-required='true' ng-minlength='2'> </div> <div class='form-group  col-sm-12  col-md-12'> <label for='birthday'>Date de Naissance</label> <input type='date' class='form-control'  id='birthday' placeholder='Votre Nom'> </div> <div class='form-group  col-sm-12  col-md-12'> <label for='sexe'>Sexe</label> <div class='input-group'> <select class='form-control'  data-style='btn-default'> <option>Masculin</option> <option>Feminin</option> </select> <span class='input-group-btn'> <button type='button' class='btn btn-default my-group-button' data-toggle='modal' data-target='#myModal'> <span class='glyphicon glyphicon-plus' aria-hidden='true' style='color:blue'></span> </button> </span> </div> </div> </span> <span style='display: inline-block;width: 48%;'> <div class='form-group  col-sm-12  col-md-12'> <label for='description'>Description</label> <input type='text' class='form-control'  id='description' placeholder='Votre Description' ng-minlength='3'> </div> <div class='form-group  col-sm-12  col-md-12'> <label for='heurenaissance'>Heure de Naissance</label> <input type='time' class='form-control'  id='heurenaissance' placeholder='Votre Description'> </div> <div class='form-group  col-sm-12  col-md-12'> <label for='sexe'>Sexe</label> <div class='input-group'> <select class='selectpicker form-control'  multiple data-style='btn-default'> <option>Masculin</option> <option>Feminin</option> </select> <span class='input-group-btn'> <button type='button' class='btn btn-default my-group-button' data-toggle='modal' data-target='#myModal'> <span class='glyphicon glyphicon-plus' aria-hidden='true' style='color:blue'></span> </button> </span> </div> </div> <div class='form-group  col-sm-12  col-md-12'> <label for='actions'>undefined</label> <div class='input-group' > <select class='selectpicker form-control' bootstrap-selectpicker multiple='multiple' data-style='btn-default' ng-model='dataSelects' ng-options='item as item.name for item in currentObject.actions' ng-click='getData(actions)' >  </select> <span class='input-group-btn'> <button class='btn btn-default my-group-button' ng-click='editDialogBuilder(metaData)'> <span class='glyphicon glyphicon-plus' aria-hidden='true' style='color:blue'></span> </button> </span> </div> </div> </span> <div class='table-responsive'> <table class='table  table-striped table-bordered table-hover table-condensed'> <thead> <tr style='font-weight: bold;'> <th>Nom Module</th> <th>Description</th> </tr> </thead> <tbody> <tr> <ul class='nav navbar-nav'> <li> <a href='#'   data-toggle='modal'  data-target='#myModal'  ng-click='editDialogBuilder()'> <span class='glyphicon glyphicon-plus' aria-hidden='true'></span> </a> </li> <li> <a href='#' data-toggle='modal'  data-target='#myModal'> <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span> </a> </li> <li> <a href='#'> <span class='glyphicon glyphicon-trash' aria-hidden='true'></span> </a> </li> <li> <a href='#'  data-toggle='modal'  data-target='#myModal'> <span class='glyphicon glyphicon-eye-open' aria-hidden='true'></span> </a> </li> </ul> </tr> <tr > <td>GC</td> <td>Gestion Commerciale</td> </tr> <tr> <td>MT</td> <td>Gestion de la maintenance</td> </tr> </tbody> </table> </div> <div  role='tabpanel'> <ul class='nav  nav-tabs'  role='tablist'> <li role='presentation'> <a href='#profile'  aria-control='profile'  role='tab'  data-toggle='tab'> Onglet 1 </a> </li> <li role='presentation'> <a href='#message'  aria-control='message'  role='tab'  data-toggle='tab'> Onglet 2 </a> </li> </ul> <div class='tab-content'> <div role='tabpanel'  class='tab-pane active'  id='profile' > Conteneur 1 </div> <div role='tabpanel'  class='tab-pane'  id='message' >  </div> </div> </div> </form> </div> </div> <div class='col-sm-12 col-md-12' style='background-color: white;'   ng-show='shownotepanel()' style='display:none;'> <div class='panel-heading'> <div class='btn-group'  role='group'  aria-label='group 1'> <button type='button'  class='btn btn-primary btn-sm' ng-click ='messagesAction()'>Nouveau Message</button> </div> <div class='btn-group'  role='group'  aria-label='group 1' style='margin-left: 10px;'> <a href='#'  class='a-sm' style='border:none;text-decoration: none;' ng-click ='notesInterneAction()'>Enregistrer une note interne</a> </div> <span class='pull-right'> <div class='btn-group'  role='group'  aria-label='group 1' style='right: 150px;'> <button type='button'  class='btn btn-default btn-sm' ng-click ='suivreAction()' ng-if='activefollower==false'>Ne pas suivre<span class='glyphicon glyphicon-remove' aria-hidden='true'></button> <button type='button'  class='btn btn-default btn-sm' ng-click ='suivreAction()' ng-if='activefollower==true'> AbonnÃ©e(s) <span class='glyphicon glyphicon-ok' aria-hidden='true'></span> </button> </div> <div class='btn-group  dropdown'    role='group'  aria-label='group 2'  style='right: 120px;'> <a href='#'  class='dropdown dropdown-toggle btn-sm' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='imprimerbtn'> <span class='caret'></span> <span class='glyphicon glyphicon-user' aria-hidden='true'></span> </a> <ul class='dropdown-menu'  role='menu'  aria-labelledby='imprimerbtn' id='followermenuid'> <li role='presentation'> <a role='menuitem' tabindex='-1' href='#'  ng-click='editPanelAjoutAborne()'> Ajouter des abonnÃ©es </a> </li> <li role='presentation'> <a role='menuitem' tabindex='-1' href='#'  ng-click='editPanelAjoutCanaux()'> Ajouter des canaux </a> </li> <li class='dropdown-divider'></li> </ul> </div> </span>  </div> <div class='panel-heading'> <div class='input-group' ng-show='enablefollowerpanel==true'> <input type='text' class='form-control'  id='name' placeholder='Saisir votre message' ng-required='true' ng-model='dataCache.messageobject.body' ng-minlength='2'> <div class='input-group-btn  dropdown'    role='group'  aria-label='group 2'> <button type='button'  class='btn btn-default dropdown dropdown-toggle btn-sm' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='pjidbtn'  ng-click='imageClick(\"followerfileinput_id\")'><span class='glyphicon glyphicon-paperclip'  aria-hidden='true' style='color:blue;'></span> <span class='caret'></span> </button> <input type='file' id='followerfileinput_id' style='display: none' fileinput='file'   onchange='angular.element(this).scope().gererChangementFichier2(event)'> </div> <span class='input-group-btn'> <button type='button'  class='btn btn-default btn-sm' ng-click ='sendAction()'> <span class='glyphicon glyphicon-send' aria-hidden='true' style='color:blue'> </span> </button> </span> </div> <div><div  id='followermenu_id'></div> </div></div> <div style='height: 87%;width:100%;overflow: auto;'> <table class='table table-inbox table-hover'  id='tablefollowersid'> <tbody> <tr class='unread'> <td class='inbox-small-cells'> <input type='checkbox' class='mail-checkbox'> </td> <td class='inbox-small-cells'><i class='fa fa-star'></i></td> <td class='view-message  dont-show'>PHPClass</td> <td class='view-message '>Added a new class: Login Class Fast Site</td> <td class='view-message  inbox-small-cells'><i class='fa fa-paperclip'></i></td> <td class='view-message  text-right'>9:27 AM</td> </tr> </tbody> </table> </div>    </div> </div> </div></div>"   ;
                                       }//end if($rootScope.globals.theme!==null&&$rootScope.globals.theme.form){
                                   }else if(type==="report"){
                                       if($rootScope.globals.theme!==null&&$rootScope.globals.theme.report){
                                           content = $rootScope.globals.theme.report;
                                       }else{
                                          content = "<div class='panel panel-default' id='innerpanel' style='padding:0;height:100%;'> <div class='panel-container' style='height: 100% ;border:0px;'> <nav id='listebar' class='navbar navbar-default detail-heading'  role='navigation'> <div class='navbar-header  col-sm-12  col-md-12'> <button type='button'  class='navbar-toggle' data-toggle='collapse'  data-target='#Navbar'> <span class='sr-only'>Toggle Navigation</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a class='navbar-brand' href='#' ng-show='showreporttitle==true'>{{metaData.editTitle}} / {{suffixedittitle}}</a><a class='navbar-brand' href='#' ng-show='showreporttitle==false'>{{currentObject.editTitle}} / {{suffixedittitle}}</a> </div> <div class='btn-toolbar' role='toolbar'  aria-label='Toolbar1'> <div class='btn-group'  role='group'  aria-label='group 1' style='margin-left: 30px;'> <button type='button'  class='btn btn-default btn-sm' ng-click='annulerAction()' >{{'Quitter' | translate}}</button> </div>  </div> </nav>   <div class='panel-body panel-container' style='padding:0;border:0px;height:85%; margin-top: -15px;' > <div id='report'>  </div> </div>";
                                       }//end if($rootScope.globals.theme!==null&&$rootScope.globals.theme.report){
                                   }else if(type==="dashboard"){ 
                                       if($rootScope.globals.theme!=null && $rootScope.globals.theme.tree){
                                           content = $rootScope.globals.theme.tree;
                                       }else{
                                          content = "<div class='panel panel-default' id='innerpanel' style='padding:0;height:100%;'> <div class='panel-container' style='height: 100% ;border:0px;'> <nav id='listebar' class='navbar navbar-default detail-heading'  role='navigation'> <div class='navbar-header  col-sm-12  col-md-12'> <button type='button'  class='navbar-toggle' data-toggle='collapse'  data-target='#Navbar'> <span class='sr-only'>Toggle Navigation</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a class='navbar-brand' href='#'></a><a class='navbar-brand' href='#' >{{currentObject.editTitle}}</a> </div> <div class='btn-toolbar' role='toolbar'  aria-label='Toolbar1'> <div class='btn-group'  role='group'  aria-label='group 1'> <button type='button'  class='btn btn-default btn-sm' ng-click='annulerAction()' ng-hide='hideannuler'>{{'Quitter' | translate}}</button> </div>  </div> </nav>   <div class='panel-body panel-container' style='padding:0;border:0px;height:85%; margin-top: -15px;' > <div id='datawidget'>  </div> </div>";
                                       }//end if($rootScope.globals.theme!==null&&$rootScope.globals.theme.dashbord){
                                   }else if(type==="calendar"){ 
                                       if($rootScope.globals.theme!=null && $rootScope.globals.theme.tree){
                                           content = $rootScope.globals.theme.tree;
                                       }else{
                                          content ="<div class='panel panel-default container-panel  table-responsive'  id='innerpanel' style='height: 100%;width: 100%;'> <div class='container-heading-panel'> <nav id='listebar' class='navbar navbar-default container-heading-panel'  role='navigation'> <div class='col-sm-12  col-md-12  nav nav-justified navbar-nav container-heading-panel'> <div class='navbar-header col-sm-6 col-md-5  container-heading-panel'> <button type='button'  class='navbar-toggle' data-toggle='collapse'  data-target='#Navbar'> <span class='sr-only'>Toggle Navigation</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a  class='navbar-brand' href='#'>{{metaData.listTitle}}</a> </div> <div class='col-sm-6 col-md-7  container-heading-panel'> <form class='navbar-form navbar-search  navbar-right' role='Search' id='filtercontainer' style='width: 100%;' > <div class='input-group' style='width: 100%;'> <span class='input-group-btn pull-left'  style='display: inline-block;width: 20%;'> <button type='button' class='btn btn-search btn-sm btn-default dropdown-toggle' data-toggle='dropdown' id='filtertbtn' style='width: 100%;'> <span class='glyphicon glyphicon-filter'></span> <span class='label-icon'>{{'Filtres' | translate}}</span> <span class='caret'></span> </button> <ul class='dropdown-menu' role='menu'  id='filterActionsId'> <li> <a href='#'> <span class='glyphicon glyphicon-user'></span> <span class='label-icon'>Search By User</span> </a> </li> <li> <a href='#'> <span class='glyphicon glyphicon-book'></span> <span class='label-icon'>Search By Organization</span> </a> </li> </ul> </span> <span class='input-group-btn  pull-left' style='display: inline-block;width: 80%;'> <input type='text' ng-model='searchCriteria' class='form-control input-sm' style='width: 93%;'> <button type='button' class='btn btn-search btn-sm btn-default' ng-click='searchAction()'> <span class='glyphicon glyphicon-search'></span> </button> </span>  </div>  </form> </div> <br /><br /><br /> <div class='btn-toolbar' role='toolbar'  aria-label='Toolbar1'> <div class='btn-group'  role='group'  aria-label='group 1' ng-hide='desablecreate'> <button type='button'  class='btn btn-primary btn-sm' ng-click='addElementAction()' ng-hide='true'>Creer</button> </div>  <div class='btn-group'  role='group'  aria-label='group 1' ng-hide='true'> <button type='button'  class='btn btn-default btn-sm'  ng-click='importAction()'  id='importerbtn'>{{'Importer' | translate}}</button> </div>  <div class='btn-group  dropdown'    role='group'  aria-label='group 2' ng-hide='desableprint'> <button type='button'  class='btn btn-default btn-sm dropdown dropdown-toggle' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='imprimerbtn'> {{'Imprimer' | translate}} <span class='caret'></span> </button> <ul id='print_menus' class='dropdown-menu'  role='menu'  aria-labelledby='imprimerbtn'> <li role='presentation'> <a role='menuitem' tabindex='-1' href='#' ng-click='printAction()'> Imprimer </a> </li> </ul> </div>  <div class='btn-group  dropdown'    role='group'  aria-label='group 2' ng-hide='desableprint'> <button type='button'  class='btn btn-default btn-sm dropdown dropdown-toggle' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='actionsbtn'  ng-show='showActions()'> Actions <span class='caret'></span> </button> <ul class='dropdown-menu'  role='menu'  aria-labelledby='actionsbtn' id='actions_menu'> <li role='presentation'> <a role='menuitem' tabindex='-1' href='#'  ng-click='exportAction()'>{{exportbtnlabel}}</a> </li> <li role='presentation' ng-hide='desableupdate'> <a role='menuitem' tabindex='-1' href='#'  ng-click='updateAction()'> {{updatebtnlabel}}</a> </li> <li role='presentation'  ng-hide='desableAction'> <a role='menuitem' tabindex='-1' href='#'  ng-click='deleteListAction()'>{{deletebtnlabel | translate}}</a> </li> </ul> </div>  <span class='pull-right'> <div class='btn-group'  role='group'  aria-label='group 3'> <span class='btn btn-default btn-sm'>{{pagination.currentPage}}-{{pagination.endIndex}} / {{pagination.totalPages}}</span> <button type='button'  class='btn btn-default btn-sm' ng-click='pagination.previous()'  ng-disabled='!pagination.hasprevious()'> <span class='glyphicon glyphicon-chevron-left'  aria-hidden='true'></span> </button> <button type='button'  class='btn btn-default btn-sm' ng-click='pagination.next()' ng-disabled='!pagination.hasnext()'> <span class='glyphicon glyphicon-chevron-right'  aria-hidden='true'></span> </button> </div><div id='viewmodeid'></div></span>  </div> </div> </nav> </div>   <div class='panel-body container-body-panel'  id='datatable' style='height: 82%;overflow: auto;margin-top: -10px;'><div id='datawidget' class='col-sm-12  col-md-12' id='calendar' ui-calendar='uiConfig.calendar' ng-model='eventSources' calendar='myCalendar' ></div></div> </div>";                                               
                                       }//end if($rootScope.globals.theme!==null&&$rootScope.globals.theme.calendar){
                                    }else if(type==="kaban"){ 
                                       if($rootScope.globals.theme!=null && $rootScope.globals.theme.tree){
                                           content = $rootScope.globals.theme.tree;
                                       }else{
                                          content ="<div class='panel panel-default container-panel  table-responsive'  id='innerpanel' style='height: 100%;width: 100%;'> <div class='container-heading-panel'> <nav id='listebar' class='navbar navbar-default container-heading-panel'  role='navigation'> <div class='col-sm-12  col-md-12  nav nav-justified navbar-nav container-heading-panel'> <div class='navbar-header col-sm-6 col-md-5  container-heading-panel'> <button type='button'  class='navbar-toggle' data-toggle='collapse'  data-target='#Navbar'> <span class='sr-only'>Toggle Navigation</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a  class='navbar-brand' href='#'>{{metaData.listTitle}}</a> </div> <div class='col-sm-6 col-md-7  container-heading-panel'> <form class='navbar-form navbar-search  navbar-right' role='Search' id='filtercontainer' style='width: 100%;' > <div class='input-group' style='width: 100%;'> <span class='input-group-btn pull-left'  style='display: inline-block;width: 20%;'> <button type='button' class='btn btn-search btn-sm btn-default dropdown-toggle' data-toggle='dropdown' id='filtertbtn' style='width: 100%;'> <span class='glyphicon glyphicon-filter'></span> <span class='label-icon'>{{'Filtres' | translate}}</span> <span class='caret'></span> </button> <ul class='dropdown-menu' role='menu'  id='filterActionsId'> <li> <a href='#'> <span class='glyphicon glyphicon-user'></span> <span class='label-icon'>Search By User</span> </a> </li> <li> <a href='#'> <span class='glyphicon glyphicon-book'></span> <span class='label-icon'>Search By Organization</span> </a> </li> </ul> </span> <span class='input-group-btn  pull-left' style='display: inline-block;width: 80%;'> <input type='text' ng-model='searchCriteria' class='form-control input-sm' style='width: 93%;'> <button type='button' class='btn btn-search btn-sm btn-default' ng-click='searchAction()'> <span class='glyphicon glyphicon-search'></span> </button> </span>  </div>  </form> </div> <br /><br /><br /> <div class='btn-toolbar' role='toolbar'  aria-label='Toolbar1'> <div class='btn-group'  role='group'  aria-label='group 1' ng-hide='desablecreate'> <button type='button'  class='btn btn-primary btn-sm' ng-click='addElementAction()' ng-hide='true'>Creer</button> </div>  <div class='btn-group'  role='group'  aria-label='group 1' ng-hide='true'> <button type='button'  class='btn btn-default btn-sm'  ng-click='importAction()'  id='importerbtn'>{{'Importer' | translate}}</button> </div>  <div class='btn-group  dropdown'    role='group'  aria-label='group 2' ng-hide='desableprint'> <button type='button'  class='btn btn-default btn-sm dropdown dropdown-toggle' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='imprimerbtn'> {{'Imprimer' | translate}} <span class='caret'></span> </button> <ul id='print_menus' class='dropdown-menu'  role='menu'  aria-labelledby='imprimerbtn'> <li role='presentation'> <a role='menuitem' tabindex='-1' href='#' ng-click='printAction()'> Imprimer </a> </li> </ul> </div>  <div class='btn-group  dropdown'    role='group'  aria-label='group 2' ng-hide='desableprint'> <button type='button'  class='btn btn-default btn-sm dropdown dropdown-toggle' data-toggle='dropdown' aria-haspopup='false'  aria-expanded='true' id='actionsbtn'  ng-show='showActions()'> Actions <span class='caret'></span> </button> <ul class='dropdown-menu'  role='menu'  aria-labelledby='actionsbtn' id='actions_menu'> <li role='presentation'> <a role='menuitem' tabindex='-1' href='#'  ng-click='exportAction()'>{{exportbtnlabel}}</a> </li> <li role='presentation' ng-hide='desableupdate'> <a role='menuitem' tabindex='-1' href='#'  ng-click='updateAction()'> {{updatebtnlabel}}</a> </li> <li role='presentation'  ng-hide='desableAction'> <a role='menuitem' tabindex='-1' href='#'  ng-click='deleteListAction()'>{{deletebtnlabel | translate}}</a> </li> </ul> </div>  <span class='pull-right'> <div class='btn-group'  role='group'  aria-label='group 3'> <span class='btn btn-default btn-sm'>{{pagination.currentPage}}-{{pagination.endIndex}} / {{pagination.totalPages}}</span> <button type='button'  class='btn btn-default btn-sm' ng-click='pagination.previous()'  ng-disabled='!pagination.hasprevious()'> <span class='glyphicon glyphicon-chevron-left'  aria-hidden='true'></span> </button> <button type='button'  class='btn btn-default btn-sm' ng-click='pagination.next()' ng-disabled='!pagination.hasnext()'> <span class='glyphicon glyphicon-chevron-right'  aria-hidden='true'></span> </button> </div><div id='viewmodeid'></div></span>  </div> </div> </nav> </div>   <div class='panel-body container-body-panel'  id='datatable' style='height: 82%;overflow: auto;margin-top: -10px;'><div id='datawidget' class='col-sm-12  col-md-12' id='calendar' ui-calendar='uiConfig.calendar' ng-model='eventSources' calendar='myCalendar' ></div></div> </div>";                                               
                                       }//end if($rootScope.globals.theme!==null&&$rootScope.globals.theme.calendar){
                                    }else if(type==="import"){
                                       content = "<div class='panel panel-default' id='innerpanel' style='padding:0;height:100%;'>  <div class='panel-container' style='height: 100% ;border:0px;'> <nav id='listebar' class='navbar navbar-default detail-heading'  role='navigation'>  <div class='navbar-header  col-sm-12  col-md-12'> <button type='button'  class='navbar-toggle' data-toggle='collapse'  data-target='#Navbar'>  <span class='sr-only'>Toggle Navigation </span>  <span class='icon-bar'> </span>  <span class='icon-bar'> </span>  <span class='icon-bar'> </span> </button> <a  class='navbar-brand' href='#'>{{'IMPORTDATA' | translate}}</a> </div>  <div class='btn-toolbar' role='toolbar'  aria-label='Toolbar1'>  <div class='panel panel-default col-sm-12  col-md-12' style='margin-top: 8px;margin-bottom: 0px;border-top: solid 1px #a8a8a8;background-color: #f0eeee;background-image: linear-gradient(to bottom, #fcfcfc, #dedede);' >  <div class='collapse navbar-collapse'  style='position: center;' id='detail-panel-header'> <ul class='nav navbar-nav navbar-left left-menu-bar'> <button style='margin-right: 5px;' class='btn btn-default  btn-sm' href='#' ng-click='validerFileAction()'  ng-disabled='importData.fichier==null'>Valider</button> <button class='btn btn-default btn-sm' href='#'  ng-click='importFileAction()' ng-disabled='importData.fichier==null'>Importer</button> <button class='btn btn-default btn-sm' href='#'  ng-click='annulerAction()'>Annuler</button> </ul> </div> </div> </div> </nav>  <div class='panel-body panel-container' style='padding:0;border:0px;height:80%;' >  <div class='panel panel-default' >  <div class='panel-body col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1'  id='detail-panel-body'>  <form role='form' class='form-horizontal'  name='myForm' style='background-color: white;padding: 15px;' novalidate>  <span style='display: inline-block;margin-right: 20px;width: 48%;'>  <div class='form-group  col-sm-12  col-md-12'> <label for='name'>{{'Fichier' | translate}} </label> <input type='file' ng-model='importData.fichier'  class='form-control' id='filename_pj'  placeholder='Selectionnez le fichier' ng-required='true'  onchange='angular.element(this).scope().gererChangementFichier4(event)'> </div>  <div class='form-group  col-sm-6  col-md-6'> <label for='sexe'>{{'Format' | translate}} </label>  <div class='input-group'> <select class='form-control'  data-style='btn-default'  ng-model='importData.format'>  <option>cvs</option>  <option>excel</option> </select> </div> </div>  <div class='form-group  col-sm-6  col-md-6' ng-hide='isCVS()'> <label for='separator'>{{'Separateur' | translate}} </label> <input type='text' class='form-control' ng-model='importData.separator' placeholder='Veuillez saisir le separateur'> </div> </span>  <div class='table-responsive'> <table class='table  table-striped table-bordered table-hover table-condensed'> <thead> <tr style='font-weight: bold;'> <th>{{'Statut' | translate}} </th> <th>{{'Champ'|translate}} </th> <th>{{'Description' | translate}} </th> <th>{{'Obligatoire'|translate}}(?) </th> </tr> </thead> <tbody> <tr  ng-repeat='row in importData.fields'> <td> <input type='checkbox' name='' ng-model='row.selected'  disabled='false'> </td> <td>{{row.code}} </td> <td>{{row.description}} </td> <td> <input type='checkbox' name='' ng-model='row.optional' disabled='true'> </td> </tr> </tbody> </table> </div> </form> </div> </div> </div> </div> </div>";                                       
                                    }else if(type==="export"){
                                       content = "<div class='modal-body' id='modalbody' style='padding:0;height:100%;'>  <div class='panel-container' style='height: 100% ;border:0px;'>  <div class='panel-body panel-container' style='padding:0;border:0px;height:85%;'>  <div   id='detail-panel-body' style='padding:0;'>  <form role='form' class='form-horizontal'  name='myForm' style='background-color:white;padding:10px;' novalidate>  <span style='display: inline-block;margin-right: 20px;width: 48%;'>  <div class='form-group  col-sm-6  col-md-6'> <label for='sexe'>Type d'export </label>  <div class='input-group'> <select class='form-control'  data-style='btn-default'  ng-model='importData.typeexport'>  <option value='0'>Export personalisÃ©</option>  <option value='1'>Exporter toutes les donnÃ©es</option> </select> </div> </div> </span>  <span style='display: inline-block;width: 48%;'>  <div class='form-group  col-sm-6  col-md-6'> <label for='sexe'>Formats d'export </label>  <div class='input-group'> <select class='form-control'  data-style='btn-default'  ng-model='importData.format'>  <option>cvs</option>  <option>excel</option> </select> </div> </div> </span>  <div class='table-responsive' ng-hide='exportAll()'> <table class='table  table-striped table-bordered table-hover table-condensed'> <thead> <tr style='font-weight: bold;'> <th>Statut </th> <th>Champ </th> <th>Description </th> <th>Optional(?) </th> </tr> </thead> <tbody> <tr  ng-repeat='row in importData.fields'> <td> <input type='checkbox' name='' ng-model='row.selected'> </td> <td>{{row.code}} </td> <td>{{row.description}} </td> <td> <input type='checkbox' name='' ng-model='row.optional' disabled='true'> </td> </tr> </tbody> </table> </div> </form> </div> </div> </div> </div>";
                                    }
                                    //Parse the content to treat javascript ,css ,less file
                                    return commonsTools.themeParser(content);
//                                   return angular.element(content);
                             };
      

        /**
         * 
         * @returns {Boolean}
         */
            $scope.isCVS = function(){
                return $scope.importData.format!='cvs';
            };
            $scope.exportAll = function(){
                return $scope.importData.typeexport=='1';
            };
            /**
                      * 
           * @param {type} metaData
           * @returns {undefined}
           */
          $scope.templateReportList = function(metaData){
              if(metaData){
                  var report =  $scope.tableListComponentReport(metaData);
                  var row = document.createElement("div");
                  row.setAttribute("class","row");
                  var colmd12 = document.createElement("div");
                  colmd12.setAttribute("class","col-md-12");
                  row.appendChild(colmd12);
                  var panel = document.createElement("div");
                  colmd12.appendChild(panel);
                  //panel.setAttribute("class" ,"panel panel-default");
                  var header = document.createElement("header");
//                  header.setAttribute("class","panel-heading");
                  panel.appendChild(header);
                  var h3 = document.createElement("h3");
                  var strong = document.createElement("strong");
                  strong.appendChild(document.createTextNode(metaData.listTitle));
                  h3.appendChild(strong);
                  //h3.setAttribute("class","panel-title text-center");
                  header.appendChild(h3);
                  var footer = document.createElement("footer");
                  panel.appendChild(footer);
                  //Body Creation
                  var body = document.createElement("div");
                  //body.setAttribute("class","panel-body")
                  body.appendChild(report);
                  panel.appendChild(body);
                  var divElem = document.createElement('div');
                  divElem.setAttribute('style','width:100%;');
                  divElem.appendChild(row);
                  document.getElementById("report_template").innerHTML = divElem.innerHTML;
              }//end if(metaData)
          };
          
          /**
           * Moteur de template pour le traitement des 
           * etats à partir de HTML
           * @param {type} String
           * @returns {undefined}
           */
          $scope.displayReportPanel_HTML = function(script,report){ 
              var container = commonsTools.preParser(script,$scope.currentModule);
              var compileFn = $compile(container);
              var container = compileFn($scope);
              $timeout(function(){
                 document.getElementById("report_template").innerHTML = container[0].outerHTML;  
                 $scope.displayer(report);
//                 console.log("$scope.displayReportPanel_HTML 000 ============== "+container[0].outerHTML);
             });
//             console.log("$scope.displayReportPanel_HTML ============== "+container);
          };          
        
          /**
           * 
           * @returns {undefined}
           */
          $scope.displayDashboardPanel = function(){
//                var url =$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase($scope.currentObject.moduleName)+"/"+angular.lowercase($scope.currentObject.entity)+"/"+angular.lowercase($scope.currentObject.method);
//                console.log("principal.displayDashboardPanel ================================ "+url);
                $scope.showreporttitle = false;
                $scope.suffixedittitle = $scope.currentObject.designation;
                var  contentElem = $scope.viewSelector('dashboard') ;
                $scope.desablecreate = true;
                 $scope.desableupdate = true;
                 $scope.desabledelete = true;
                 $scope.desableprint = true;
                var compileFn = $compile(contentElem);
                compileFn($scope);
                var container = commonsTools.dashboardContainerBuilder($scope.currentObject ,$scope);
                var items = contentElem.find('div');
                for(var i=0; i<items.length;i++){
                   if(items.eq(i).attr("id")=="datawidget"){
                         items.eq(i).replaceWith(container);                               
                   }//end if(items.eq(i).attr("id")=="datawidget"){  
                }//enn$d for(var i=0; i<items.length;i++){
                 // ///Remplacement dans la vue
                var items = $element.find("div");
                for(var i=0; i<items.length;i++){
                     if(items.eq(i).attr("id")=="innerpanel"){
                           items.eq(i).replaceWith(contentElem);
                            //console.log(" ======================= on a trouve report  innerpanel");
                     }//end if(items.eq(i).attr("id")=="innerpanel")  
                }//end if(items.eq(i).attr("id")=="innerpanel")
                return contentElem;
          };
         
          /**
           * 
           * @returns {undefined}
           */
          $scope.displayReportPanel = function(script , report){                
               if($scope.windowType=='list'){
                   if($scope.selectedObjects.length>0){
                       $scope.templateReportList($scope.metaData);
                        $scope.displayer(report);
                   }else{
                        $scope.notifyWindow("Veuillez selectionner au moins une ligne" ,"<br/>","warning");
                   }//end if($scope.selectedObjects.length>0)
                }else if($scope.windowType=='report'){
                    $scope.displayReportPanel_HTML(script , report);   
//                    return ;
                }else{
                    $scope.editReportPanelComponent($scope.metaData);
                    $scope.displayer(report);
                }              
              
          };
          /**
           * Construct the viewer of pdf report
           * @returns {undefined}
           */
          $scope.displayer = function(report){                
                var  contentElem = $scope.viewSelector('report') ;
                var compileFn = $compile(contentElem);
                compileFn($scope);  
                var orientation ='p';
                var unite = 'pt';
                var format = 'a4';
                if(angular.isDefined(report)){
                    if(report.orientation && report.orientation!=""){
                        orientation = report.orientation;
                    }//end if(report.orientation && report.orientation!=""){
                    if(report.unite && report.unite!=""){
                        unite = report.unite;
                    }//end if(report.orientation && report.orientation!=""){
                    if(report.format && report.format!=""){
                        format = report.format;
                    }//end if(report.orientation && report.orientation!=""){
                }//end if(angular.isDefined(report)){
//                console.log("::::::::::::::::::::   :::::: orientation : "+orientation+"  unite : "+unite+" === format : "+format);
                var doc = new jsPDF(orientation, unite, format);
                doc.setProperties({
                        title: $scope.metaData.entityName,
                        subject: 'Info about PDF',
                        author: 'BKD',
                        keywords: 'generated, javascript, web 2.0, ajax',
                        creator: 'BEKO&PARTNER'
                });
                var specialElementHandlers = {
                    '#editor': function (element, renderer) {
                        return true;
                    },
                    '.controls':function(element,renderer){
                        return true ;
                    }
                };
                var source = $("#report_template")[0],
                        margins={
                            top: 25,
                            bottom: 40,
                            left: 40,
                            width: 700
                        };
                        doc.fromHTML(
                             source,
                             margins.left,
                             margins.top,
                             {
                                  // y coord
                                'width': margins.width, // max width of content on PDF
                                'elementHandlers':specialElementHandlers
                             },
                             function(dispose){
                                  var iframe = document.createElement('iframe');
                                    iframe.setAttribute('style','position:absolute;right:0; top:15%; bottom:0; height:100%; width:100%;');
                                    //document.body.appendChild(iframe);
                                    iframe.src = doc.output('datauristring');
                                    iframe.setAttribute('name' ,"internal");                  
                                    var div = document.createElement('div');
                                    div.appendChild(iframe);
                                    div.setAttribute("target" ,"internal");
                                    var items = contentElem.find('div');
                                    for(var i=0; i<items.length;i++){
                                       if(items.eq(i).attr("id")=="report"){
                                             items.eq(i).replaceWith(iframe);                               
                                       }//end if(items.eq(i).attr("id")=="report"){  
                                   }//enn$d for(var i=0; i<items.length;i++){
                                   //var compileFn = $compile(contentElem);

                                   // ///Remplacement dans la vue
                                  var items = $element.find("div");
                                  for(var i=0; i<items.length;i++){
                                       if(items.eq(i).attr("id")=="innerpanel"){
                                             items.eq(i).replaceWith(contentElem);
                                              //console.log(" ======================= on a trouve report  innerpanel");
                                       }//end if(items.eq(i).attr("id")=="innerpanel"){  
                                  }//end for(var i=0; i<items.length;i++){
                                  document.getElementById("report_template").innerHTML = "";
                                 //doc.save("Test.pdf");
                             },
                             margins                                 
                      );
          };
          /**
             * 
             * @param {type} message
             * @returns {undefined}
             */
            $scope.followerpiecejointeMenu = function(message){                 
                  var divElem = document.createElement('div');
                  divElem.setAttribute('id','followermenu_id');             
                  var pbjmenu = document.querySelector('#followermenu_id');
                    if(pbjmenu!=null){
                         pbjmenu.replaceWith(divElem);
                    }                
                 commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
                   var pieces = message.piecesjointe;
                    if(pieces && pieces.length>0){
                        divElem.setAttribute('class','media');                  
                         var divElem1 = document.createElement('div');
                        divElem.appendChild(divElem1);
                        divElem1.setAttribute("class","media-body");
                        for(var i=0 ;i<pieces.length;i++){
                            var act = pieces[i];                            
                            var spanElem = document.createElement("span");
                            divElem1.appendChild(spanElem);
                            spanElem.setAttribute("style","display: inline-block;");
                            var span_1 = document.createElement("span");
                            span_1.setAttribute("style","inline-block;margin-right: 15px;");
                            spanElem.appendChild(span_1);
                            var span_2 = document.createElement("span");
                            span_2.setAttribute("style","inline-block;");
//                            span_2.setAttribute("ng-hide","desabledelete==true");
                            spanElem.appendChild(span_2);
                            var aElem = document.createElement('a');
                            span_1.appendChild(aElem);
                            aElem.setAttribute('role','menuitem');
                            aElem.setAttribute('tabindex','-1');
                            aElem.setAttribute('href','#');
                            aElem.setAttribute('ng-click',"followerpiecejointeviewAction("+act.id+",'"+act.filename+"')");
                            aElem.setAttribute('style',"text-decoration: none;");
                            aElem.appendChild(document.createTextNode(act.attachename)) ;
                            aElem = document.createElement('a');
                            span_2.appendChild(aElem);
                            aElem.setAttribute('style','margin-right: 50;text-decoration: none;');
                            aElem.setAttribute('tabindex','-1');
                            aElem.setAttribute('href','#');
                            aElem.setAttribute('ng-click',"followerpiecejointedeleteAction('"+act.filename+"')");
                            var span_3 = document.createElement('span');
                            aElem.appendChild(span_3);
                            span_3.setAttribute('class','glyphicon glyphicon-trash');
                            span_3.setAttribute('aria-hidden','true');
                        }//end for(var i=0 ;i<pieces.length;i++) 
                        var compileFn = $compile(divElem);
                        compileFn($scope);
                      }//end if(pieces && pieces.length>0) desableupdateedit                                      
                    
                        commonsTools.hideDialogLoading();
//                            var divElem0 = document.createElement("div");
//                            divElem0.appendChild(divElem);
//                            console.log(divElem0.innerHTML); 
//               return viewElem;
        };
          /**
           * 
           * @param {type} message
           * @returns {undefined}
           */
          $scope.followerpiecejointeMenuOld = function(message){                 
                  var ulElem = document.createElement('ul');
                  ulElem.setAttribute('class','dropdown-menu');
                  ulElem.setAttribute('role','menu');
                  ulElem.setAttribute('aria-labelledby','piecejointebtn');
                  ulElem.setAttribute("id","followermenu_id");  
                  var pbjmenu = document.querySelector('#followermenu_id');
                    if(pbjmenu!=null){
                         pbjmenu.replaceWith(ulElem);
                    }//end if(pbjmenu!=null){                
                 commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
                   var pieces = message.piecesjointe;
                    if(pieces && pieces.length>0){
                        for(var i=0 ;i<pieces.length;i++){
                            var act = pieces[i];
                            var liElem = document.createElement('li');
                            liElem.setAttribute('role','presentation');
                            ulElem.appendChild(liElem);
                            var spanElem = document.createElement("span");
                            spanElem.setAttribute("style","display: inline-block;");
                            liElem.appendChild(spanElem);
                            var span_1 = document.createElement("span");
                            span_1.setAttribute("style","inline-block;margin-right: 15px;");
                            spanElem.appendChild(span_1);
                            var span_2 = document.createElement("span");
                            span_2.setAttribute("style","inline-block;");
//                            span_2.setAttribute("ng-hide","desabledelete==true");
                            spanElem.appendChild(span_2);
                            var aElem = document.createElement('a');
                            span_1.appendChild(aElem);
                            aElem.setAttribute('role','menuitem');
                            aElem.setAttribute('tabindex','-1');
                            aElem.setAttribute('href','#');
                            aElem.setAttribute('ng-click',"followerpiecejointeviewAction("+act.id+",'"+act.filename+"')");
                            aElem.setAttribute('style',"text-decoration: none;");
                            aElem.appendChild(document.createTextNode(act.attachename)) ;
                            aElem = document.createElement('a');
                            span_2.appendChild(aElem);
                            aElem.setAttribute('style','margin-right: 50;text-decoration: none;');
                            aElem.setAttribute('tabindex','-1');
                            aElem.setAttribute('href','#');
                            aElem.setAttribute('ng-click',"followerpiecejointedeleteAction('"+act.filename+"')");
                            var span_3 = document.createElement('span');
                            aElem.appendChild(span_3);
                            span_3.setAttribute('class','glyphicon glyphicon-trash');
                            span_3.setAttribute('aria-hidden','true');
                        }//end for(var i=0 ;i<pieces.length;i++)    
                      }//end if(pieces && pieces.length>0) desableupdateedit
                    var liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    ulElem.appendChild(liElem);
                    var aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','imageClick("pjfileinput_id")');
                    aElem.appendChild(document.createTextNode("{{'Ajouter' | translate}}")) ;                            
                    liElem.appendChild(aElem);      
                    ulElem.appendChild(liElem);                       
                    var compileFn = $compile(ulElem);
                    compileFn($scope);
                    commonsTools.hideDialogLoading();
//                            var divElem = document.createElement("div");
//                            divElem.appendChild(ulElem);
//                            alert(divElem.innerHTML); 
//               return viewElem;
        };
          //
          
           /**
         * Construction du menu des pieces jointes
         * @param {type} metaData
         * @returns {undefined}
         */
        $scope.piecejointeMenu = function(viewElem,model,metaData){
            if(metaData && (metaData.activefilelink==true)){
                 if($scope.currentAction && angular.isString($scope.currentAction)){
                    $scope.currentAction = angular.fromJson($scope.currentAction);
                 }//end if($scope.currentAction && angular.isString($scope.currentAction))
                  var ulElem = document.createElement('ul');
                  ulElem.setAttribute('class','dropdown-menu');
                  ulElem.setAttribute('role','menu');
                  ulElem.setAttribute('aria-labelledby','piecejointebtn');
                  ulElem.setAttribute("id","pj_menus_id");  
                  
                  if(viewElem!=null){
                    var items = viewElem.find("ul");
                    for(var i=0; i<items.length;i++){
                        if(items.eq(i).attr("id")=="pj_menus_id"){
                              items.eq(i).replaceWith(ulElem);
                        }//end if(items.eq(i).attr("id")=="pj_menus_id"){  
                    }//end for(var i=0; i<items.length;i++)
                 }else{
                     var pbjmenu = document.querySelector('#pj_menus_id');
                     if(pbjmenu!=null){
                          pbjmenu.replaceWith(ulElem);
                     }//end if(pbjmenu!=null){
                 }//end if(viewElem!=null)
                 commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
                var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/piecejointe/pj/"+model.serial+"/"+model.id;
                $http.get(url)
                        .then(function(response){
                            var pieces = response.data;
                            if(pieces && pieces.length>0){
                                for(var i=0 ;i<pieces.length;i++){
                                    var act = pieces[i];
                                    var liElem = document.createElement('li');
                                    liElem.setAttribute('role','presentation');
                                    ulElem.appendChild(liElem);
                                    var spanElem = document.createElement("span");
                                    spanElem.setAttribute("style","display: inline-block;");
                                    liElem.appendChild(spanElem);
                                    var span_1 = document.createElement("span");
                                    span_1.setAttribute("style","inline-block;margin-right: 15px;");
                                    spanElem.appendChild(span_1);
                                    var span_2 = document.createElement("span");
                                    span_2.setAttribute("style","inline-block;");
                                    span_2.setAttribute("ng-hide","desabledelete==true");
                                    spanElem.appendChild(span_2);
                                    var aElem = document.createElement('a');
                                    span_1.appendChild(aElem);
                                    aElem.setAttribute('role','menuitem');
                                    aElem.setAttribute('tabindex','-1');
                                    aElem.setAttribute('href','#');
                                    aElem.setAttribute('ng-click',"piecejointeviewAction("+act.id+",'"+act.filename+"')");
                                    aElem.setAttribute('style',"text-decoration: none;");
                                    aElem.appendChild(document.createTextNode(act.attachename)) ;
                                    aElem = document.createElement('a');
                                    span_2.appendChild(aElem);
                                    aElem.setAttribute('style','margin-right: 50;text-decoration: none;');
                                    aElem.setAttribute('tabindex','-1');
                                    aElem.setAttribute('href','#');
                                    aElem.setAttribute('ng-click',"piecejointedeleteAction("+act.id+",'"+act.filename+"')");
                                    var span_3 = document.createElement('span');
                                    aElem.appendChild(span_3);
                                    span_3.setAttribute('class','glyphicon glyphicon-trash');
                                    span_3.setAttribute('aria-hidden','true');
                                }//end for(var i=0 ;i<pieces.length;i++)    
                            }//end if(pieces && pieces.length>0) desableupdateedit
                           if($scope.desableupdateedit==false||$scope.desableupdate==false||$rootScope.globals.user.intitule=='Administrateur'){ 
                                var liElem = document.createElement('li');
                                liElem.setAttribute('role','presentation');
                                ulElem.appendChild(liElem);
                                var aElem = document.createElement('a');
                                aElem.setAttribute('role','menuitem');
                                aElem.setAttribute('tabindex','-1');
                                aElem.setAttribute('href','#');
                                aElem.setAttribute('ng-click','imageClick("pj_file_input")');
                                aElem.appendChild(document.createTextNode("{{'Ajouter' | translate}}")) ;                            
                                liElem.appendChild(aElem);      
                                ulElem.appendChild(liElem);
                           }//end if($scope.desableupdate==tre)
                            var compileFn = $compile(ulElem);
                            compileFn($scope);
                            commonsTools.hideDialogLoading();
//                            var divElem = document.createElement("div");
//                            divElem.appendChild(ulElem);
//                            alert(divElem.innerHTML);
                        },function(error){
                            commonsTools.hideDialogLoading();
                            commonsTools.showMessageDialog(error);
                        });
                         
            }//end if(metaData && (metaData.activefilelien==true) 
//               return viewElem;
        };
          /**
           * 
           * @param {type} viewElem
           * @returns {undefined}
           */
          $scope.buildPrintActionsMenu = function(viewElem){
              if($scope.currentAction && angular.isString($scope.currentAction)){
                  $scope.currentAction = angular.fromJson($scope.currentAction);
               }//end if($scope.currentAction && angular.isString($scope.currentAction))
                var ulElem = document.createElement('ul');
                ulElem.setAttribute('class','dropdown-menu');
                ulElem.setAttribute('role','menu');
                ulElem.setAttribute('aria-labelledby','imprimerbtn');
                ulElem.setAttribute("id","print_menus");
                var liElem = document.createElement('li');
                liElem.setAttribute('role','presentation');
                ulElem.appendChild(liElem);
                var aElem = document.createElement('a');
                aElem.setAttribute('role','menuitem');
                aElem.setAttribute('tabindex','-1');
                aElem.setAttribute('href','#');
                aElem.setAttribute('ng-click','printAction()');
                aElem.appendChild(document.createTextNode('Imprimer')) ;
                liElem.appendChild(aElem);
                var array = new Array();
//                console.log("$scope.buildPrintActionsMenu = function(viewElem){ ===== "+$scope.currentAction.records.length);
                if($scope.currentAction.records&&$scope.currentAction.records.length>0){
                  for(var i=0 ; i<$scope.currentAction.records.length;i++){
                      var act = $scope.currentAction.records[i];
                      if(!commonsTools.contains(array,act)){
                        var liElem = document.createElement('li');
                        liElem.setAttribute('role','presentation');
                        liElem.setAttribute('ng-hide','desableupdateedit');
                        ulElem.appendChild(liElem);
                        var aElem = document.createElement('a');
                        aElem.setAttribute('role','menuitem');
                        aElem.setAttribute('tabindex','-1');
                        aElem.setAttribute('href','#');
                        aElem.setAttribute('ng-click',"customPrintAction('"+act.id+"')");
                        aElem.appendChild(document.createTextNode(act.titre)) ;
                        liElem.appendChild(aElem);
                        array.push(act);
                     }//end if(!commonsTools.contains()){
                   }//end for(var i=0 ; i<$scope.currentAction.actions.length;i++){
                    var items = viewElem.find("ul");
                    for(var i=0; i<items.length;i++){
                         if(items.eq(i).attr("id")=="print_menus"){
                               items.eq(i).replaceWith(ulElem);
                         }//end if(items.eq(i).attr("id")=="print_menus"){  
                    }//end for(var i=0; i<items.length;i++){
                   
               }//end if($scope.currentAction.records&&$scope.currentAction.records.length>0)
//               var divElem = document.createElement("div");
//               divElem.appendChild(ulElem);
//               console.log(divElem.innerHTML);
               return viewElem;
          };
          /**
           * 
           * @param {type} viewElem
           * @returns {unresolved}
           */
          $scope.buildActionsMenu = function(viewElem , type,index){
               if($scope.currentAction && angular.isString($scope.currentAction)){
                  $scope.currentAction = angular.fromJson($scope.currentAction);
               }//end if($scope.currentAction && angular.isString($scope.currentAction)){
               var ulElem = document.createElement('ul');
                ulElem.setAttribute('class','dropdown-menu');
                ulElem.setAttribute('role','menu');
                ulElem.setAttribute('aria-labelledby','aria-labelledby');
                ulElem.setAttribute("id","actions_menu");
                if($scope.windowType=='list'){
                    var liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    ulElem.appendChild(liElem);
                    var aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','exportAction()');
                    aElem.appendChild(document.createTextNode('{{exportbtnlabel | translate}}')) ;
                    liElem.appendChild(aElem);
                   //Bloc 2
                    liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    liElem.setAttribute('ng-hide','desableupdate');
                    ulElem.appendChild(liElem);
                    aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','updateAction()');
                    aElem.appendChild(document.createTextNode('{{updatebtnlabel | translate}}')) ;
                    liElem.appendChild(aElem);
                     //Bloc 3
                    liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    liElem.setAttribute('ng-hide','desabledelete');
                    ulElem.appendChild(liElem);
                    aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','deleteListAction()');
                    aElem.appendChild(document.createTextNode('{{deletebtnlabel | translate}}')) ;
                    liElem.appendChild(aElem);
                }else if($scope.windowType=='kaban'){
                    var liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    ulElem.appendChild(liElem);
                    var aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','exportAction()');
                    aElem.appendChild(document.createTextNode('{{exportbtnlabel | translate}}')) ;
                    liElem.appendChild(aElem);
                   //Bloc 2
                    liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    liElem.setAttribute('ng-hide','desableupdate');
                    ulElem.appendChild(liElem);
                    aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','updateAction()');
                    aElem.appendChild(document.createTextNode('{{updatebtnlabel | translate}}')) ;
                    liElem.appendChild(aElem);
                     //Bloc 3
                    liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    liElem.setAttribute('ng-hide','desabledelete');
                    ulElem.appendChild(liElem);
                    aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','deleteListAction()');
                    aElem.appendChild(document.createTextNode('{{deletebtnlabel | translate}}')) ;
                    liElem.appendChild(aElem);
                }else{
                    //Update
                    var liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    liElem.setAttribute('ng-hide','desableupdateedit');
                    ulElem.appendChild(liElem);
                    aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','updateAction()');
                    aElem.appendChild(document.createTextNode('{{updatebtnlabel | translate}}')) ;
                    liElem.appendChild(aElem);
                    //Duplacate
                    var liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    liElem.setAttribute('ng-hide','desablecreateedit');
                    ulElem.appendChild(liElem);
                    var aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','dupliquerAction()');
                    aElem.appendChild(document.createTextNode("{{'Dupliquer' | translate}}")) ;
                    liElem.appendChild(aElem);
                    //Export
//                    var liElem = document.createElement('li');
//                    liElem.setAttribute('role','presentation');
//                    liElem.setAttribute('ng-hide','desableupdateedit');
//                    ulElem.appendChild(liElem);
//                   var aElem = document.createElement('a');
//                   aElem.setAttribute('role','menuitem');
//                   aElem.setAttribute('tabindex','-1');
//                   aElem.setAttribute('href','#');
//                   aElem.setAttribute('ng-click','installAction()');
//                   aElem.appendChild(document.createTextNode('{{exportbtnlabel | translate}}')) ;
//                   liElem.appendChild(aElem);
                    //Create
                    liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    liElem.setAttribute('ng-hide','desablecreateedit');
                    ulElem.appendChild(liElem);
                    var aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','addElementAction()');
                    aElem.appendChild(document.createTextNode("{{'Creer' | translate}}")) ;
                    liElem.appendChild(aElem);
                     //Bloc 3
                    liElem = document.createElement('li');
                    liElem.setAttribute('role','presentation');
                    liElem.setAttribute('ng-hide','desabledeleteedit');
                    ulElem.appendChild(liElem);
                    aElem = document.createElement('a');
                    aElem.setAttribute('role','menuitem');
                    aElem.setAttribute('tabindex','-1');
                    aElem.setAttribute('href','#');
                    aElem.setAttribute('ng-click','deleteAction()');
                    aElem.appendChild(document.createTextNode('{{deletebtnlabel | translate}}')) ;
                    liElem.appendChild(aElem);
                }//Ajout des actions de  
               if($scope.currentAction.actions && $scope.currentAction.actions.length>0){                  
                   for(var i=0 ; i<$scope.currentAction.actions.length;i++){
                        var act = $scope.currentAction.actions[i];
                        var liElem = document.createElement('li');
                        liElem.setAttribute('role','presentation');
//                        liElem.setAttribute('ng-hide','desableupdateedit');
                        ulElem.appendChild(liElem);
                        var aElem = document.createElement('a');
                        aElem.setAttribute('role','menuitem');
                        aElem.setAttribute('tabindex','-1');
                        aElem.setAttribute('href','#');
                        aElem.setAttribute('ng-click',"buttonAction("+act.value+" , '"+act.type+"',null,'"+index+"')");
                        aElem.appendChild(document.createTextNode(act.label)) ;
                        if(act.type!=='workflow'){
                            liElem.appendChild(aElem);
                        }else{
                            if(act.state  && $scope.currentObject && $scope.currentObject.state){
                                var states = act.state.split(';');
                                if(states.length>0 && $scope.currentObject.state 
                                        && commonsTools.containsLiteral(states,$scope.currentObject.state)){
                                    liElem.appendChild(aElem);
                                }//end if(commonsTools.containsLiteral(states,$scope.currentUser.state)){
                            }else{
                                liElem.appendChild(aElem);
                            }//end if(act.state){
                        }//end if(act.type!='workflow'){
                        //console.log("$scope.buildPrintActionsMenu ================ "+angular.toJson(act));
                
                   }//end for(var i=0 ; i<$scope.currentAction.actions.length;i++){
                   //console.log("========================  "+viewElem.innerHTML)
                   if(type=='javascript'){
                        var item = viewElem.getElementById('actions_menu');
                        if(item){
                            item.parentNode.replaceChild(item,ulElem);
                        }
                   }else if(type=='angular'){
                        var items = viewElem.find("ul");
                        for(var i=0; i<items.length;i++){
                             if(items.eq(i).attr("id")=="actions_menu"){
                                   items.eq(i).replaceWith(ulElem);
                             }//end if(items.eq(i).attr("id")=="actions_menu"){  
                        }//end for(var i=0; i<items.length;i++){
                   }//end if(type=='javascript'){
                   
               }//end if($scope.currentAction.actions && $scope.currentAction.actions.length>0)
               return viewElem;
          };
          /**
           * Hide the menu actions
           * @returns {undefined}
           */
          $scope.hideMenuActions = function(level){              
              var desabledit = !$scope.canCreate();
              var desableupdate = !$scope.canUpdate();
              var desabledelete = !$scope.canDelete();
              var statut =desabledelete&&desableupdate&&desabledit;
              var statut2 = $scope.desablecreateedit&&$scope.desableupdateedit&&$scope.desabledeleteedit;
              if(statut===true || statut2==true){
                  if(!$scope.currentAction.actions || $scope.currentAction.actions.length<=0){
                    return true ;
                  }else{
                      return false;
                  }//end if($scope.isviewOperation()==false){                  
              }else if($scope.isviewOperation()===false){
                  return true;
              }
              return false;
          };
          /**
           * 
           * @returns {undefined}
           */
          $scope.displayImportPanel = function(){
              var content = $scope.viewSelector("import");
              var listElem = angular.element(content);
              var compileFn = $compile(listElem);
              compileFn($scope);
              ///Remplacement dans la vue
              var items = $element.find("div");
              for(var i=0; i<items.length;i++){                 
                if(items.eq(i).attr("id")=="innerpanel"){
                      items.eq(i).replaceWith(listElem);
                }//end if(items.eq(i).attr("id")=="innerpanel"){  
              }//end for(var i=0; i<items.length;i++){   
              $timeout(function() {                
                $('.selectpicker').selectpicker('refresh');                
              });
          };
          /**
             Affichage du panel d'edition
          **/
          $scope.displayEditPanel = function(){
              if($scope.currentAction && angular.isString($scope.currentAction)){
                  $scope.currentAction = angular.fromJson($scope.currentAction);
              }//end if($scope.currentAction && angular.isString($scope.currentAction))
              //$scope.createsession()
//              console.log("principal.displayEditPanel  ======= session data : "+angular.toJson($scope.createsession()));
              var modes = ['tree','form'];
              if(angular.isDefined($scope.currentAction.viewMode)){
                  modes =$scope.currentAction.viewMode.split(",");
              }//end if(angular.isDefined($scope.currentAction.viewMode)){
              $scope.hideannuler = modes[0]==='form';
              $scope.enablefollowerpanel = false;
              $scope.desablecreateedit = ($scope.isviewOperation()||!$scope.canCreate()); //||!$scope.canUpdate();
              $scope.desableupdateedit = $scope.isupdateOperation()||!$scope.canUpdate()||$scope.iscreateOperation();
              $scope.desabledeleteedit = !$scope.canDelete()||$scope.iscreateOperation()||$scope.isupdateOperation()||($scope.showApplication==true&&$scope.currentObject.active==true);
              $scope.desableprintedit=$scope.iscreateOperation()||!$scope.canPrint()||$scope.isviewOperation()||$scope.isupdateOperation();
//              console.log("principal.scope.displayEditPanel = function() ========================== $scope.desablecreateedit : "+$scope.desablecreateedit+" === canCreate : "+$scope.canCreate()+" === canUpdate:"+$scope.canUpdate());              
              $scope.createsession();              
              $scope.innerWindowType = false;
              var listElem  = null ; 
              var content = $scope.viewSelector('detail') ;              
              listElem = angular.element(content);
             //Construction Header
             listElem = $scope.buildActionsMenu(listElem,'angular',0);  
             listElem = $scope.buildPrintActionsMenu(listElem);  
             $scope.observablePools = new Object();
             var viewElem = null;
             if($scope.currentAction.formView!=null
                      && $scope.currentAction.formView.template!=null){
                  viewElem = commonsTools.xmlViewParser($scope.currentAction.formView.template,$scope,'currentObject',$scope.metaData,null,0,'currentObject');
              }else{
                  viewElem = $scope.editPanelComponent('currentObject' , $scope.metaData,null,0,'currentObject');   
              }//end if(angular.isDefined($scope.currentAction.formView)
             var headerElem = $scope.editPanelHeader('currentObject' , $scope.metaData,0);       
             $scope.showpjmenu = false ;
             if($scope.metaData.activefilelink==true &&($scope.windowType=="update"||$scope.windowType=="view")){
                 $scope.showpjmenu = true ;
                 $scope.piecejointeMenu(listElem,$scope.currentObject,$scope.metaData);
             }//end if($scope.metaData.activefilelien==true &&($scope.windowType=="update"||$scope.windowType=="view"))
             if($scope.metaData.activatefollower==true && $scope.windowType!='new'){
                 var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/follower/entity/"+$scope.currentObject.serial+"/"+$scope.currentObject.id;
                 $http.get(url)
                         .then(function(response){
                             $scope.dataCache['follower'] = response.data;                             
                             if(!$scope.dataCache['follower']){
                                    var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/follower/meta";
                                    $http.get(url)
                                            .then(function(response){
                                                $scope.dataCache['follower'] = $scope.createFreeEmptyObject(response.data);
                                                //Ajout des champs de baseElement
                                                $scope.dataCache['follower'].id=-1;
                                                $scope.dataCache['follower'].compareid=-1;
                                                $scope.dataCache['follower'].designation="";
                                                $scope.dataCache['follower'].editTitle="";
                                                $scope.dataCache['follower'].listTitle="";
                                                $scope.dataCache['follower'].moduleName="kerencore";
                                                $scope.dataCache['follower'].selected=false;
                                                $scope.dataCache['follower'].createonfield=true;
                                                $scope.dataCache['follower'].desablecreate=false;
                                                $scope.dataCache['follower'].desabledelete=false;
                                                $scope.dataCache['follower'].serial=null;
                                                $scope.dataCache['follower'].activefilelien=false;
                                                $scope.dataCache['follower'].footerScript=null;
                                                $scope.dataCache['follower'].activatefollower=false;
                                                $scope.dataCache['follower'].entityid=$scope.currentObject.id;
                                                $scope.dataCache['follower'].entityserial= $scope.currentObject.serial; 
                                                $scope.dataCache['follower'].messages = new Array();
                                                $scope.dataCache['follower'].canaux = new Array();
                                                $scope.dataCache['follower'].abonnes = new Array();
                                                $scope.buildfollowermenu();
                                                $scope.buildFollowerMessagesView(listElem,$scope.dataCache['follower'].messages);
                                            },function(error){
                                                commonsTools.showMessageDialog(error);
                                            });     
                                }else{//end if(!$scope.dataCache['follower']){
                                    $scope.buildfollowermenu();
                                    $scope.buildFollowerMessagesView(listElem,$scope.dataCache['follower'].messages);
                                }//end if(!$scope.dataCache['follower'])
                             
                         },function(error){
                             commonsTools.showMessageDialog(error);
                         });                             
             }//end if($scope.metaData.activatefollower==true && $scope.windowType!='new')
              //             console.log("$scope.displayEditPanel = function() === "+$scope.showpjmenu+" ==== "+$scope.metaData.activefilelink);
             
             //Creation de l'entete du formultaire
             if(headerElem){
                    var items = listElem.find("div");
                    for(var i=0; i<items.length;i++){
                        if(items.eq(i).attr("id")=="workflow_menu_id"){
//                            console.log("$scope.displayEditPanel = function() === "+$scope.showpjmenu+" ==== "+$scope.metaData.activefilelink);
                              items.eq(i).replaceWith(headerElem);
                        }//end if(items.eq(i).attr("id")=="workflow_menu_id"){  
                    }//end for(var i=0; i<items.length;i++){
             }//end if(headerElem){
            var items = listElem.find("div");
            for(var i=0; i<items.length;i++){                 
                if(items.eq(i).attr("id")=="detail-panel-body"){
                      items.eq(i).replaceWith(viewElem);                      
                }//end if(items.eq(i).attr("id")=="detail-panel-body"){  
            }//end for(var i=0; i<items.length;i++){ 
            var compileFn = $compile(listElem);
            compileFn($scope);
            ///Remplacement dans la vue
            var items = $element.find("div");
            for(var i=0; i<items.length;i++){                 
                 if(items.eq(i).attr("id")=="innerpanel"){
                       items.eq(i).replaceWith(listElem);
                 }//end if(items.eq(i).attr("id")=="innerpanel"){  
            }//end for(var i=0; i<items.length;i++){   
             $timeout(function() {                
                $('.selectpicker').selectpicker('refresh'); 
                commonsTools.selectpickerKeyup($scope.metaData,'currentObject',$scope);
             });
             
             //Return 
             return listElem;
        };

          /**    
             Affichage du panel List
          **/
          $scope.displayListPanel = function(){
//              console.log("$scope.displayListPanel =========== "+$scope.windowType+" ====== "+$scope.previousType);
               $scope.enablefollowerpanel = false;               
               if($scope.previousType && $scope.previousType=="calendar"){
                   $scope.windowType = 'calendar';               
                   var viewElem =  $scope.calendarPanelComponent($scope.metaData); 
                   viewElem = $scope.buildPrintActionsMenu(viewElem);
               }else if($scope.previousType && $scope.previousType=="kaban"){
                   $scope.windowType = 'kaban';               
                   var viewElem =  $scope.kabanPanelComponent(); 
                    viewElem = $scope.buildActionsMenu(viewElem,'angular',0);  
                    viewElem = $scope.buildPrintActionsMenu(viewElem);
               }else{
                    $scope.windowType = 'list';               
                    var viewElem =  $scope.listPanelComponent($scope.metaData);  
                    //Construction Header
                    viewElem = $scope.buildActionsMenu(viewElem,'angular',0);  
                    viewElem = $scope.buildPrintActionsMenu(viewElem);
               }//end if($scope.previousType && $scope.previousType=="calendar")
               var compileFn = $compile(viewElem);
               compileFn($scope);
               var items = $element.find("div");
               for(var i=0; i<items.length;i++){                   
                   if(items.eq(i).attr("id")=="innerpanel"){
                         items.eq(i).replaceWith(viewElem);
                   }//end if(items.eq(i).attr("id")=="innerpanel"){  
               }//end for(var i=0; i<items.length;i++){     
               $scope.loadData();
              
          };

         
         /**
          * 
          * @param {type} model
          * @returns {$scope.dataCache|$scope.currentObject|@var;data}
          */
          $scope.getCurrentModel = function(model){
//                   console.log("$scope.getCurrentModel ========================= "+model);
                    var part = model.split(".");              
                    var data = $scope.currentObject;
                    if(part[0]=='dataCache'){
                        data = $scope.dataCache;
                    }else if(part[0]=='temporalData'){
                        data = $scope.temporalData;
                    }//end if(part[0]=='dataCache')
                    if(part.length <= 1){
                        return data;
                    }else{
                          var modelref =data;
                          for(var i=1 ; i<part.length;i++){                            
                              if(part[i].split("[").length==1){
//                                console.log("=====editDialogBuilder  ***************Youpi************ "+angular.isArray(model));
                                if(modelref[part[i]]){
                                    modelref = modelref[part[i]];
                                } //end if(model[part[i]])
                              }else {
                                  var parts = part[i].split("[");
                                  var prefix = parts[0];
                                  parts = parts[1].split("]");
                                  var sufix = parts[0];
                                  modelref = modelref[prefix];
                                  modelref = modelref[new Number(sufix)];
//                                  console.log("=====editDialogBuilder  ***************Youpi************ "+prefix+" ==== "+sufix+" ==== "+angular.toJson(model));
                              }//end if(part[i].split("[").length==1)
                         }//end for(var i=1 ; i<part.length;i++)
//                            console.log("$scope.getCurrentModel ========================= "+angular.toJson(model));
                           return modelref;    
                    }//end if(part.length==1){
          };     
          
          /**
           * 
           * @param {type} model
           * @returns {@var;data|$scope.temporalData|$scope.dataCache|$scope.currentObject}
           */
           $scope.getParentModel = function(model){
//                   console.log("$scope.getCurrentModel ========================= "+model);
                    var part = model.split(".");              
                    var data = $scope.currentObject;
                    if(part[0]=='dataCache'){
                        data = $scope.dataCache;
                    }else if(part[0]=='temporalData'){
                        data = $scope.temporalData;
                    }//end if(part[0]=='dataCache')
                    if(part.length==1){
                        return data;
                    }else{
                          var model =data;
                          for(var i=1 ; i<part.length-1;i++){                            
                              if(part[i].split("[").length==1){
//                                console.log("=====editDialogBuilder  ***************Youpi************ "+angular.isArray(model));
                                if(model[part[i]]){
                                    model = model[part[i]];
                                } //end if(model[part[i]])
                              }else {
                                  var parts = part[i].split("[");
                                  var prefix = parts[0];
                                  parts = parts[1].split("]");
                                  var sufix = parts[0];
                                  model = model[prefix];
                                  model = model[new Number(sufix)];
//                                  console.log("=====editDialogBuilder  ***************Youpi************ "+prefix+" ==== "+sufix+" ==== "+angular.toJson(model));
                              }//end if(part[i].split("[").length==1)
                            }//end for(var i=1 ; i<part.length;i++)
//                            console.log("$scope.getCurrentModel ========================= "+angular.toJson(model));
                           return model;    
                    }//end if(part.length==1){
          };     
           
        /**
         * 
         * @param {type} model
         * @returns {principal_L379.principalAnonym$25.controller.$scope.metaData}
         */
          $scope.getCurrentMetaData = function(model){
                if(angular.isString(model)){                

                      var part = model.split(".");              
                     var metaData = $scope.metaData;
                     if(part[0]=='temporalData'){
                        metaData = $scope.temporalMetaData;
                     }//end if(part[0]=='temporalData')
//                     console.log("$scope.getCurrentMetaData = ========================= "+model+" ============== ");
                     if(part.length==1){
                         return metaData;
                     }else{
                         for(var k=1;k<part.length;k++){
                                var blocks = part[k].split('[');
                                var fieldname = part[k];
                                if(blocks.length>1){
                                    fieldname = blocks[0];
                                }//end if(blocks.length>1){
                                for(var i=0 ; i<metaData.columns.length ;i++){
                                    if(fieldname==metaData.columns[i].fieldName){
     //                                    console.log("!!!!!!!"+part[1]+"=====editDialogBuilder  ===== "+metaData.columns[i].fieldName+" ******* "+angular.toJson(metaData.columns[i].metaData));                               
                                         metaData = metaData.columns[i].metaData;
                                    }//end if(part[1]==$scope.metaData.columns[i].fieldName){

                                }//end for(var i=0 ; i<$scope.metaData.columns.length ;i++){

                               //Recherches dans les groups
                               if(metaData.groups){
                                  for(var i=0 ; i<metaData.groups.length;i++){
                                      if(metaData.groups[i]){
//                                          console.log("!!!!!!!====editDialogBuilder  ===== "+metaData.groups[i].groupName+" ******* "+metaData.groups[i].columns.length);
                                           var groupe = metaData.groups[i];
                                           if(metaData.groups[i].columns){
                                                var taille = metaData.groups[i].columns.length;
                                                var columns = metaData.groups[i].columns;
                                                for(var j=0 ; j < taille ;j++){
                                                     if(columns && (fieldname== columns[j].fieldName)){
                                                           metaData = columns[j].metaData;
                                                      }//end if(columns && (part[k]== columns[j].fieldName)){
                                                }//end for(var j=0 ; j < taille ;j++){
                                            }//end if(metaData.groups[i].columns)
                                          //Cas des metaArray
                                            if(groupe.metaArray){//&&groupe.metaArray.length>0
                                                for(var l=0;l<groupe.metaArray.length;l++){
                                                    if(groupe.metaArray[l].fieldName==fieldname){
                                                        metaData = groupe.metaArray[l].metaData;
                                                    }//end if(groupe.metaArray[l].fieldName==part[k])
                                                }//end for(var l=0;l<groupe.metaArray.length;l++){
                                            }//end if(groupe.metaArray&&groupe.metaArray.length>0){
                                      }
                                      
                                  }
                               }//end if(metaData.groups){
                           }//end for(var i=1;i<part.length;i++){
                           return metaData;
                     }
                }else{
                    return metaData;
                }           
          };

/**
 * 
 * @param {type} model
 * @returns {groupe.metaArray.metaData|$scope.metaData|$scope.temporalMetaData}
 */
           $scope.getParentMetaData = function(model){
                if(angular.isString(model)){                

                      var part = model.split(".");              
                     var metaData = $scope.metaData;
                     if(part[0]=='temporalData'){
                        metaData = $scope.temporalMetaData;
                     }//end if(part[0]=='temporalData')
//                     console.log("$scope.getCurrentMetaData = ========================= "+model+" ============== "+angular.toJson(metaData));
                
                     if(part.length==1){
                         return metaData;
                     }else{
                         for(var k=1;k<part.length-1;k++){
                                var blocks = part[k].split('[');
                                var fieldname = part[k];
                                if(blocks.length>0){
                                    fieldname = blocks[0]; 
                                }//end if(blocks.length>0){
                                for(var i=0 ; i<metaData.columns.length ;i++){
                                    if(fieldname==metaData.columns[i].fieldName){
     //                                    console.log("!!!!!!!"+part[1]+"=====editDialogBuilder  ===== "+metaData.columns[i].fieldName+" ******* "+angular.toJson(metaData.columns[i].metaData));                               
                                         metaData = metaData.columns[i].metaData;
                                    }//end if(part[1]==$scope.metaData.columns[i].fieldName){

                                }//end for(var i=0 ; i<$scope.metaData.columns.length ;i++){

                               //Recherches dans les groups
                               if(metaData.groups){
                                  for(var i=0 ; i<metaData.groups.length;i++){
                                      if(metaData.groups[i]){
//                                          console.log("!!!!!!!====editDialogBuilder  ===== "+metaData.groups[i].groupName+" ******* "+metaData.groups[i].columns.length);
                                           var groupe = metaData.groups[i];
                                           if(metaData.groups[i].columns){
                                                var taille = metaData.groups[i].columns.length;
                                                var columns = metaData.groups[i].columns;
                                                for(var j=0 ; j < taille ;j++){
                                                     if(columns && (fieldname== columns[j].fieldName)){
                                                           metaData = columns[j].metaData;
                                                      }
                                                }//end for(var j=0 ; j < taille ;j++){
                                            }//end if(metaData.groups[i].columns)
                                          //Cas des metaArray
                                            if(groupe.metaArray&&groupe.metaArray.length>0){//&&
                                                for(var l=0;l<groupe.metaArray.length;l++){
                                                    if(groupe.metaArray[l].fieldName==fieldname){
                                                        metaData = groupe.metaArray[l].metaData;
                                                    }//end if(groupe.metaArray[l].fieldName==part[k])
                                                }//end for(var l=0;l<groupe.metaArray.length;l++){
                                            }//end if(groupe.metaArray&&groupe.metaArray.length>0){
                                      }
                                      
                                  }
                               }//end if(metaData.groups){
                           }//end for(var i=1;i<part.length;i++){
                           return metaData;
                     }
                }else{
                    return metaData;
                }           
          };

        /**
         * 
         * @param {type} model
         * @param {type} item
         * @param {type} type
         * @param {type} entityName
         * @param {type} moduleName
         * @param {type} index
         * @returns {undefined}
         */
        $scope.editDialogBuilder = function(model , item , type ,entityName , moduleName,index,modelpath){           
          //Traitement du currentObject     
             //Affeectation du model dans l'object temporaire  
//             console.log("$scope.editDialogBuilder ================ "+model+" == "+item+" == "+item+" === "+type+" === "+entityName+" ==== "+moduleName+" === "+index+" === "+modelpath);
             var key = commonsTools.keygenerator(modelpath);           
             if(angular.isString(model)){
               $scope.temporalModel = $scope.getCurrentModel(modelpath);       
               $scope.dataCache[key+"model"] = $scope.temporalModel;
             }else{
                 $scope.temporalModel = model ;
                 $scope.dataCache[key+"model"] = model;
             }//end if(angular.isString(model)){             
             var edittitle = 'Nouveau';
             $scope.innerWindowType = 'new';
             if(item){
                  edittitle = item.designation;
                  $scope.innerWindowType = 'update';
             }
             var metaData = $scope.getCurrentMetaData(modelpath) ;
           if(!metaData){
              var exprFn = $parse($scope.currentMetaDataPath);     
              metaData = exprFn($scope); 
           }//end if(!metaData){
           $scope.temporalMetaData = metaData;
//            $scope.temporalData = {};  
            $scope.dataCache[""+key] = $scope.createFreeEmptyObject(metaData);
//            console.log("$scope.editDialogBuilder =============== "+index+" == "+model+" === "+key+" === "+angular.toJson($scope.dataCache[""+key+"model"])+" === ");
            if(item){
//                angular.extend($scope.temporalData,item);
                 angular.extend($scope.dataCache[""+key],item);
                $scope.temporalDatas.push(item);                
             }           
           //angular.extend($scope.temporalData,$scope.selectedObjects[0]);              
           //console.log("editDialogBuilder ==== "+metaData.entityName);
           var viewElem =  document.createElement('div'); //;
           var bodyID = '';
           var endIndex = index;
           if(endIndex==1){
               bodyID = 'modalbody';
               viewElem.setAttribute('id' , 'modalbody');
           }else if(endIndex==2){
               viewElem.setAttribute('id' , 'gmodalbody');
               bodyID = 'gmodalbody';
           }else if(endIndex==3){
               viewElem.setAttribute('id' , 'modalbody1');
               bodyID = 'modalbody1';
           }else if(endIndex==4){
               viewElem.setAttribute('id' , 'modalbod2');
               bodyID = 'modalbody2';
           } //end if(index==1)
              
//           viewElem.setAttribute("style","heigth:70%;");
          var headerElem = $scope.editPanelHeader("dataCache."+key , metaData,index);  
          var editPanel =  $scope.editPanelComponent("dataCache."+key ,metaData,'new',index,modelpath);
//            console.log("editDialogBuilder  =====  ************* Vous avez cliquez :::: "+model+" ***** "+editPanel+" ==== "+type+" ::: "+entityName+" ::: "+moduleName+" == "+angular.toJson(metaData));
           if(headerElem){
               viewElem.appendChild(headerElem);
           }//end if(headerElem)
           viewElem.appendChild(editPanel);
           //Construction du footer
           var footerDiv = document.createElement('div');
           footerDiv.setAttribute('class' , 'modal-footer');
//           footerDiv.setAttribute('id' , 'modalfooter');
           var footerID = '';
           if(index==1){
               footerID = 'modalfooter';
              footerDiv.setAttribute('id' , 'modalfooter');
           }else if(index==2){
               footerDiv.setAttribute('id' , 'gmodalfooter');
               footerID = 'gmodalfooter';
           }else if(index==3){
               footerDiv.setAttribute('id' , 'modalfooter1');
               footerID = 'modalfooter1';
           }else if(index==4){
               footerDiv.setAttribute('id' , 'modalfooter2');
               footerID = 'modalfooter2';
           } //end if(index==1)
           if($scope.metaData.desableupdate==true||$scope.windowType!="view"){
                var buttonElem = document.createElement('button');
                footerDiv.appendChild(buttonElem);
                buttonElem.setAttribute('class' , 'btn btn-primary');
                buttonElem.setAttribute('ng-click' , "addDialogAction('"+model+"' , '"+type+"','"+entityName+"' , '"+moduleName+"',null,"+(index+1)+",'"+modelpath+"')");
                buttonElem.appendChild(document.createTextNode("{{'Valider' | translate}}"));
            }//end if($scope.windowType!="view"){
           //Button annuler
           buttonElem = document.createElement('button');
           footerDiv.appendChild(buttonElem);
           buttonElem.setAttribute('class' , 'btn btn-default');
           buttonElem.setAttribute('data-dismiss' , "modal");
           buttonElem.setAttribute('type' , 'button');
           buttonElem.setAttribute('ng-click' , "annulerAction2('"+model+"')");
           buttonElem.appendChild(document.createTextNode("{{'Annuler' | translate}}"));
           //Entete modal
           var titleheader = document.createElement('h4');
           var titleID = '';
//           titleheader.setAttribute('class','modal-title');           
           if(index==1){
               titleID='modaltitle';
              titleheader.setAttribute('id','modaltitle');
           }else if(index==2){
               titleheader.setAttribute('id','gmodaltitle');
               titleID = 'gmodaltitle';
           }else if(index==3){
               titleheader.setAttribute('id','modaltitle1');
               titleID = 'modaltitle1';
           }else if(index==4){
               titleheader.setAttribute('id','modaltitle2');
               titleID = 'modaltitle2';
           } //end if(index==1)
           titleheader.appendChild(document.createTextNode(metaData.editTitle+" / "+edittitle));
            //console.log(viewElem.innerHTML);
           var compileFn = $compile(viewElem);
           compileFn($scope);
           // $('.selectpicker').selectpicker('refresh');
           var compileFoot = $compile(footerDiv);
           compileFoot($scope);
           var items = $(document).find("div");
           for(var i=0; i<items.length;i++){               
               if(items.eq(i).attr("id")==bodyID){
                     items.eq(i).replaceWith(viewElem);
                      //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentMetaDataPath);
          
               } else if(items.eq(i).attr("id")==footerID){
                   items.eq(i).replaceWith(footerDiv);
               } 
           }            
           items = $(document).find("h4");
           for(var i=0; i<items.length;i++){               
               if(items.eq(i).attr("id")==titleID){
                     items.eq(i).replaceWith(titleheader);
                      //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentMetaDataPath);          
               }//end if(items.eq(i).attr("id")==titleID){ 
           }//end for(var i=0; i<items.length;i++)            
            $timeout(function() {                
              $('.selectpicker').selectpicker('refresh');
              commonsTools.selectpickerKeyup(metaData,modelpath,$scope);
            });
        };
        
          /**
          * 
          * @param {type} model
          * @param {type} fieldname
          * @returns {undefined}
          */
          $scope.manyToManyListSorter = function(entityName , fieldname){
//            console.log("$scope.tableSorter = function(model , fieldname) ============ model : "+model+" ========= champs : "+fieldname);
             var datas = $scope.dataCache;
             if($scope.currentSort.column==fieldname){
                 $scope.currentSort.reverse = !$scope.currentSort.reverse;
             }else{
                 $scope.currentSort.column = fieldname;
                 $scope.currentSort.reverse = false;
             }//end if($scope.currentSort.column==fieldname)
//             console.log("$scope.listeSorter = function(fieldname)============= column : "+$scope.currentSort.column+"  reverse : "+$scope.currentSort.reverse);
             datas[entityName] = $filter('orderBy')(datas[entityName],fieldname,$scope.currentSort.reverse);
//             if($scope.currentSort.reverse==true){
//                  datas[part[part.length-1]] = $filter('orderBy')( datas[part[part.length-1]],"-"+fieldname,false);
//             }else {
//                    datas[part[part.length-1]] = $filter('orderBy')( datas[part[part.length-1]],fieldname,false);
//             }//end if($scope.currentSort.reverse==true)
        };
        /**
         * 
         * @param {type} entityName
         * @returns {undefined}
         */
        $scope.onCheckboxListClick = function(entityName,value){
            //Verifier que 
            var datas = $scope.dataCache[entityName];
            if(!$scope.dataCache.selectedObjects){
                $scope.dataCache.selectedObjects = new Array();
            }//end if(!$scope.dataCache.selectedObjects){
//            console.log("$scope.onCheckboxListClick = function(entityName,value){ ==== "+angular.toJson(datas));
            if(angular.isDefined(datas) && datas.length>0){
                for(var i=0 ; i<datas.length;i++){
                    var item = datas[i];
                    item.selected = !value;
                    if(item.selected){
                        if(!commonsTools.contains($scope.dataCache.selectedObjects , item)){
                             //console.log("$scope.onRowCheckboxClickDialog = ============== "+item);
                             $scope.dataCache.selectedObjects.unshift(item);
                        }//end if(!$scope.containsObject($scope.dataCache.selectedObjects , item)){
                    }else{
                      //console.log("$scope.onRowCheckboxClickDialog $scope.containsObject($scope.dataCache.selectedObjects , item) = ============== "+item);
                      $scope.removeFromArray($scope.dataCache.selectedObjects , item);                
                    }//end if(item.selected){       
                }//end for(var i=0 ; i<datas.length;i++){
            }//end if(angular.isDefined(datas) && datas.length>0){
        };
       /**
        * 
        * @param {type} metaData
        * @param {type} index
        * @returns {unresolved}
        */
          $scope.listPanelDialogComponent = function(metaData,index){
             //console.log("$scope.listPanelDialogComponent = "+fieldName)
//             $scope.innerWindowType = true;
              $scope.dataCache.selectedObjects = new Array();
             var tableElem = document.createElement('table');
             tableElem.setAttribute('class' , 'table table-sm table-striped table-hover table-responsive ');
             //tableElem.setAttribute('style' , 'margin-top: -10px;');
             //tableElem.setAttribute('id' , 'table');
             //Creation du table header
             var theadElem = document.createElement('thead');
             tableElem.appendChild(theadElem);
             //Creation entete
             var  rheadElem = document.createElement('tr');
             rheadElem.setAttribute('class' ,'table-header');
             theadElem.appendChild(rheadElem); 
             var thElem0 = document.createElement('th');
             var inputElem0 = document.createElement('input');
             inputElem0.setAttribute('type' , 'checkbox');
             inputElem0.setAttribute('ng-model' , 'tableheaderselected');
             inputElem0.setAttribute('ng-click' , "onCheckboxListClick('"+metaData.entityName+"' ,tableheaderselected)");
            thElem0.appendChild(inputElem0);
            rheadElem.appendChild(thElem0);
            //Traitement des champs columns
            if(metaData.columns){
                for(var i=0 ; i< metaData.columns.length;i++){
                  if(angular.isDefined(metaData.columns[i].search)
                            &&(metaData.columns[i].search==true)){
                      if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'&&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'){  
                            var thElem = document.createElement('th');
                            thElem.setAttribute('ng-click' , "manyToManyListSorter('"+metaData.entityName+"','"+metaData.columns[i].fieldName+"')");
                            thElem.innerHTML = metaData.columns[i].fieldLabel+" <span ng-show=down('"+metaData.columns[i].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.columns[i].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                            rheadElem.appendChild(thElem);
                       }//end if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'
                  }//end if(angular.isDefined(metaData.columns[i].search)
                }//end for(var i=0 ; i< metaData.columns.length;i++){
            }//end if(metaData.columns){
            //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){
                                 if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image'
                                         &&metaData.groups[i].columns[j].type.type!='textarea'&&metaData.groups[i].columns[j].type.type!='richeditor'){   
                                    var thElem = document.createElement('th');
                                    thElem.setAttribute('ng-click' , "manyToManyListSorter('"+metaData.entityName+"','"+metaData.groups[i].columns[j].fieldName+"')");
                                    thElem.innerHTML = metaData.groups[i].columns[j].fieldLabel+" <span ng-show=down('"+metaData.groups[i].columns[j].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.groups[i].columns[j].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                                    rheadElem.appendChild(thElem);
                                }//end if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i]
                            }//end if(angular.isDefined(metaData.groups[i].columns[j].search)
                        }//end For
                    }//Fin traitement des colommes
                }//end for(var i=0 ; i<metaData.groups.length;i++)
            }//end if(metaData.groups){

            //Creation du corps du tableau
            var tbodyElem = document.createElement('tbody');
            tableElem.appendChild(tbodyElem);
            var rbodyElem = document.createElement('tr');
            rbodyElem.setAttribute('ng-repeat' , "obj in dataCache."+metaData.entityName);
            tbodyElem.appendChild(rbodyElem);
            var tdElem = document.createElement('td');
            rbodyElem.appendChild(tdElem);
            rbodyElem.setAttribute('style' , "cursor: pointer;");
            inputElem0 = document.createElement('input');
            inputElem0.setAttribute('type' , 'checkbox');
            inputElem0.setAttribute('ng-model' , 'obj.selected');
            inputElem0.setAttribute('ng-click' , "onRowCheckboxClickDialog(obj)");
            tdElem.appendChild(inputElem0);
            if(metaData.columns){ 
                for(var i=0 ; i< metaData.columns.length;i++){
                     if(angular.isDefined(metaData.columns[i].search)
                           &&(metaData.columns[i].search==true)){
                         if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'&&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'){  
                           var thElem = document.createElement('td');
                           //thElem.setAttribute('ng-click' , "viewAction(obj)");
                           if(metaData.columns[i].type=='object'){
                             thElem.innerHTML = "{{obj."+metaData.columns[i].fieldName+".designation}}";
                           }else{
                             thElem.innerHTML = "{{obj."+metaData.columns[i].fieldName+"}}";
                           }
                           rbodyElem.appendChild(thElem);
                        }
                     }
                }
            }
             //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){
                                  if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image'
                                          &&metaData.groups[i].columns[j].type!='textarea'&&metaData.groups[i].columns[j].type!='richeditor'){   
                                    var thElem = document.createElement('td');
                                    //thElem.setAttribute('ng-click' , "viewAction(obj)");
                                    if(metaData.groups[i].columns[j].type=='object'){
                                      thElem.innerHTML = "{{obj."+metaData.groups[i].columns[j].fieldName+".designation}}";
                                    }else{
                                      thElem.innerHTML = "{{obj."+metaData.groups[i].columns[j].fieldName+"}}";
                                    }
                                    rbodyElem.appendChild(thElem);
                                }
                            }
                        }//end For
                    }//Fin traitement des colommes
                }
            }           
            return tableElem;
         };

         $scope.listPanelDialogComponentExter = function(metaData){
             //console.log("$scope.listPanelDialogComponent = "+fieldName)
//             $scope.innerWindowType = true;
              $scope.dataCache.selectedObjects = new Array();
             var tableElem = document.createElement('table');
             tableElem.setAttribute('class' , 'table table-sm table-striped table-hover table-responsive ');
             //tableElem.setAttribute('style' , 'margin-top: -10px;');
             //tableElem.setAttribute('id' , 'table');
             //Creation du table header
             var theadElem = document.createElement('thead');
             tableElem.appendChild(theadElem);
             //Creation entete
             var  rheadElem = document.createElement('tr');
             rheadElem.setAttribute('class' ,'table-header');
             theadElem.appendChild(rheadElem);             
            //Traitement des champs columns
            if(metaData.columns){
                for(var i=0 ; i< metaData.columns.length;i++){
                  if(angular.isDefined(metaData.columns[i].search)
                            &&(metaData.columns[i].search==true)){
                      if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'&&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'){  
                        var thElem = document.createElement('th');
                        thElem.innerHTML = metaData.columns[i].fieldLabel;
                        rheadElem.appendChild(thElem);
                       }
                     }
                }
            }
            //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){
                                 if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image'
                                         &&metaData.groups[i].columns[j].type.type!='textarea'&&metaData.groups[i].columns[j].type.type!='richeditor'){   
                                    var thElem = document.createElement('th');
                                    thElem.innerHTML = metaData.groups[i].columns[j].fieldLabel;
                                    rheadElem.appendChild(thElem);
                                }
                            }
                        }//end For
                    }//Fin traitement des colommes
                }
            }

            //Creation du corps du tableau
            var tbodyElem = document.createElement('tbody');
            tableElem.appendChild(tbodyElem);
            var rbodyElem = document.createElement('tr');
            rbodyElem.setAttribute('ng-repeat' , "obj in temporalDatas");
            tbodyElem.appendChild(rbodyElem);
            var tdElem = document.createElement('td');
//            rbodyElem.appendChild(tdElem);
            rbodyElem.setAttribute('style' , "cursor: pointer;");            
            if(metaData.columns){ 
                for(var i=0 ; i< metaData.columns.length;i++){
                     if(angular.isDefined(metaData.columns[i].search)
                           &&(metaData.columns[i].search==true)){
                         if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'&&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'){  
                           var thElem = document.createElement('td');
                           //thElem.setAttribute('ng-click' , "viewAction(obj)");
                           if(metaData.columns[i].type=='object'){
                             thElem.innerHTML = "{{obj."+metaData.columns[i].fieldName+".designation}}";
                           }else{
                             thElem.innerHTML = "{{obj."+metaData.columns[i].fieldName+"}}";
                           }
                           rbodyElem.appendChild(thElem);
                        }
                     }
                }
            }
             //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){
                                  if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image'
                                          &&metaData.groups[i].columns[j].type!='textarea'&&metaData.groups[i].columns[j].type!='richeditor'){   
                                    var thElem = document.createElement('td');
                                    //thElem.setAttribute('ng-click' , "viewAction(obj)");
                                    if(metaData.groups[i].columns[j].type=='object'){
                                      thElem.innerHTML = "{{obj."+metaData.groups[i].columns[j].fieldName+".designation}}";
                                    }else{
                                      thElem.innerHTML = "{{obj."+metaData.groups[i].columns[j].fieldName+"}}";
                                    }
                                    rbodyElem.appendChild(thElem);
                                }
                            }
                        }//end For
                    }//Fin traitement des colommes
                }
            }           
            return tableElem;
         };
        /**
         * 
         * @param {type} model
         * @param {type} index
         * @returns {undefined}
         */
        $scope.listDialogBuilder = function(model,index,modelpath){
//            $scope.innerWindowType = true;
             $scope.temporalSearchCriteria = new String();
              $scope.temporalPredicats = new Array();
            //var parts = model.split(".");  
             var status = $scope.buildFilter(model);
            if(status==false){
                return ;
            }//end if(status==false){            
            var metaData = $scope.getCurrentMetaData(modelpath);     
            if(!metaData){
                return ;
            }//end if(!metaData)
//            console.log("$scope.listDialogBuilder ===== "+index+" ===== "+model+" ==== "+modelpath+" === "+angular.toJson(metaData));     
           //Chargement des donnÃ¯Â¿Â½es
           $scope.temporalPagination.beginIndex=0;
           $scope.temporalPagination.currentPage=0;
           $scope.temporalPagination.module = metaData.moduleName;
           $scope.temporalPagination.model = metaData.entityName;
           var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(metaData.moduleName)+"/"+angular.lowercase(metaData.entityName)+"/count";
           $http.get(url)
                   .then(function(response){
//                           console.log("$scope.listDialogBuilder = function(model) :::::: "+angular.toJson(response.data)+" === "+angular.isNumber(angular.fromJson(angular.toJson(response.data))));
                           var itemscount = response.data.value;
                           if(itemscount>0){
                               $scope.temporalPagination.currentPage=1;
                           }//end if(itemscount>0){
                           $scope.temporalPagination.totalPages = response.data.value;
                           $scope.temporalPagination.endIndex = $scope.temporalPagination.pageSize;
                           if(itemscount<$scope.temporalPagination.pageSize){
                               $scope.temporalPagination.endIndex = itemscount;
                           }//end if(itemscount<$scope.temporalPagination.pageSize){
                           $scope.getData2("dataCache."+metaData.entityName,metaData.entityName,metaData.moduleName);
                        //Traitement du currentObject       
                           //Affeectation du model dans l'object temporaire              
                         var viewElem =  document.createElement('div'); //;  
                         var bodyID = "unkown";
                         var endIndex = index;
                         if(endIndex==1){
                             bodyID = "modalbody";
                         }else if(endIndex==2){
                             bodyID = "gmodalbody";
                         }else if(endIndex==3){
                             bodyID = "modalbody1";
                         }else if(endIndex==4){
                             bodyID = "modalbody2";
                         }//end if(endIndex==1){
                         viewElem.setAttribute('id' , bodyID);
                         var searchElem = document.createElement("div");
//                         searchElem.innerHTML = "<nav id='listebar' class='navbar navbar-default container-heading-panel'  role='navigation'> <div class='col-sm-12  col-md-12  nav nav-justified navbar-nav container-heading-panel'> <div class='navbar-header col-sm-12 col-md-12  container-heading-panel'> </div> <div class='col-sm-12 col-md-12  container-heading-panel'> <form class='navbar-form navbar-search  navbar-right' role='Search' id='listfiltercontainer' style='width: 100%;' > <div class='input-group' style='width: 100%;'><span class='input-group-btn pull-left'  style='display: inline-block;width: 20%;'> <button type='button' class='btn btn-search btn-sm btn-default dropdown-toggle' data-toggle='dropdown' id='filtermtmtbtn' style='width: 100%;'> <span class='glyphicon glyphicon-filter'></span> <span class='label-icon'>Filtres</span> <span class='caret'></span> </button> <ul class='dropdown-menu' role='menu'  id='filterMtmActionsId'> <li> <a href='#'> <!-- <span class='glyphicon glyphicon-user'></span> <span class='label-icon'>Search By User</span> --> <span> <input type='text' style='border: none;'> <input type='checkbox' name='name' ng-model='checkbox01'> </span> </a> </li> <li> <a href='#'> <span class='glyphicon glyphicon-book'></span> <span class='label-icon'>Search By Organization</span> </a> </li> </ul> </span> <span class='input-group-btn  pull-left' style='display: inline-block;width: 80%;'> <input type='text' ng-model='temporalSearchCriteria' class='form-control input-sm' style='width: 97%;'> <button type='button' class='btn btn-search btn-sm btn-default'  ng-click=listsearchAction('"+model+"')> <span class='glyphicon glyphicon-search'></span> </button> </span>  </div>  </form> </div>  <span class='pull-right'> <div class='btn-group'  role='group'  aria-label='group 3'> <span class='btn btn-default btn-sm'>{{temporalPagination.currentPage}}-{{temporalPagination.endIndex}} / {{temporalPagination.totalPages}} </span> <button type='button'  class='btn btn-default btn-sm' ng-click='temporalPagination.previous_2()'  ng-disabled='!temporalPagination.hasprevious()'> <span class='glyphicon glyphicon-chevron-left'  aria-hidden='true'></span> </button> <button type='button'  class='btn btn-default btn-sm' ng-click='temporalPagination.next_2()' ng-disabled='!temporalPagination.hasnext()'> <span class='glyphicon glyphicon-chevron-right'  aria-hidden='true'></span> </button> </div> </span> </div> </div> </nav>";
                         searchElem.innerHTML = "<nav id='listebar' class='navbar navbar-default container-heading-panel'  role='navigation'> <div class='col-sm-12  col-md-12  nav nav-justified navbar-nav container-heading-panel'> <div class='navbar-header col-sm-12 col-md-12  container-heading-panel'> </div> <div class='col-sm-12 col-md-12  container-heading-panel'> <form class='navbar-form navbar-search  navbar-right' role='Search' id='listfiltercontainer' style='width: 100%;' > <div class='input-group' style='width: 100%;'><span class='input-group-btn pull-left'  style='display: inline-block;width: 20%;'> <button ng-hide='true' type='button' class='btn btn-search btn-sm btn-default dropdown-toggle' data-toggle='dropdown' id='filtermtmtbtn' style='width: 100%;'> <span class='glyphicon glyphicon-filter'></span> <span class='label-icon'>Filtres</span> <span class='caret'></span> </button> <ul class='dropdown-menu' role='menu'  id='filterMtmActionsId'> <li> <a href='#'> <!-- <span class='glyphicon glyphicon-user'></span> <span class='label-icon'>Search By User</span> --> <span> <input type='text' style='border: none;'> <input type='checkbox' name='name' ng-model='checkbox01'> </span> </a> </li> <li> <a href='#'> <span class='glyphicon glyphicon-book'></span> <span class='label-icon'>Search By Organization</span> </a> </li> </ul> </span> <span class='input-group-btn  pull-left' style='display: inline-block;width: 80%;'> <input type='text' ng-model='temporalSearchCriteria' ng-keyup=listsearchAction('"+model+"') class='form-control input-sm' style='width: 97%;'> <button type='button' class='btn btn-search btn-sm btn-default'  ng-click=listsearchAction('"+model+"')> <span class='glyphicon glyphicon-search'></span> </button> </span>  </div>  </form> </div>  <span class='pull-right'> <div class='btn-group'  role='group'  aria-label='group 3'> <span class='btn btn-default btn-sm'>{{temporalPagination.currentPage}}-{{temporalPagination.endIndex}} / {{temporalPagination.totalPages}} </span> <button type='button'  class='btn btn-default btn-sm' ng-click='temporalPagination.previous_2()'  ng-disabled='!temporalPagination.hasprevious()'> <span class='glyphicon glyphicon-chevron-left'  aria-hidden='true'></span> </button> <button type='button'  class='btn btn-default btn-sm' ng-click='temporalPagination.next_2()' ng-disabled='!temporalPagination.hasnext()'> <span class='glyphicon glyphicon-chevron-right'  aria-hidden='true'></span> </button> </div> </span> </div> </div> </nav>";
                         viewElem.appendChild(searchElem);
                         //Construction de la partie recherche
                         var editPanel =  $scope.listPanelDialogComponent(metaData,index);
                         var bodyElem = document.createElement('div');
                         bodyElem.setAttribute('style','overflow: auto;margin-top: -20px;height:400px;');
                         bodyElem.appendChild(editPanel);
                         viewElem.appendChild(bodyElem);  
                         var filter = $scope.filterOptionsComponent(metaData,"filterMtmActionsId");                         
                         //Insertion de la zone de filter
                         var items = angular.element(searchElem).find('ul');
                         for(var i=0; i<items.length;i++){               
                             if(items.eq(i).attr("id")=="filterMtmActionsId"){
                                   items.eq(i).replaceWith(filter);                                  
                             } //end if(items.eq(i).attr("id")=="filterMtmActionsId"){
                         }//end for(var i=0; i<items.length;i++){      
                         
                         //Construction du footer
                         var footerDiv = document.createElement('div');
                         footerDiv.setAttribute('class' , 'modal-footer');
                         var footerID ="";
                         if(endIndex==1){
                             footerID = "modalfooter";
                         }else if(endIndex==2){
                             footerID = "gmodalfooter";
                         }else if(endIndex==3){
                             footerID = "modalfooter1";
                         }else if(endIndex==4){
                             footerID = "modalfooter2";
                         }//end if(endIndex==1)
                         footerDiv.setAttribute('id' , footerID);
                         var buttonElem = document.createElement('button');
                         footerDiv.appendChild(buttonElem);
                         buttonElem.setAttribute('class' , 'btn btn-primary');
                         buttonElem.setAttribute('ng-click' , "addDialogAction('"+model+"' , 'list','"+metaData.entityName+"' , '"+metaData.moduleName+"',null,"+(index+1)+",'"+modelpath+"')");
                         buttonElem.appendChild(document.createTextNode("{{'Valider' | translate}}"));
                         //Button annuler
                         buttonElem = document.createElement('button');
                         footerDiv.appendChild(buttonElem);
                         buttonElem.setAttribute('class' , 'btn btn-default');
                         buttonElem.setAttribute('data-dismiss' , "modal");
                         buttonElem.setAttribute('type' , 'button');
                         buttonElem.appendChild(document.createTextNode("{{'Annuler' | translate}}"));
                         //Entete modal
                         var titleheader = document.createElement('h4');
                         titleheader.setAttribute('class','modal-title');
                         var titleID ="";
                         if(endIndex==1){
                             titleID = "modaltitle";
                         }else if(endIndex==2){
                             titleID = "gmodaltitle";
                         }else if(endIndex==3){
                             titleID = "modaltitle1";
                         }else if(endIndex==4){
                             titleID = "modaltitle2";
                         }//end if(endIndex==1){
                         titleheader.setAttribute('id',titleID);
                         titleheader.appendChild(document.createTextNode(metaData.listTitle));
                          //console.log(viewElem.innerHTML);
                         var compileFn = $compile(viewElem);
                         compileFn($scope);
                         var compileFoot = $compile(footerDiv);
                         compileFoot($scope);
                         var items = $(document).find("div");
                         for(var i=0; i<items.length;i++){               
                             if(items.eq(i).attr("id")==bodyID){
                                   items.eq(i).replaceWith(viewElem);
                                   //alert(viewElem.innerHTML);
                                   //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentMetaDataPath);

                             } else if(items.eq(i).attr("id")==footerID){
                                 items.eq(i).replaceWith(footerDiv);
                             }//end if(items.eq(i).attr("id")=="modalbody")
                         }//end for(var i=0; i<items.length;i++)
                         items = $(document).find("h4");
                         for(var i=0; i<items.length;i++){               
                             if(items.eq(i).attr("id")==titleID){
                                   items.eq(i).replaceWith(titleheader);
                                  // console.log("editDialogBuilderExtern :::: "+viewElem.innerHTML);                
                                  //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentObject.langue);          
                             } 
                         }//end for(var i=0; i<items.length;i++){
                   },function(error){
                       commonsTools.hideDialogLoading();
                       commonsTools.showMessageDialog(error);
                   });
             

         };
         
       
         /**
          * 
          * @param {type} metaData
          * @param {type} datas
          * @returns {undefined}
          */
         $scope.listDialogWithDataBuilder = function(model , metaData , datas , index){
//            $scope.innerWindowType = true;
            $scope.dataCache[metaData.entityName] = datas;
           //Chargement des donnÃ¯Â¿Â½es
//           console.log("editDialogBuilder ==== nbre = "+datas.length+" == meta :"+angular.toJson(metaData));    
            //Traitement du currentObject       
               //Affeectation du model dans l'object temporaire              
             var viewElem =  document.createElement('div'); //;  
             var bodyID = "";
             var endIndex = index;
             if(endIndex==1){
                 bodyID="modalbody";
             }else if(endIndex==2){
                  bodyID="gmodalbody";
             }else if(endIndex==2){
                  bodyID="modalbody1";
             }else if(endIndex==2){
                  bodyID="modalbody2";
             }
             viewElem.setAttribute('id' , bodyID);
             //Construction de la partie recherche
             var editPanel =  $scope.listPanelDialogComponent(metaData,index);
             var bodyElem = document.createElement('div');
             bodyElem.setAttribute('style','overflow: auto;margin-top: -20px;');
             bodyElem.appendChild(editPanel);
             viewElem.appendChild(bodyElem);           
             //Construction du footer
             var footerDiv = document.createElement('div');
             footerDiv.setAttribute('class' , 'modal-footer');
             var footerID = "";
             if(endIndex==1){
                 footerID="modalfooter";
             }else if(endIndex==2){
                  footerID="gmodalfooter";
             }else if(endIndex==2){
                  footerID="modalfooter1";
             }else if(endIndex==2){
                  footerID="modalfooter2";
             }
             footerDiv.setAttribute('id' , footerID);
             var buttonElem = document.createElement('button');
             footerDiv.appendChild(buttonElem);
             buttonElem.setAttribute('class' , 'btn btn-primary');
             buttonElem.setAttribute('ng-click' , "addDialogAction('"+model+"' , 'follower','"+metaData.entityName+"' , '"+metaData.moduleName+"',null,"+(index+1)+")");
             buttonElem.appendChild(document.createTextNode("{{'Valider' | translate}}"));
             //Button annuler
             buttonElem = document.createElement('button');
             footerDiv.appendChild(buttonElem);
             buttonElem.setAttribute('class' , 'btn btn-default');
             buttonElem.setAttribute('data-dismiss' , "modal");
             buttonElem.setAttribute('type' , 'button');
             buttonElem.appendChild(document.createTextNode("{{'Annuler' | translate}}"));
             //Entete modal
             var titleheader = document.createElement('h4');
             titleheader.setAttribute('class','modal-title');
             var titleID = "";
             if(endIndex==1){
                 titleID="modaltitle";
             }else if(endIndex==2){
                  titleID="gmodaltitle";
             }else if(endIndex==2){
                  titleID="modaltitle1";
             }else if(endIndex==2){
                  titleID="modaltitle2";
             }
             titleheader.setAttribute('id',titleID);
             titleheader.appendChild(document.createTextNode(metaData.listTitle));
              //console.log(viewElem.innerHTML);
             var compileFn = $compile(viewElem);
             compileFn($scope);
             var compileFoot = $compile(footerDiv);
             compileFoot($scope);
             var items = $(document).find("div");
             for(var i=0; i<items.length;i++){               
                 if(items.eq(i).attr("id")==bodyID){
                       items.eq(i).replaceWith(viewElem);
                       //alert(viewElem.innerHTML);
                       //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentMetaDataPath);

                 } else if(items.eq(i).attr("id")==footerID){
                     items.eq(i).replaceWith(footerDiv);
                 }//end if(items.eq(i).attr("id")=="modalbody")
             }//end for(var i=0; i<items.length;i++) 


             items = $(document).find("h4");
             for(var i=0; i<items.length;i++){               
                 if(items.eq(i).attr("id")==titleID){
                       items.eq(i).replaceWith(titleheader);
                      // console.log("editDialogBuilderExtern :::: "+viewElem.innerHTML);                
                      //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentObject.langue);          
                 } 
             }//end for(var i=0; i<items.length;i++){
                   
         };
         /**
          * 
          * @param {type} data
          * @param {type} metadata
          * @returns {undefined}
          */
        $scope.listDialogBuilderExternal = function(data , metaData,index){
//            $scope.innerWindowType = true;            
                           //Affeectation du model dans l'object temporaire     
                         $scope.temporalDatas = data;
                         var viewElem =  document.createElement('div'); //;  
                         var endIndex = index+1;
                         var bodyID = "";
                         if(endIndex==1){
                             bodyID = "modalbody";
                         }else if(endIndex==2){
                             bodyID = "gmodalbody";
                         }else if(endIndex==3){
                             bodyID = "modalbody1";
                         }else if(endIndex==4){
                             bodyID = "modalbody2";
                         }
                         viewElem.setAttribute('id' , bodyID);                         
                         //Construction de la partie recherche
                         var editPanel =  $scope.listPanelDialogComponentExter(metaData);
                         var bodyElem = document.createElement('div');
                         bodyElem.setAttribute('style','overflow: auto;margin-top: -20px;');
                         bodyElem.appendChild(editPanel);
                         viewElem.appendChild(bodyElem);           
                         //Construction du footer
                         var footerDiv = document.createElement('div');
                         footerDiv.setAttribute('class' , 'modal-footer');
                         var footerID = "";
                         if(endIndex==1){
                             footerID = "modalfooter";
                         }else if(endIndex==2){
                             footerID = "gmodalfooter";
                         }else if(endIndex==3){
                             footerID = "modalfooter1";
                         }else if(endIndex==4){
                             footerID = "modalfooter2";
                         }
                         footerDiv.setAttribute('id' , footerID);
//                         var buttonElem = document.createElement('button');
//                         footerDiv.appendChild(buttonElem);
//                         buttonElem.setAttribute('class' , 'btn btn-primary');
//                         buttonElem.setAttribute('ng-click' , "addDialogAction('"+model+"' , 'list','"+metaData.entityName+"' , '"+metaData.moduleName+"',null,"+(index+1)+")");
//                         buttonElem.appendChild(document.createTextNode('Save Change'));
                         //Button annuler
                         var buttonElem = document.createElement('button');
                         footerDiv.appendChild(buttonElem);
                         buttonElem.setAttribute('class' , 'btn btn-default');
                         buttonElem.setAttribute('data-dismiss' , "modal");
                         buttonElem.setAttribute('type' , 'button');
                         buttonElem.appendChild(document.createTextNode("{{'Annuler' | translate}}"));
                         //Entete modal
                         var titleheader = document.createElement('h4');
                         titleheader.setAttribute('class','modal-title');
                          var titleID = "";
                         if(endIndex==1){
                             titleID = "modaltitle";
                         }else if(endIndex==2){
                             titleID = "gmodaltitle";
                         }else if(endIndex==3){
                             titleID = "modaltitle1";
                         }else if(endIndex==4){
                             titleID = "modaltitle2";
                         }
                         titleheader.setAttribute('id',titleID);
                         titleheader.appendChild(document.createTextNode(metaData.listTitle));
                          //console.log(viewElem.innerHTML);
                         var compileFn = $compile(viewElem);
                         compileFn($scope);
                         var compileFoot = $compile(footerDiv);
                         compileFoot($scope);
                         var items = $(document).find("div");
                         for(var i=0; i<items.length;i++){               
                             if(items.eq(i).attr("id")==bodyID){
                                   items.eq(i).replaceWith(viewElem);
                                   //alert(viewElem.innerHTML);
                                   //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentMetaDataPath);

                             } else if(items.eq(i).attr("id")==footerID){
                                 items.eq(i).replaceWith(footerDiv);
                             } 
                         } 


                         items = $(document).find("h4");
                         for(var i=0; i<items.length;i++){               
                             if(items.eq(i).attr("id")==titleID){
                                   items.eq(i).replaceWith(titleheader);
                                  // console.log("editDialogBuilderExtern :::: "+viewElem.innerHTML);                
                                  //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentObject.langue);          
                             } 
                         }//end for(var i=0; i<items.length;i++){                   
             

         };
        /**
         * Affichage de la fenetre Dialog pour l'edition d'une entite
          @metaData : MetaData deecrivant la structure de l'entitÃ¯Â¿Â½
         * @param {type} metaData
         * @param {type} index
         * @param {type} link
         * @returns {undefined}
         */
        $scope.editDialogBuilderExtern = function(metaData,index,link,report){           
//           $scope.innerWindowType = true;
           $scope.innerWindowType = 'new';           
           $scope.temporalMetaData = metaData;
           var viewElem =  document.createElement('div'); //;
           var bodyID = "";
           var endIndex = index;
           if(endIndex==1){
               bodyID="modalbody";
           }else if(endIndex==2){
               bodyID="gmodalbody";
           }else if(endIndex==3){
               bodyID="modalbody1";
           }else if(endIndex==4){
               bodyID="modalbody2";
           }//end if(endIndex==1)
           viewElem.setAttribute('id' , bodyID);
           viewElem.setAttribute("class","modal-body");
           viewElem.setAttribute("style","height:100%;");
           var headerElem = $scope.editPanelHeader('temporalData' , metaData,index,true);  
           var editPanel =  null;//$scope.editPanelComponent('temporalData',metaData,'new',index,'temporalData');
           if($scope.currentAction.formView!=null
                      && $scope.currentAction.formView.template!=null){
                editPanel = commonsTools.xmlViewParser($scope.currentAction.formView.template,$scope,'temporalData',metaData,null,0,'temporalData');
            }else{
                editPanel = $scope.editPanelComponent('temporalData' , metaData,null,0,'temporalData',true);   
            }//end if(angular.isDefined($scope.currentAction.formView)
            if(headerElem){
               viewElem.appendChild(headerElem);
           }//end if(headerElem)
           //viewElem.appendChild(headerElem);
           viewElem.appendChild(editPanel);
           //Construction du footer
           var footerDiv = document.createElement('div');
           footerDiv.setAttribute('class' , 'modal-footer');
           var footerID = "";
           if(endIndex==1){
               footerID="modalfooter";
           }else if(endIndex==2){
               footerID="gmodalfooter";
           }else if(endIndex==3){
               footerID="modalfooter1";
           }else if(endIndex==4){
               footerID="modalfooter2";
           }//end if(endIndex==1)
           footerDiv.setAttribute('id' , footerID);
//           console.log("$scope.editDialogBuilderExtern = function(metaData,index,link) ====== canupdate : "+$scope.canUpdate()+" ==== cancreate : "+$scope.canCreate())
           /*if(metaData.desableupdate==true||$scope.canUpdate()||$scope.canCreate())*/{
                var buttonElem = document.createElement('button');
                footerDiv.appendChild(buttonElem);
                buttonElem.setAttribute('class' , 'btn btn-primary');
                if(angular.isDefined(report) && report==true){
                    buttonElem.setAttribute('ng-click', "printDialogAction('temporalData' , 'save_only','"+metaData.entityName+"' , '"+metaData.moduleName+"',null,"+(index+1)+",null,'"+link+"')"); 
                }else{
                    buttonElem.setAttribute('ng-click', "addDialogAction('temporalData' , 'save_only','"+metaData.entityName+"' , '"+metaData.moduleName+"',null,"+(index+1)+",null,'"+link+"')"); 
                }//end if(angular.isDefined(report) && report==true){
                if(angular.isDefined(report) && report==true){
                    buttonElem.appendChild(document.createTextNode("{{'Imprimer' | translate}}"));
                }else{
                    buttonElem.appendChild(document.createTextNode("{{'Valider' | translate}}"));
                }//end if(angular.isDefined(report) && report==true)
                //buttonElem.setAttribute("ng-hide",metaData.desablecreate);
           }//end if($scope.windowType!='view'){                      
           //Button annuler
           buttonElem = document.createElement('button');
           footerDiv.appendChild(buttonElem);
           buttonElem.setAttribute('class' , 'btn btn-default');
           buttonElem.setAttribute('data-dismiss' , "modal");
           buttonElem.setAttribute('type' , 'button');
           buttonElem.setAttribute('ng-click' , 'annulerAction2()');
           buttonElem.appendChild(document.createTextNode("{{'Annuler' | translate}}"));
           //Entete modal
           var titleheader = document.createElement('h4');
           titleheader.setAttribute('class','modal-title');
           var titleID = "";
           if(endIndex==1){
               titleID="modaltitle";
           }else if(endIndex==2){
               titleID="gmodaltitle";
           }else if(endIndex==3){
               titleID="gmodaltitle1";
           }else if(endIndex==4){
               titleID="modaltitle2";
           }//end if(endIndex==1){
           titleheader.setAttribute('id',titleID);
           titleheader.appendChild(document.createTextNode(metaData.editTitle));
            //console.log(viewElem.innerHTML);
           var compileFn = $compile(viewElem);
           compileFn($scope);
           var compileFoot = $compile(footerDiv);
           compileFoot($scope);
           var items = $(document).find("div");
           for(var i=0; i<items.length;i++){               
               if(items.eq(i).attr("id")==bodyID){
                     items.eq(i).replaceWith(viewElem);
                      //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentMetaDataPath);
               } else if(items.eq(i).attr("id")==footerID){
                   items.eq(i).replaceWith(footerDiv);
               }//end if(items.eq(i).attr("id")==bodyID){ 
           }//end for(var i=0; i<items.length;i++){          
           items = $(document).find("h4");
           for(var i=0; i<items.length;i++){               
               if(items.eq(i).attr("id")==titleID){
                     items.eq(i).replaceWith(titleheader);
                    // console.log("editDialogBuilderExtern :::: "+viewElem.innerHTML);                
                    //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentObject.langue);          
               } 
           } 
            $timeout(function() {
                  $('.selectpicker').selectpicker('refresh');       
                  commonsTools.selectpickerKeyup(metaData,'temporalData',$scope);
              });
          
        };
        
        /**
         * 
         * @param {type} metaData
         * @param {type} index
         * @param {type} link
         * @returns {undefined}
         */
         $scope.exportDialogBuilderExtern = function(index){           
//           $scope.innerWindowType = true;
           $scope.innerWindowType = 'new';           
           var viewElem =  document.createElement('div'); //;
           var bodyID = "";
           var endIndex = index;
           if(endIndex==1){
               bodyID="modalbody";
           }else if(endIndex==2){
               bodyID="gmodalbody";
           }else if(endIndex==3){
               bodyID="modalbody1";
           }else if(endIndex==4){
               bodyID="modalbody2";
           }//end if(endIndex==1)
           viewElem.setAttribute('id' , bodyID);
           viewElem.setAttribute("class","modal-body");
           viewElem.setAttribute("style","height:100%;");
           var content = $scope.viewSelector('export');
//           var editPanel = angular.element(content);
//           var compileFn = $compile(editPanel);
//           compileFn($scope);
           
           viewElem.append(content);
           //Construction du footer
           var footerDiv = document.createElement('div');
           footerDiv.setAttribute('class' , 'modal-footer');
           var footerID = "";
           if(endIndex==1){
               footerID="modalfooter";
           }else if(endIndex==2){
               footerID="gmodalfooter";
           }else if(endIndex==3){
               footerID="modalfooter1";
           }else if(endIndex==4){
               footerID="modalfooter2";
           }//end if(endIndex==1)
           footerDiv.setAttribute('id' , footerID);
//           console.log("$scope.editDialogBuilderExtern = function(metaData,index,link) ====== canupdate : "+$scope.canUpdate()+" ==== cancreate : "+$scope.canCreate())
           if($scope.canUpdate()||$scope.canCreate()){
                var buttonElem = document.createElement('button');
                footerDiv.appendChild(buttonElem);
                buttonElem.setAttribute('class' , 'btn btn-primary');
                buttonElem.setAttribute('ng-click' , "exportDataAction()");
                buttonElem.appendChild(document.createTextNode("{{'Exporter' | translate}}"));
//                buttonElem.setAttribute("ng-hide",metaData.desablecreate);
           }//end if($scope.windowType!='view'){                      
           //Button annuler
           buttonElem = document.createElement('button');
           footerDiv.appendChild(buttonElem);
           buttonElem.setAttribute('class' , 'btn btn-default');
           buttonElem.setAttribute('data-dismiss' , "modal");
           buttonElem.setAttribute('type' , 'button');
           buttonElem.setAttribute('ng-click' , 'annulerAction2()');
           buttonElem.appendChild(document.createTextNode("{{'Fermer' | translate}}"));
           //Entete modal
           var titleheader = document.createElement('h4');
           titleheader.setAttribute('class','modal-title');
           var titleID = "";
           if(endIndex==1){
               titleID="modaltitle";
           }else if(endIndex==2){
               titleID="gmodaltitle";
           }else if(endIndex==3){
               titleID="gmodaltitle1";
           }else if(endIndex==4){
               titleID="modaltitle2";
           }//end if(endIndex==1){
           titleheader.setAttribute('id',titleID);
           titleheader.appendChild(document.createTextNode("{{'EXPORTDATA' | translate}}"));
            //console.log(viewElem.innerHTML);
           var compileFn = $compile(titleheader);
           compileFn($scope);
           var compileFn = $compile(content);
           compileFn($scope);
           var compileFoot = $compile(footerDiv);
           compileFoot($scope);
           var items = $(document).find("div");
           for(var i=0; i<items.length;i++){               
               if(items.eq(i).attr("id")==bodyID){
                     items.eq(i).replaceWith(content);
                      //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentMetaDataPath);
               } else if(items.eq(i).attr("id")==footerID){
                   items.eq(i).replaceWith(footerDiv);
               }//end if(items.eq(i).attr("id")==bodyID){ 
           }//end for(var i=0; i<items.length;i++){          
           items = $(document).find("h4");
           for(var i=0; i<items.length;i++){               
               if(items.eq(i).attr("id")==titleID){
                     items.eq(i).replaceWith(titleheader);
                    // console.log("editDialogBuilderExtern :::: "+viewElem.innerHTML);                
                    //console.log("$scope.editDialogBuilder = function(model , item , type) ::: "+$scope.currentObject.langue);          
               } 
           } 
            $timeout(function() {
                  $('.selectpicker').selectpicker('refresh');              
              });
             var modalID = "";
             var endIndex = index;            
             if(endIndex==1){
                modalID = "myModal";
             }else if(endIndex==2){
                modalID = "globalModal";
             }else if(endIndex==3){
                modalID = "myModal1";
             }else if(endIndex==4){
                modalID = "myModal2";
             }//end if(endIndex==1){
            $("#"+modalID).modal("toggle");
            $("#"+modalID).modal("show");
        };
       
        /**
         * 
         * @param {type} model
         * @param {type} item
         * @returns {undefined}
         */
        $scope.removeFromTable = function(model , item,modelpath){
            var parts = model.split(".");            
            if(parts.length>1){
                var datamodel = $scope.getParentModel(model);
                $scope.removeFromArray(datamodel[parts[parts.length-1]],item);
                 var metaData = $scope.getCurrentMetaData(model) ;
                //console.log("editDialogBuilder  =====  ************* Vous avez cliquez :::: "+model+" ***** "+item+" ==== "+type+" ::: "+entityName+" ::: "+moduleName+" == "+angular.toJson(metaData));
                if(!metaData){
                   var exprFn = $parse($scope.currentMetaDataPath);     
                   metaData = exprFn($scope); 
                }
                //Evenement de construction du pied de tableau
                $rootScope.$broadcast("tablefooter" , {metaData:metaData,model:model,modelpath:modelpath});  
//                var footerElem = commonsTools.sumFooterTableBuilder(metaData ,$scope.currentObject,model);
//                var sources =model.split(".");
//                 ///Remplacement dans la vue
//                var items = $element.find("tfoot");
//                for(var i=0; i<items.length;i++){
//
//                     if(items.eq(i).attr("id")==sources[1]){
//                           items.eq(i).replaceWith(footerElem);
//                     }  
//                }
            }
            //console.log("$scope.removeFromTable = "+model+" === "+angular.toJson(item));
        };
    
    /**
     * 
     * @returns {undefined}
     */
        $scope.cancelDialogAction = function(){
            $scope.currentObject = $scope.dataCache['currentObject'];
            $scope.currentAction = $scope.dataCache['currentAction'];
            $scope.innerWindowType = false;
            //console.log("$scope.cancelDialogAction = ======== ");
            $('#myModal').modal('hide');            
        };
        
        /**
         * Action d'ajout dans le tabeau
         * @param {type} model
         * @param {type} type
         * @param {type} entityName
         * @param {type} moduleName
         * @param {type} customfooter
         * @param {type} index
         * @param {type} modelpath
         * @param {type} link
         * @returns {undefined}
         */
        $scope.addDialogAction = function(model , type,entityName , moduleName,customfooter,index,modelpath,link){  
//           console.log("$scope.addDialogAction ===== model:"+model+" type:"+type+" entity:"+entityName+" module:"+moduleName+"  index:"+index+" ::: modelpath:"+modelpath+"  link : "+link);
            var modalID = "";
            var endIndex = index-1;            
            if(endIndex==1){
                modalID = "myModal";
            }else if(endIndex==2){
                modalID = "globalModal";
            }else if(endIndex==3){
                modalID = "myModal1";
            }else if(endIndex==4){
                modalID = "myModal2";
            }
           $scope.innerWindowType = false;
           ///end if($scope.windowType=="report")
           if(type=="new"){ 
                 //$scope.displayEditPanel();
                 var part = model.split(".");
                  var key = commonsTools.keygenerator(modelpath);
                  var metaData = $scope.getCurrentMetaData(modelpath) ;
                  commonsTools.compteField($scope.dataCache[""+key],$scope.currentObject,$scope.currentUser,metaData);
//                  console.log("addDialogBuilder  =====  ************* Vous avez cliquez :::: "+model+" ***** ==== "+modelpath+" === Meta data :"+angular.toJson(metaData)+"\n === Data :"+angular.toJson($scope.dataCache[""+key]));
                  //Validation des champs de la vue
                    var validate = $scope.validateFields(metaData,$scope.dataCache[""+key]);
                    if(validate.length>0){
                            var message = "";
                            for(var i=0; i<validate.length;i++){
                                    message = message+"<br/>"+validate[i];
                            }//end for(var i=0; i<validate.length;i++)
                            $scope.notifyWindow("Les champs suivants sont incorrects" ,message,"danger",modalID);                        
                            throw "Interrupt";
                    }//end if(validate.length>0){
                  if(part[0]=='currentObject'){                     
                     $scope.temporalModel = $scope.getCurrentModel(model);
                     $scope.temporalModel.unshift($scope.dataCache[""+key]);
                  }else{
                     $scope.temporalModel = $scope.getCurrentModel(model); 
//                     console.log("principal.addDialogAction_6994 :::::::::::::::::::: "+model+" ===== "+$scope.temporalModel+" === modelpath : "+modelpath+"==== key : "+key+" datacache : "+angular.toJson($scope.dataCache));
                     $scope.temporalModel.unshift($scope.dataCache[""+key]);
                 }//end  if(part[0]=='currentObject')           
                var sources = model.split('.');
                if(!metaData){
                   var exprFn = $parse($scope.currentMetaDataPath);     
                   metaData = exprFn($scope); 
                }//end if(!metaData){
                //Evenement de construction du pied de tableau
                $rootScope.$broadcast("tablefooter" , {metaData:metaData,model:model,modelpath:modelpath});  
                
            }else if(type=="update"){
                var key = commonsTools.keygenerator(modelpath);
//                $scope.innerWindowType = true;
                var metaData = $scope.getCurrentMetaData(modelpath) ;
                commonsTools.compteField($scope.dataCache[""+key],$scope.currentObject,$scope.currentUser,metaData);
                //Validation des champs de la vue
                var validate = $scope.validateFields(metaData,$scope.dataCache[""+key]);
                if(validate.length>0){
                        var message = "";
                        for(var i=0; i<validate.length;i++){
                                message = message+"<br/>"+validate[i];
                        }//end for(var i=0; i<validate.length;i++)
                        $scope.notifyWindow("Les champs suivants sont incorrects" ,message,"danger",modalID);                        
                        throw "Interrupt";
                }//end if(validate.length>0){
                var item = $scope.temporalDatas.pop(); 
                angular.extend(item ,$scope.dataCache[""+key]);   //angular.extend(item , $scope.temporalData);   
//                console.log("addDialogBuilder  =====  ************* Vous avez cliquez :::: "+model+" ***** ==== "+modelpath+" === Meta data :"+angular.toJson(metaData)+"\n === Data :"+angular.toJson($scope.dataCache[""+key]));
                if(!metaData){
                   var exprFn = $parse($scope.currentMetaDataPath);     
                   metaData = exprFn($scope); 
                }//end if(!metaData)
                 //Evenement de construction du pied de tableau
                $rootScope.$broadcast("tablefooter" , {metaData:metaData,model:model,modelpath:modelpath});  

            }else if(type=="new_entity"){
                var key = commonsTools.keygenerator(modelpath);
                var metaData = $scope.getCurrentMetaData(model) ;
                //Validation des champs de la vue
                var validate = $scope.validateFields(metaData,$scope.dataCache[""+key]);
                if(validate.length>0){
                        var message = "";
                        for(var i=0; i<validate.length;i++){
                                message = message+"<br/>"+validate[i];
                        }//end for(var i=0; i<validate.length;i++)
                        $scope.notifyWindow("Les champs suivants sont incorrects" ,message,"danger",modalID);                        
                        throw "Interrupt";
                }//end if(validate.length>0){
                $scope.saveanrelaod(model,$scope.dataCache[""+key],entityName,moduleName,modelpath);                
            }else if(type=='save_only'){
                //Validation des champs de la vue
                var metaData = $scope.getCurrentMetaData(model) ;
                var validate = $scope.validateFields(metaData,$scope.temporalData);
                if(validate.length>0){
                        var message = "";
                        for(var i=0; i<validate.length;i++){
                                message = message+"<br/>"+validate[i];
                        }//end for(var i=0; i<validate.length;i++)
                        $scope.notifyWindow("Les champs suivants sont incorrects" ,message,"danger",modalID);                        
                        throw "Interrupt";
                }//end if(validate.length>0){
                $scope.saveonly(model,$scope.temporalData,entityName,moduleName,link);   
//                $("#globalModal").modal("hide");
            }else if(type=="list"){
                var parts = model.split(".");
                var key = commonsTools.keygenerator(model);
                if(parts.length>1){      
                     var metaData = $scope.getCurrentMetaData(model) ;
                     var col =parts.length-1;
                    //Ajout des donnÃ¯Â¿Â½es
                    var items = $scope.dataCache.selectedObjects;
                    $scope.dataCache[""+key+""] = new Array();
                    var templateModel = null;
//                    if(parts[0]=='currentObject'){
//                        templateModel = $scope.currentObject;
//                    }else if(parts[0]=='temporalData'){
//                        templateModel = $scope.temporalData;
//                    }else if(parts[0]=='dataCache'){                        
//                        templateModel = $scope.dataCache;
//                        for(var i=1 ; i<parts.length-1;i++){
//                            templateModel = templateModel[parts[i]];
//                        }//end for(var i=1 ; i<parts.length-1;i++){
//                    }//end if(parts[0]=='currentObject')
//                    if(!angular.isDefined(templateModel[parts[col]])){
                        templateModel = $scope.getParentModel(model);
//                        console.log("$scope.addDialogAction =list ===== fieldName: "+parts[col]+" == modelpath:"+model+"  template:"+angular.toJson(templateModel)+" ==== metadata : ");
//                    }//end if(!angular.isDefined(templateModel[parts[col]]))
                    
                    if(angular.isArray(templateModel[parts[col]])){
                        if(!templateModel[parts[col]]){
                            templateModel[parts[col]] = new Array();
                        }//end if(!templateModel[parts[col]]){
                        for(var i=0 ;i<items.length;i++){                        
                            if(!commonsTools.contains(templateModel,items[i])){
                                templateModel[parts[col]].push(items[i]);
                                $scope.dataCache[""+key+""].push(items[i]);
                            }//end if(!$scope.containsObject($scope.currentObject[parts[1]],items[i]))
                        }//end for(var i=0 ;i<items.length;i++)
                    }else{
                        if(items.length>0){
                            templateModel[parts[col]] = items[0];
                            $scope.dataCache[""+key+""].push(items[0]);
                        }
                    }//end if(angular.isArray($scope.currentObject[parts[1]]))
                    //console.log($scope.dataCache[""+parts[1]+""]);
                    $timeout(function() {
                       $('.selectpicker').selectpicker('refresh');
                    });
                    var obj = {id:'load' , designation:'Charger les donnÃ©es ....'};
                    $scope.dataCache[""+key+""].push(obj);                    
                     var modelpart = model.split(".");
                     var fieldName = modelpart[modelpart.length-1];
                     var observable = $scope.observablePools[fieldName];
                     if(observable){
                        observable.notifyObservers();
                     }//end if(observable)
                     //Evenement de construction du pied de tableau
//                    $rootScope.$broadcast("tablefooter" , {metaData:metaData,model:model});  
                }//end if(parts.length>1)
            }else if(type=="follower"){                
//                console.log("$scope.addDialogAction ==== "+$scope.dataCache[entityName].length+" === "+type+" === "+entityName);
                if($scope.dataCache[entityName].length>0){
                    for(var i=0;i<$scope.dataCache[entityName].length;i++){
                        if(angular.lowercase(entityName)=="utilisateur"){
                            $scope.dataCache['follower'].abonnes.push($scope.dataCache[entityName][i]);
                        }else if(angular.lowercase(entityName)=="canal"){
                            $scope.dataCache['follower'].canaux.push($scope.dataCache[entityName][i]);
                        }//end if(angular.lowercase(entityName)=="utilisateur")
                    }//end for(var i=0;i<$scope.dataCache[entityName].length;i++)
                    
                    var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/follower";
                    if($scope.dataCache['follower'].id==-1){
                        $http.post(url,$scope.dataCache['follower'])
                                .then(function(response){
                                        var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/follower/entity/"+$scope.currentObject.serial+"/"+$scope.currentObject.id;
                                        $http.get(url)
                                                .then(function(response){
                                                    $scope.dataCache['follower'] = response.data;  
                                                    $scope.buildfollowermenu();
                                                },function(error){
                                                    commonsTools.showMessageDialog(error);
                                                });
                                },function(error){
                                    commonsTools.showMessageDialog(error);
                                });
                    }else{
                        
                        $http.put(url+"/"+$scope.dataCache['follower'].id,$scope.dataCache['follower'])
                                .then(function(response){
                                     var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/follower/entity/"+$scope.currentObject.serial+"/"+$scope.currentObject.id;
                                    $http.get(url)
                                            .then(function(response){
                                                $scope.dataCache['follower'] = response.data;  
                                                $scope.buildfollowermenu();
                                            },function(error){
                                                commonsTools.showMessageDialog(error);
                                            });
                                },function(error){
                                    commonsTools.showMessageDialog(error);
                                });
                    }//end if($scope.dataCache['follower'].id==-1)
                }//end if($scope.dataCache[entityName].length>0)
            }            
            $timeout(function() {
                $('.selectpicker').selectpicker('refresh');

            });           
            $('#'+modalID).modal('hide');            
        };
        
        /**
         * 
         * @param {type} model
         * @param {type} type
         * @param {type} entityName
         * @param {type} moduleName
         * @param {type} customfooter
         * @param {type} index
         * @param {type} modelpath
         * @param {type} link
         * @returns {undefined}
         */
         $scope.printDialogAction = function(model , type,entityName , moduleName,customfooter,index,modelpath,link){  
//           console.log("$scope.addDialogAction ===== model:"+model+" type:"+type+" entity:"+entityName+" module:"+moduleName+"  index:"+index+" ::: modelpath:"+modelpath+"  link : "+link);
                var modalID = "";
                var endIndex = index-1;            
                if(endIndex==1){
                    modalID = "myModal";
                }else if(endIndex==2){
                    modalID = "globalModal";
                }else if(endIndex==3){
                    modalID = "myModal1";
                }else if(endIndex==4){
                    modalID = "myModal2";
                }
               $scope.innerWindowType = false;          
               var report = $scope.dataCache["report"];
               var url = $location.protocol()+'://'+$location.host()+':'+$location.port()+'/'+angular.lowercase(report.model)+'/'+angular.lowercase(report.entity)+'/bi/'+report.method;
               commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");        
//               $http.defaults.headers.common['args']= angular.toJson($scope.temporalData);
//$http.get(url, {responseType: 'arraybuffer',data:angular.toJson($scope.temporalData)})
               if(report.extern==false){
                   $http.put(url,$scope.temporalData)
                           .then(function(response){
                               $scope.temporalDatas = response.data;   
//                               console.log("$scope.addDialogAction ========= "+angular.toJson($scope.temporalDatas));
                               commonsTools.hideDialogLoading();
                               $scope.displayReportPanel(report.script);  
                           },function(error){
                               commonsTools.showMessageDialog(error);
                               commonsTools.hideDialogLoading();
                           });
               }else{
                     $http.put(url,$scope.temporalData, {responseType: 'arraybuffer'})
                       .then(function(response){
                              var contentElem = $scope.viewSelector("report");
//                               console.log(angular.toJson("$scope.addDialogAction ====== "+angular.toJson(response)));
                               var viewer = document.createElement("iframe");
                               viewer.setAttribute("id","iframe0001");
                               viewer.setAttribute("src",url);
                               viewer.setAttribute("alt","pdf");
                               viewer.setAttribute("width","100%");
                               viewer.setAttribute("height","700px");
//                               viewer.setAttribute("pluginspage","http://www.adobe.com/products/acrobat/readstep2.html");
//                               viewer.setAttribute("class","ng-isolate-scope");
                               var divElem = document.createElement("div");
                               divElem.setAttribute("id","report");
                               divElem.setAttribute("width","100%");
                               divElem.setAttribute("height","100%");
                               divElem.appendChild(viewer);
                               var items = contentElem.find('div');
                                for(var i=0; i<items.length;i++){
                                   if(items.eq(i).attr("id")=="report"){
                                         items.eq(i).replaceWith(divElem);                               
                                   }  
                               }//enn$d for(var i=0; i<items.length;i++){                               
                               // ///Remplacement dans la vue
                              var items = $element.find("div");
                              for(var i=0; i<items.length;i++){
                                   if(items.eq(i).attr("id")=="innerpanel"){
                                         items.eq(i).replaceWith(contentElem);
                                          //console.log(" ======================= on a trouve report  innerpanel");
                                   }//end if(items.eq(i).attr("id")=="innerpanel")  
                              }//end for(var i=0; i<items.length;i++)
                               var compileFn = $compile(contentElem);
                               compileFn($scope);                              
                                var arrayBufferView = new Uint8Array(response.data );
                                var blob = new Blob( [ arrayBufferView ], { type: "application/pdf" } );
                                var urlCreator = window.URL || window.webkitURL;
                                var pdfUrl = urlCreator.createObjectURL( blob );
                                var pdf = document.querySelector( "#iframe0001");
                                pdf.src = pdfUrl;
//                               console.log($scope.temporalData);                      
                                commonsTools.hideDialogLoading();
                       },function(error){
                           commonsTools.showMessageDialog(error);
                           commonsTools.hideDialogLoading();
                       });
               }//end if(report.extern==false)
              
//               console.log("Critere de recherh=c*************** "+$scope.dataCache["report"]+" === "+angular.toJson($scope.temporalData));
               $("#globalModal").modal("hide");
           //end if($scope.windowType=="report")           
            $timeout(function() {
                $('.selectpicker').selectpicker('refresh');

            });           
            $('#'+modalID).modal('hide');            
        };        
       /***
        * 
        */
        $scope.$on("tablefooter" , function(event , args){
              var sources =args.model.split(".");    
               var key = commonsTools.keygenerator(args.modelpath);
               var footerElem = null ;
               var data = $scope.currentObject;
                if(sources[0]!="currentObject"){
                    data = $scope.dataCache[""+key];                    
                }//end if(sources[0]!="currentObject"){
                if(data==null||!angular.isDefined(data)){
                    return ;
                }
                data = data[sources[sources.length-1]];
                if($scope.dataCache[key+"foot"]){                   
                    footerElem = commonsTools.tableFooterBuilder($scope.dataCache[key+"foot"],data,key,$scope.currentObject,$scope.currentObject);
//                     console.log("tablefooter  =====  ************* Vous avez cliquez :::: "+args.model+" === "+args.modelpath+" === "+angular.toJson(data));
                }else{
                    footerElem = commonsTools.sumFooterTableBuilder(args.metaData ,data,args.model,key);
                }//end if($scope.dataCache[sources[1]])
                ///Remplacement dans la vue
                var items = $element.find("tfoot");
                for(var i=0; i<items.length;i++){
                     if(items.eq(i).attr("id")==key){
                           items.eq(i).replaceWith(footerElem);
                     }  
                }
                $scope.dataCache[key] = null;
           });

       /**
        * 
        * @param {type} columns
        * @returns {undefined}
        */
        $scope.createFromFields = function(columns,template){
              for(var i=0 ; i< columns.length;i++){
                   if(columns[i].type=='object'){
                     if(!$scope.currentObject[""+columns[i].fieldName+""]){
                        if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""])){
                            $scope.currentObject[""+columns[i].fieldName+""] = null;
                        }else{
                            $scope.currentObject[""+columns[i].fieldName+""] = template[""+columns[i].fieldName+""];
                        }//end if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""]))
                     }//end if(!$scope.currentObject[""+columns[i].fieldName+""])
                   }else if(columns[i].type=='array'){
                      if(!$scope.currentObject[""+columns[i].fieldName+""]) {
                         if(!$scope.currentObject[""+columns[i].fieldName+""]) {
                                if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""])){
                                    $scope.currentObject[columns[i].fieldName] = new Array();
                                }else{
                                    $scope.currentObject[columns[i].fieldName] =  new Array();
                                    if(angular.isArray(template[""+columns[i].fieldName+""])){
                                        $scope.currentObject[columns[i].fieldName] =  template[""+columns[i].fieldName+""];
                                    }else{
                                        $scope.currentObject[columns[i].fieldName].push(template[""+columns[i].fieldName+""]);
                                    }//end if(angular.isArray(template[""+columns[i].fieldName+""])){
                                    
                                }//end if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""]))
                          }//end if(!$scope.temporalData[""+columns[i].fieldName+""]) 
                       }                       
                   }else{
                       if(!$scope.currentObject[""+columns[i].fieldName+""]) {
                            if(!$scope.currentObject[""+columns[i].fieldName+""]) {
                               if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""])){
                                   $scope.currentObject[""+columns[i].fieldName+""] = "";
                               }else{
                                   $scope.currentObject[""+columns[i].fieldName+""] = template[""+columns[i].fieldName+""];
                               }//end if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""]))
                            }//end if(!$scope.temporalData[""+columns[i].fieldName+""])
                       }//end if(!$scope.currentObject[""+columns[i].fieldName+""]) {
                   }
               }
        };
        /**
         * 
         * @param {type} entity
         * @param {type} columns
         * @returns {undefined}
         */
        $scope.createFreeFromFields = function(entity , columns){
              for(var i=0 ; i< columns.length;i++){
                   if(columns[i].type=='object'){
                     if(!entity[""+columns[i].fieldName+""]){
                       entity[""+columns[i].fieldName+""] = null;
                     }
                   }else if(columns[i].type=='array'){
                      if(!entity[""+columns[i].fieldName+""]) {
                         entity[columns[i].fieldName] = new Array();
                       }
                       //console.log("createFromFields =====  "+$scope.currentObject[columns[i].fieldName]);                       
                           
                       //object["'"+metaData.columns[i].fieldName+"'"].push($scope.createEmptyObject(metaData.columns[i].metaData));
                   }else{
                       if(!entity[""+columns[i].fieldName+""]) {
                         entity[""+columns[i].fieldName+""] = "";
                       }
                   }
               }
        };

        /**
         Create a empty object base of the metaData
         @metaData : the description of the object
      **/
      $scope.createEmptyObject  = function(metaData,template){            
             //var object = new Object();
             if(metaData){
                //Cas des colonnes
                if(metaData.columns){
                      $scope.createFromFields(metaData.columns,template);                     
                }//end if(metaData.columns){
                //Traitement des champs groups
                if(metaData.groups){
                     //Traitement des groups
                     for(var i=0 ; i< metaData.groups.length;i++){
                         //Cas des colonnes
                         if(metaData.groups[i].columns){
                            $scope.createFromFields(metaData.groups[i].columns,template);
                         }//end if(metaData.groups[i].columns){
                         //cas des metaArray
                         if(metaData.groups[i].metaArray && metaData.groups[i].metaArray.length>0){
                             for(var j=0;j<metaData.groups[i].metaArray.length;j++){
                                 $scope.currentObject[metaData.groups[i].metaArray[j].fieldName] = new Array();
                             }//end if(var j=0;j<metaData.groups[i].metaArray.length;j++)                             
                         }//end if(metaData.groups[i].metaArray && metaData.groups[i].metaArray.length>0){
                     }//end for(var i=0 ; i< metaData.groups.length;i++){
                }//end if(metaData.groups){
             } //end if(metaData){
             var today = new Date();
             $scope.currentObject['compareid'] = today.getTime();
             $scope.currentObject['id'] = -1;
         };
         /**
          * 
          * @param {type} metaData
          * @returns {undefined}
          */
         $scope.createFreeEmptyObject  = function(metaData){            
             var entity = new Object();
             if(metaData){
                //Cas des colonnes
                if(metaData.columns){
                      $scope.createFreeFromFields(entity , metaData.columns);                     
                }
                //Traitement des champs groups
                if(metaData.groups){
                     //Traitement des groups
                     for(var i=0 ; i< metaData.groups.length;i++){
                         //Cas des colonnes
                         if(metaData.groups[i].columns){
                            $scope.createFreeFromFields(entity , metaData.groups[i].columns);
                         }//end if(metaData.groups[i].columns){
                         //cas des metaArray
                         //cas des metaArray
                         if(metaData.groups[i].metaArray && metaData.groups[i].metaArray.length>0){
                             for(var j=0;j<metaData.groups[i].metaArray.length;j++){
                                 entity[metaData.groups[i].metaArray[j].fieldName] = new Array();
                             }//end if(var j=0;j<metaData.groups[i].metaArray.length;j++)                             
                         }//end if(metaData.groups[i].metaArray && metaData.groups[i].metaArray.length>0)
                     }//end for(var i=0 ; i< metaData.groups.length;i++)
                }//end if(metaData.groups){

             }//end if(metaData){ 
             var today = new Date();
             entity['compareid'] = today.getTime();
            return entity ;
         };
         /**
          * 
          * @param {type} columns
          * @returns {undefined}
          */
        $scope.createTemporalFromFields = function(columns,template){               
              for(var i=0 ; i< columns.length;i++){
//                  console.log("createFromFields =====  "+columns[i].type+"  === "+angular.toJson(template)); 
                   if(columns[i].type=='object'){
                     if(!$scope.temporalData[""+columns[i].fieldName+""]){
                       if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""])){
                            $scope.temporalData[""+columns[i].fieldName+""] = null;
                        }else{
                            $scope.temporalData[""+columns[i].fieldName+""] = template[""+columns[i].fieldName+""];
                        }//end if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""]))
                     }//end if(!$scope.temporalData[""+columns[i].fieldName+""])                     
                   }else if(columns[i].type=='array'){                     
                      if(!$scope.temporalData[""+columns[i].fieldName+""]) {
                          if(!$scope.temporalData[""+columns[i].fieldName+""]) {
                                if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""])){
                                    $scope.temporalData[columns[i].fieldName] = new Array();
                                }else{
                                    $scope.temporalData[columns[i].fieldName] =  new Array();
                                    if(angular.isArray(template[""+columns[i].fieldName+""])){
                                        $scope.temporalData[columns[i].fieldName] =  template[""+columns[i].fieldName+""];
                                    }else{
                                        $scope.temporalData[columns[i].fieldName].push(template[""+columns[i].fieldName+""]);
                                    }//end if(angular.isArray(template[""+columns[i].fieldName+""])){
                                    
                                }//end if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""]))
                          }//end if(!$scope.temporalData[""+columns[i].fieldName+""]) 
                       }                                         
                           
                       //object["'"+metaData.columns[i].fieldName+"'"].push($scope.createEmptyObject(metaData.columns[i].metaData));
                   }else{
                       if(!$scope.temporalData[""+columns[i].fieldName+""]) {
                            if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""])){
                                $scope.temporalData[""+columns[i].fieldName+""] = "";
                            }else{
                                $scope.temporalData[""+columns[i].fieldName+""] = template[""+columns[i].fieldName+""];
                            }//end if(template==null||!angular.isDefined(template[""+columns[i].fieldName+""]))
                       }//end if(!$scope.temporalData[""+columns[i].fieldName+""])
                   }
               }
        };
           /**
         Create a empty object base of the metaData
         @metaData : the description of the object
      **/
      $scope.createEmptyTemporalObject  = function(metaData,template){            
             //var object = new Object();

             if(metaData){
                //Cas des colonnes
                if(metaData.columns){
                      $scope.createTemporalFromFields(metaData.columns,template);                     
                }
                //Traitement des champs groups
                if(metaData.groups){
                     //Traitement des groups
                     for(var i=0 ; i< metaData.groups.length;i++){
                         //Cas des colonnes
                         if(metaData.groups[i].columns){
                            $scope.createTemporalFromFields(metaData.groups[i].columns,template);
                         }
//                         $scope.temporalData[columns[i].fieldName] =  new Array();                        
                         //cas des metaArray
                         if(metaData.groups[i].metaArray&&metaData.groups[i].metaArray.length>0){
                             for(var j=0;j<metaData.groups[i].metaArray.length;j++){
                                $scope.temporalData[metaData.groups[i].metaArray[j].fieldName] = new Array();
                                if(template!=null&&angular.isDefined(template) && angular.isDefined(template[""+metaData.groups[i].metaArray[j].fieldName+""])){
                                    if(angular.isArray(template[""+metaData.groups[i].metaArray[j].fieldName+""])){
                                       $scope.temporalData[metaData.groups[i].metaArray[j].fieldName] =  template[""+metaData.groups[i].metaArray[j].fieldName+""];
                                    }else{
                                       $scope.temporalData[metaData.groups[i].metaArray[j].fieldName].push(template[""+metaData.groups[i].metaArray[j].fieldName+""]);
                                    }//end if(angular.isArray(template[""+columns[i].fieldName+""])){
                                }//end if(angular.isDefined(template[""+metaData.groups[i].metaArray[j].fieldName+""])){
                            }//end for(var j=0;j<metaData.groups[i].metaArray.length;j++)
                         }//end if(metaData.groups[i].metaArray){
                     }
                }

             } 
            
         };

         /**
          * 
          * @param {type} title
          * @param {type} message
          * @param {type} type
          * @returns {undefined}
          */
         $scope.notifyWindow = function(title , message ,type,parent){
            $.notify(
                  {
                    title: "<strong>"+title+":</strong> ",
                    message: message                    
                  },{
                      type:type,
                      z_index: 5800,
                      animate: {
                        enter: 'animated fadeInRight',
                        exit: 'animated fadeOutRight'
                      }                      
                  }
                );
           
         };


       $scope.uniqueContraints = [];
       /**
         Validate all the fields of the forms to chack constraint validation
          
       **/
     
      /**
       * Validate and clean Beans
       * @param {type} metaData
       * @param {type} entity
       * @returns {Array}
       */
       $scope.validateFields = function(metaData,currentObject){
            var champs = new Array();
            $scope.uniqueContraints =  new Array();
            if(metaData && currentObject){
                if(metaData.columns){
                   for(var i=0 ; i<metaData.columns.length;i++){
                       //Traitrement des object
                       if(angular.isObject(currentObject[metaData.columns[i].fieldName])){
                           var entity = currentObject[metaData.columns[i].fieldName];
                           if(entity.id=='load'){
                               currentObject[metaData.columns[i].fieldName]=null;
                           }//end if(entity.id=='load')
                       }else if(angular.isArray(currentObject[metaData.columns[i].fieldName])){
                           var array = currentObject[metaData.columns[i].fieldName];
                           for(var i=0 ; i<array.length;i++){
                               if(angular.isObject(array[i]) && array[i].id=='load'){
                                   array[i]=null;
                               }//end if(array[i].id=='load')
                           }//end for(var i=0 ; i<array.length;i++){
                       }//end if(angular.isObject(currentObject[metaData.columns[i].fieldName]))
                       if(!metaData.columns[i].optional || metaData.columns[i].min){
                           if(!currentObject[metaData.columns[i].fieldName]){
                               champs.push(metaData.columns[i].fieldLabel);
                           }//end if(!currentObject[metaData.columns[i].fieldName]){
                       }//end if(!metaData.columns[i].optional || metaData.columns[i].min)
                       //Construction des champs pour unicite
                       if(metaData.columns[i].unique==true){
                           var pred = new Object();
                           pred.fieldLabel = metaData.columns[i].fieldLabel;
                           pred.fieldName = metaData.columns[i].fieldName;
                           pred.value = currentObject[metaData.columns[i].fieldName];
                           $scope.uniqueContraints.push(pred);
                       }//end if(metaData.columns[i].unique){
                   }
                 }//end if($scope.metaData.columns){
                 //Cas des groups
                 if(metaData.groups){
                    for(var i=0;i<metaData.groups.length;i++){
//                        if($scope.metaData.groups[i].metaArray){
//                           //Nom du champs
//                           var key = metaData.groups[i].metaArray.fieldName;
//                           var array = currentObject[key];
//                           for(var i=0 ; i<array.length;i++){
//                                $scope.validateFields(metaData.groups[i].metaArray.metaData,array[i])
//                           }//end for(var i=0 ; i<array.length;i++){
//                        }//end if($scope.metaData.groups[i].metaArray){
                        //Cas des donnÃ©es normales
                        if(metaData.groups[i].columns){
                           for(var j=0 ; j<metaData.groups[i].columns.length;j++){
                               //Nom du champs
                                var key = metaData.groups[i].columns[j].fieldName;
                                //Traitement des Object
                                if(angular.isObject(currentObject[key])){
                                    var entity = currentObject[key];
                                    if(entity.id=='load'){
                                        currentObject[key]=null;
                                    }//end if(entity.id=='load')
                                }else if(angular.isArray(currentObject[key])){
                                    var array = currentObject[key];
                                    for(var i=0 ; i<array.length;i++){
                                        if(angular.isObject(array[i]) && array[i].id=='load'){
                                            array[i]=null;
                                        }//end if(array[i].id=='load')
                                    }//end for(var i=0 ; i<array.length;i++){
                                }//end if(angular.isObject(currentObject[key])){
                                if(metaData.groups[i].columns[j].optional==false || metaData.groups[i].columns[j].min>0){
                                      if(!currentObject[metaData.groups[i].columns[j].fieldName]){
                                         champs.push(metaData.groups[i].columns[j].fieldLabel);
                                      }//end if(!currentObject[metaData.columns[i].fieldName]){
                                     // champs.push($scope.metaData.groups[i].columns[j].fieldLabel);
                                }//end if(!metaData.groups[i].columns[j].optional || metaDat
                                //Construction des champs pour unicite
                                if(metaData.groups[i].columns[j].unique==true){
                                     var pred = new Object();
                                      pred.fieldLabel = metaData.groups[i].columns[j].fieldLabel;
                                      pred.fieldName = metaData.groups[i].columns[j].fieldName;
                                      pred.value = currentObject[metaData.groups[i].columns[j].fieldName];
                                      $scope.uniqueContraints.push(pred);                                      
                                }//end if(metaData.groups[i].columns[j].unique){
                           }//end for(var j=0 ; j<metaData.groups[i].columns.length;j++){
                        }//end if(metaData.groups[i].columns){
                    }//end for(var i=0;i<metaData.groups.length;i++){
                 }//end if(metaData.groups){
            }
            return champs;

       };

        /**
       * 
       * @param {type} name:Identifiant de la modele de rapport
       * @returns {undefined}
       */
      $scope.customPrintAction = function(id , template){
          $scope.showreporttitle = true;
          $scope.reporttitle = null;
          if(id){
              commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
              var url='http://'+$location.host()+":"+$location.port()+"/kerencore/reportrecord/byid/id/"+id;
              $http.get(url)
                      .then(function(response){
                          var report = response.data;
                          $scope.reporttitle = report.titre;
                          $scope.windowType = "report";
                          if(report.model&&report.entity){
                                var url_1 = 'http://'+$location.host()+":"+$location.port()+"/"+angular.lowercase(report.model)+"/"+angular.lowercase(report.entity)+"/meta";
//                                console.log("principal.customPrintAction ========================== url : "+url_1+" == = report title : "+$scope.reporttitle);
                                $http.get(url_1)
                                        .then(function(response){
                                              var meta = response.data;
                                              $rootScope.$broadcast("customreport" , {metaData:meta,report:report,template:template});      
//                                              console.log(angular.toJson(meta)+" === "+report.model+" === "+report.entity);                                              
                                              commonsTools.hideDialogLoading();
                                        },function(error){
                                            commonsTools.hideDialogLoading();
                                            commonsTools.showMessageDialog(error);
                                        });
                          }else{                              
                              $scope.displayReportPanel(report.script,report);
                              commonsTools.hideDialogLoading();
                          }//end if(report.model&&report.entity)                          
                      },function(error){
                          commonsTools.hideDialogLoading();
                          commonsTools.showMessageDialog(error);
                      });
          }//end if(name)
      };
      /**
       * Remove the nodes fill on node
       * @param {type} nodes
       * @returns {undefined}
       */
      $scope.cleanTreeNodes = function(nodes){
          for(var i=0 ; i<nodes.length;i++){
              var node = nodes[i];
              if(node.nodes.length>0){
                  $scope.cleanTreeNodes(node.nodes);
              }else{
                  delete node.nodes;
              }//end if(node.nodes.length>0){
          }//end for(var i=0 ; i<nodes.length;i++){
      };
      /**
       * 
       * @param {type} item
       * @returns {undefined}
       */
      $scope.loadTreeData = function(item){
          $http.defaults.headers.common['userid']= $rootScope.globals.user.id;   
                      $http.defaults.headers.common['search_text']= $scope.searchCriteria;  
                      restService.treefilter($scope.predicats ,$scope.pagination.beginIndex , $scope.pagination.pageSize)
                               .$promise.then(function(datas){                                    
                                    if(datas){
                                        $scope.datas = datas;       
                                        $scope.cleanTreeNodes($scope.datas);
//                                        console.log("principal.loadTreeData = function(item) ======= "+angular.toJson($scope.datas));
                                        if($scope.pagination.beginIndex<=0){
                                            $scope.pagination.endIndex = $scope.pagination.pageSize;
                                            if($scope.pagination.totalPages<=$scope.pagination.pageSize){
                                                $scope.pagination.endIndex=$scope.pagination.totalPages;
                                            }//end if($scope.pagination.totalPages<=$scope.pagination.pageSize){
                                        }//end if($scope.pagination.beginIndex<=0){
                                        $scope.pagination.hasnext();
                                        $scope.pagination.hasprevious();
                                        $rootScope.$broadcast("dataLoad" , {
                                            message:"dataLoad",item:item
                                        });
                                        commonsTools.hideDialogLoading();
                                    }
                               } ,function(error){
                                   commonsTools.hideDialogLoading();
                                   commonsTools.showMessageDialog(error);
                               });  
      };
       /**  
               Chargement des donnees 
               Rafresh the data from the data store
       **/
       $scope.loadData = function(item){
           //Chargement des donnees
                //restService.url('societe');
//               console.log('$scope.loadData = function() ::::::::::::::::'+$scope.pagination.currentPage+"==== "+$scope.pagination.totalPages+" ==== "+angular.isNumber($scope.pagination.totalPages));
               try{   /**var pageBeginIndex = $scope.pagination.currentPage - $scope.pagination.pageSize;
                      if(pageBeginIndex<0){
                          pageBeginIndex = 0;
                      }   **/       
                      $http.defaults.headers.common['userid']= $rootScope.globals.user.id;   
                      $http.defaults.headers.common['search_text']= $scope.searchCriteria;  
                      restService.filter($scope.predicats ,$scope.pagination.beginIndex , $scope.pagination.pageSize)
                               .$promise.then(function(datas){                                    
                                    if(datas){
                                        $scope.datas = datas;
                                //Traitement des donnÃ©es
                                       if($scope.calendarrecord){
                                            for(var i=0;i<datas.length;i++){
                                               var data = datas[i];
                                               if($scope.calendarrecord.titlefield){
                                                   data['title'] = data[$scope.calendarrecord.titlefield];
                                               }
                                               if($scope.calendarrecord.startfield){
                                                   data['start'] = data[$scope.calendarrecord.startfield];
                                               }
                                               if($scope.calendarrecord.endfield){
                                                   data['end'] = data[$scope.calendarrecord.endfield];
                                               }
                                               data['allDay'] = $scope.calendarrecord.allday;
                                            }//end for(var i=0;i<datas.length;i++){
                                            $scope.eventSources = [datas];
                                        }//end if($scope.calendarrecord)
                                        if($scope.pagination.beginIndex<=0){
                                            $scope.pagination.endIndex = $scope.pagination.pageSize;
                                            if($scope.pagination.totalPages<=$scope.pagination.pageSize){
                                                $scope.pagination.endIndex=$scope.pagination.totalPages;
                                            }//end if($scope.pagination.totalPages<=$scope.pagination.pageSize){
                                        }//end if($scope.pagination.beginIndex<=0){
                                        $scope.pagination.hasnext();
                                        $scope.pagination.hasprevious();
                                        $rootScope.$broadcast("dataLoad" , {
                                            message:"dataLoad",item:item
                                        });
                                        commonsTools.hideDialogLoading();
                                    }
                               } ,function(error){
                                   commonsTools.hideDialogLoading();
                                   commonsTools.showMessageDialog(error);
                               });  
                      
//                      for(var i=0 ; i<$scope.predicats.length;i++){
//                         console.log($scope.predicats[i].fieldName+" ==== "+$scope.predicats[i].fieldValue);
//                      }
               }catch(ex){
                    commonsTools.hideDialogLoading();
                    commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+ex.message,"danger");
                }              
       };
       /**
        * 
        * @returns {undefined}
        */
       $scope.loadDataSearch = function(){
           //Chargement des donnees
                //restService.url('societe');
//               console.log('$scope.loadData = function() ::::::::::::::::'+$scope.pagination.currentPage+"==== "+$scope.pagination.totalPages+" ==== "+angular.isNumber($scope.pagination.totalPages));
               try{   /**var pageBeginIndex = $scope.pagination.currentPage - $scope.pagination.pageSize;
                      if(pageBeginIndex<0){
                          pageBeginIndex = 0;
                      }   **/       
                      $http.defaults.headers.common['userid']= $rootScope.globals.user.id;   
                      $http.defaults.headers.common['search_text']= $scope.searchCriteria;  
                      restService.filter($scope.predicats ,$scope.pagination.beginIndex , $scope.pagination.pageSize)
                               .$promise.then(function(datas){                                    
                                    if(datas){
                                        $scope.datas = datas;
                                //Traitement des donnÃ©es
                                       if($scope.calendarrecord){
                                            for(var i=0;i<datas.length;i++){
                                               var data = datas[i];
                                               if($scope.calendarrecord.titlefield){
                                                   data['title'] = data[$scope.calendarrecord.titlefield];
                                               }
                                               if($scope.calendarrecord.startfield){
                                                   data['start'] = data[$scope.calendarrecord.startfield];
                                               }
                                               if($scope.calendarrecord.endfield){
                                                   data['end'] = data[$scope.calendarrecord.endfield];
                                               }
                                               data['allDay'] = $scope.calendarrecord.allday;
                                            }//end for(var i=0;i<datas.length;i++){
                                            $scope.eventSources = [datas];
                                        }//end if($scope.calendarrecord)
                                        if($scope.pagination.beginIndex<=0){
                                            $scope.pagination.endIndex = $scope.pagination.pageSize;
                                            if($scope.pagination.totalPages<=$scope.pagination.pageSize){
                                                $scope.pagination.endIndex=$scope.pagination.totalPages;
                                            }//end if($scope.pagination.totalPages<=$scope.pagination.pageSize){
                                        }//end if($scope.pagination.beginIndex<=0){
                                        $scope.pagination.hasnext();
                                        $scope.pagination.hasprevious();                                       
                                        commonsTools.hideDialogLoading();
                                    }
                               } ,function(error){
                                   commonsTools.hideDialogLoading();
                                   commonsTools.showMessageDialog(error);
                               });  
                      
//                      for(var i=0 ; i<$scope.predicats.length;i++){
//                         console.log($scope.predicats[i].fieldName+" ==== "+$scope.predicats[i].fieldValue);
//                      }
               }catch(ex){
                    commonsTools.hideDialogLoading();
                    commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+ex.message,"danger");
                }              
       };
       /**
        * 
        * @param {type} model
        * @param {type} item
        * @param {type} entityName
        * @param {type} moduleName
        * @returns {undefined}
        */
       $scope.saveonly = function(model ,item ,entityName,moduleName,link){
//           console.log("$scope.saveonly = function(model ,item ,entityName,moduleName) ==== "+link);
           commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
           var urlPath = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(moduleName)+"/"+angular.lowercase(entityName)+"/";
           $http.post(urlPath,item).then(
                function(response){
                   if(angular.isDefined(link)&& link!=null && link!=''){
                       var urlPah=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/menuaction/bystringproperty/name/"+link;
                       $http.get(urlPah)
                               .then(function(response){
//                                   console.log("$scope.saveonly = function(model ,item ,entityName,moduleName,link) ===== "+angular.toJson(response.data));
                                   commonsTools.hideDialogLoading();
//                                   commonsTools.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success");     
                                   if(response.data.length>0){
                                     $rootScope.$broadcast("currentActionUpdate" ,{
                                     action:response.data[0] , verticalMenu:$scope.enabledVerticalMenu,index:0});  
                                   }//nd if(response.data.length>0)                                   
                               },function(error){
                                   commonsTools.hideDialogLoading();
                                     commonsTools.showMessageDialog(error);
                               });
                   }else{
                        commonsTools.hideDialogLoading();
                        commonsTools.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success");     
                   }//end if(angular.isDefined(link))
                },
              function(error){
               commonsTools.hideDialogLoading();
               commonsTools.showMessageDialog(error);
           } );
       };
       
       /**
        * Sauvegarde une entity et recharge 
        * @param {type} model
        * @param {type} item
        * @param {type} entityName
        * @param {type} moduleName
        * @returns {undefined}
        */
       $scope.saveanrelaod = function(model ,item ,entityName,moduleName,modelpath){
           commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
           var urlPath = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(moduleName)+"/"+angular.lowercase(entityName)+"/";
           $http.post(urlPath,item).then(
                function(response){
                   urlPath = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(moduleName)+"/"+angular.lowercase(entityName)+"/byid/compareid/"+item.compareid;
                   $http.get(urlPath).then( 
                      function(response){
                           var modelentity = $scope.getParentModel(modelpath);
                           var parts = model.split('.');
                           modelentity = modelentity[parts[parts.length-1]];
//                           console.log("principal.saveanrelaod ======================= model : "+model+" ==== modelpath :"+modelpath+" ==== model ref :"+angular.toJson(modelentity));
                           if(angular.isArray(modelentity)){
                               modelentity.push(response.data);
                           }else{
                               modelentity = response.data;
                           }//end if(angular.isArray(modelentity)){
                           //alert("Data: "+data+" \nStatus: "+status);   
//                           var parts = model.split(".");
//                           var key = commonsTools.keygenerator(model);
//                           if(parts.length>1){
//                               $scope.dataCache[""+key+""] = new Array();
//                               //var data = $scope.dataCache[""+parts[1]+""];
//                               for(var i=0;i<response.data.length;i++){
//                                    $scope.dataCache[""+key+""].push(response.data[i]);
//                                }                         
//                           }
                            $timeout(function() {
                                $('.selectpicker').selectpicker('refresh');

                            });
                           commonsTools.hideDialogLoading();
                     },
                     function(error){
                        commonsTools.hideDialogLoading();
                        commonsTools.showMessageDialog(error);
                   } );
              },
              function(error){
               commonsTools.hideDialogLoading();
               commonsTools.showMessageDialog(error);
           } );
           //console.log("$scope.getData ===      "+model+" === "+entityName+" ==== "+moduleName+" === "+item);
       };
        /**
        * Managed link component
        * Applied filter on one commponent
        * @returns {undefined}
        */
       $scope.buildFilter = function(model){
         try{
           var metaData = $scope.getCurrentMetaData(model);
           var key = commonsTools.keygenerator(model); 
           if($scope.filtertemplate[key]){
               var filtres = angular.fromJson($scope.filtertemplate[key]);
               var predicats = new Array();
               for(var i=0;i<filtres.length;i++){
                   var predicat = new Object();
                   predicat["fieldName"] = filtres[i].fieldName;
                   predicat["fieldLabel"] = null ;
                   predicat["type"]="==";
                   var field = $scope.getField(metaData,filtres[i].fieldName);
//                   console.log("$scope.buildFilter ======================= fieldName : "+filtres[i].fieldName+" ==== model : "+model+" === filter : "+$scope.filtertemplate[key]+" ===== field : "+angular.toJson(field)+" === meta : "+angular.toJson(metaData));                   
                   predicat["target"] = field.type;
                   if(filtres[i].operator!=null){
                       predicat["type"]=filtres[i].operator ;
                   }//end if(filtres[i].operator!=null){
                   predicat["searchfields"]=null;
                   if(filtres[i].searchfield && field.type==='object'){
                       predicat["searchfields"]=[filtres[i].searchfield];
                   }//end if(filtres[i].searchfield){
                   //Traitement de la valeur
                    var value = filtres[i].value;
                    if(angular.isString(filtres[i].value)){
                        var part = filtres[i].value.split('.');
                        var par = model.split('.');                   
     //                   if(part.length<=1&&part.length>0){
     //                       value=part[0];                                       
     //                   }else 
                       if(part[0]==="object"){
                           var obj = $scope.getParentModel(model);
                           if(part.length>1){
                                obj = obj[part[1]];
                           }//end [part[1]]
                           if(obj && obj[filtres[i].searchfield]){
                                value=obj[filtres[i].searchfield];
                           }else if(angular.isDefined(filtres[i].optional)&&filtres[i].optional==false){
                             commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+filtres[i].message,"danger");
                             return false;
                           }//end if(obj && obj[filtres[i].searchfield]){
                      }else if(part[0]==="this"){
                          var obj = $scope.currentObject;
                          if(par[0]==='temporalData'){
                              obj = $scope.templateData;
                          }else if(par[0]==='dataCache'){
                              obj = $scope.dataCache;
                          }//end if(par[0]==='temporalData')
                          if(part.length>1){
                             obj = obj[part[1]];
                          }//end [part[1]]{
                          if(obj && obj[filtres[i].searchfield]){
                                value=obj[filtres[i].searchfield];
                          }else if(angular.isDefined(filtres[i].optional)&&filtres[i].optional==false){
                             commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+filtres[i].message,"danger");
                             return false;
                          }//end if(obj && obj[filtres[i].searchfield]){
                      }else if(part[0]==="user"){
                           var obj = $scope.currentUser[part[1]];
                           if(obj && obj[filtres[i].searchfield]){
                                value=obj[filtres[i].searchfield];
                            }else if(angular.isDefined(filtres[i].optional)&&filtres[i].optional==false){
                               commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+filtres[i].message,"danger");
                               return false;
                            }//end if(obj && obj[filtres[i].searchfield]){
                      }else if(part.length<=1&&part.length>0){
                          value=part[0];
                      }//end else if(part[0]=="object")
                   }//end  if(angular.isString(filtres[i].value)){
                   predicat["value"]=value;
                   predicats.push(predicat);
//                   console.log("$scope.buildFilter ======================= key : "+key+" ==== predicate : "+angular.toJson(predicats)+" === model:"+model+" ==== Champs : "+angular.toJson(field));
               }//end for(var i=0;i<filtres.length;i++)
//               console.log("$scope.buildFilter ======================= "+angular.toJson(predicats)+" === model:"+model);
               $http.defaults.headers.common['predicats']= angular.toJson(predicats); 
               return true;                  
           }else{
               predicats = new Array();
               $http.defaults.headers.common['predicats']= angular.toJson(predicats); 
               return true;
           }//end if($scope.filtertemplate)
         }catch (ex){
             //commonsTools.showMessageDialog(ex);
             commonsTools.showMessageDialog(ex);
         }
       };
       /**
        * 
        * @returns {undefined}
        */
       $scope.getComboboxData =function(fieldName){
            var observable = $scope.observablePools[fieldName];
            if(observable){
                observable.notifyObservers();
            }//end if(observable)
       };
       /**
        * 
        * @param {type} model
        * @param {type} meta
        * @returns {undefined}
        */
       $scope.keyupDataLoarder = function(model,text){
           var meta = $scope.getCurrentMetaData(model);
//           console.log("$scope.keyupDataLoarder ================ "+model+"======="+text+" ==== ");                        
             var status = $scope.buildFilter(model);
            if(status==false){
                return ;
            }//end if(status==false){  
            var key = commonsTools.keygenerator(model);
            commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");  
            $http.defaults.headers.common['live_search']= text; 
            var urlPath = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(meta.moduleName)+"/"+angular.lowercase(meta.entityName)+"/filter/0/5";
            $http.get(urlPath).then(
                    function(response){
                                    //alert("Data: "+response.data+" === "+model);   
                                    var parts = model.split(".");
                                    if(parts.length>1){
                                         var obj = {id:'load' , designation:'Charger plus ....'};
                    //                    if($scope.dataCache[parts[1]]&&$scope.dataCache[parts[1]].length>0){
                    //                        obj = {id:'loadwithsearch' , designation:'Chercher plus ...'};
                    //                    }
                                           $scope.dataCache[key] = new Array();                                                      
                                            //var data = $scope.dataCache[""+parts[1]+""];
//                                            if(response.data.length<=0){
//                                                
//                                            }//end if(response.data.length<=0){
                                            for(var i=0;i<response.data.length;i++){
                                                $scope.dataCache[key].push(response.data[i]);
                                            }//end for(var i=0;i<response.data.length;i++){
                                            if(response.data.length>=5){
                                              $scope.dataCache[""+key+""].push(obj);    
                                            }//end if(response.data.length>=5){
                                     }//end if(parts.length>1){
                                     //console.log($scope.dataCache[""+parts[1]+""]);
                                     $timeout(function() {
                                        $('.selectpicker').selectpicker('refresh');
                                     });
                                    commonsTools.hideDialogLoading();
                             },function(error){
                                 commonsTools.hideDialogLoading();
                                 commonsTools.showMessageDialog(error);
                             });
       };
        /**
         * 
         * @param {type} model
         * @param {type} item
         * @param {type} entityName
         * @param {type} moduleName
         * @returns {undefined}
         */
        $scope.getData = function(model ,item ,entityName,moduleName,index,modelpath){
//            console.log("$scope.getData = function(model ,item ,entityName,moduleName,index,modelpath)============ model : "+model+" ====== modelpath : "+modelpath+"  === ");            
            var status = $scope.buildFilter(model);
            if(status==false){
                return ;
            }//end if(status==false){   
            item = $scope.getCurrentModel(model);
            var modelpart = model.split(".");
            var fieldName = modelpart[modelpart.length-1];
            var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(moduleName)+"/"+angular.lowercase(entityName)+"/count";
            if(item.id=='load'){
                    $http.get(url)
                            .then(function(response){
                                var data = response.data;
                                 if(data.value<=5){
                                       var parts = model.split(".");
                                        if(parts.length>1){
                                            var key = commonsTools.keygenerator(model);
                                            var array = $scope.dataCache[key];
                                            var obj = array[array.length-1];               
                                            if(item.id == "load"){       
                                                commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");  
                                                 //Chargement des donnÃ¯Â¿Â½es
                                                 var urlPath = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(moduleName)+"/"+angular.lowercase(entityName)+"/filter/0/10";
                                                 $http.get(urlPath).then( 
                                                   function(response){
                                                        //alert("Data: "+response.data+" === "+model);   
                                                        var parts = model.split(".");
                                                        if(parts.length>1){
                                                             var obj = {id:'load' , designation:'Charger les donnÃ©es ....'};
                                        //                    if($scope.dataCache[parts[1]]&&$scope.dataCache[parts[1]].length>0){
                                        //                        obj = {id:'loadwithsearch' , designation:'Chercher plus ...'};
                                        //                    }
                                                               $scope.dataCache[key] = new Array();                                                      
                                                                //var data = $scope.dataCache[""+parts[1]+""];
                                                                if(response.data.length<=0){
                                                                    $scope.dataCache[""+key+""].push(obj);
                                                                }//end if(response.data.length<=0){
                                                                for(var i=0;i<response.data.length;i++){
                                                                    $scope.dataCache[key].push(response.data[i]);
                                                                }//end for(var i=0;i<response.data.length;i++){       
        //                                                        
                                                         }//end if(parts.length>1){
                                                         //console.log($scope.dataCache[""+parts[1]+""]);
                                                         $timeout(function() {
                                                            $('.selectpicker').selectpicker('refresh');
                                                         });
                                                        commonsTools.hideDialogLoading();
                                                 },function(error){
                                                     commonsTools.hideDialogLoading();
                                                     commonsTools.showMessageDialog(error);
                                                 });
                                          }//end if(obj.id == "load")
                                      }//end if(parts.length>1)
                                      var observable = $scope.observablePools[fieldName];
                                      if(observable){
                                          observable.notifyObservers();
                                      }//end if(observable)
                                  }else{         
                                        $scope.listDialogBuilder(model,index,modelpath);
                                        var modalID = "";
                                        var endIndex = index;
                                        if(endIndex==1){
                                            modalID = "myModal";
                                        }else if(endIndex==2){
                                             modalID = "globalModal";
                                        }else if(endIndex==3){
                                             modalID = "myModal1";
                                        }else if(endIndex==4){
                                             modalID = "myModal2";
                                        }//end if(endIndex==1)
                                        $("#"+modalID).modal("toggle");
                                        $("#"+modalID).modal("show");
                                 }//end if(data.value<=$scope.pagination.pageSize)
                            },function(error){
                                 commonsTools.hideDialogLoading();
                                 commonsTools.showMessageDialog(error);
                            });
                     }else{
                         var observable = $scope.observablePools[fieldName];
//                         console.log("$scope.getData ===      "+model+" ==== "+item+" === "+entityName+" ==== "+moduleName+" === "+fieldName+" == "+angular.toJson($scope.observablePools[fieldName])+"  ::: index : "+index);
                         if(observable){
                            observable.notifyObservers();
                         }//end if(observable)
                     }//end if(item.id=='load'){
           
        };

       /**
        * 
        * @param {type} model
        * @param {type} entityName
        * @param {type} moduleName
        * @returns {undefined}
        */
        $scope.getData2 = function(model ,entityName,moduleName){
//            console.log("$scope.getData2 ===      "+model+" === "+entityName+" ==== "+moduleName+" === ");
            var parts = model.split(".");
            if(parts.length>1){
                $scope.dataCache[""+parts[1]+""] = new Array();                
                    //var obj = array[array.length-1];                   
                    commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");               
                     //Chargement des donnÃ¯Â¿Â½es
                     var urlPath = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(moduleName)+"/"+angular.lowercase(entityName)+"/filter/"+$scope.temporalPagination.beginIndex+"/"+$scope.temporalPagination.pageSize;
                     $http.get(urlPath).then( 
                       function(response){
                            //alert("Data: "+response.data+" === "+model);   
                             var parts = model.split(".");
                             if(parts.length>1){
//                                    $scope.dataCache[""+parts[1]+""] = new Array();
                                //var data = $scope.dataCache[""+parts[1]+""];
                                for(var i=0;i<response.data.length;i++){
                                    $scope.dataCache[""+parts[1]+""].push(response.data[i]);
                                }//end for(var i=0;i<response.data.length;i++){                        
                             }//end if(parts.length>1){
                             //console.log($scope.dataCache[""+parts[1]+""]);
                             $timeout(function() {
                                $('.selectpicker').selectpicker('refresh');
                             });
                            commonsTools.hideDialogLoading();
                     },function(error){
                         commonsTools.hideDialogLoading();
                         commonsTools.showMessageDialog(error);
                     });
                 }   
                    
            
                

        };
       /**
         reinitialise les donnÃ©es temporaires
       **/
        $scope.reset = function(){
           $scope.temporalDatas = [];
           $scope.tableheaderselected= false;
           $scope.temporalData = {};
           $scope.temporalModel = {};
           $scope.currentObject = {};
           $scope.resourcesCache = {};    
//           $scope.dataCache = {};
           if($scope.selectedObjects){
             for(var i=0;i<$scope.selectedObjects.length;i++){
                $scope.selectedObjects[i].selected = false;
             }//end for(var i=0;i<$scope.selectedObjects.length;i++){
           }//end if($scope.selectedObjects){
           $scope.selectedObjects = [];
        };
        
        /**
         * 
         * @returns {undefined}
         */
        $scope.addNewCalendar = function(){
            var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
            if(session==null){
                $scope.deconnexion();
                return;
            }//end if(session==null){
           $scope.windowType = 'new';
           //Mise a jour des tempons
            $scope.reset();
            $scope.suffixedittitle = 'Nouveau';
           //alert($scope.currentObject.actions);          
           $scope.displayEditPanel();
           
          //console.log(viewElem.innerHTML);
           
        };

          /**
              Mise a jour 
          **/
        $scope.addElementAction = function(){
           $scope.windowType = 'new';
           //Mise a jour des tempons
            $scope.reset();
           $scope.createEmptyObject($scope.metaData,$scope.templateData);
           $scope.suffixedittitle = 'Nouveau';
           //alert($scope.currentObject.actions); 
           var modes =['tree','form'];
           if(angular.isDefined($scope.currentAction.viewMode)){
               modes = $scope.currentAction.viewMode.split(',');
           }//end if(angular.isDefined($scope.currentAction.viewMode)){
           if(modes[0]=='tree'&&modes.length==1){
                $scope.windowType = 'list';
               if($scope.datas.length==0 
                       ||$scope.datas[0].id>0){
                   var now = new Date();
//                   $scope.currentObject.id = now.getTime();
                   $scope.datas.unshift($scope.currentObject);
               }else{
                   $scope.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>Veuillez enregistrer la ligne courante et rÃ©essayer","danger");
               }//end if($scope.datas.length==0 
           }else{
               $scope.displayEditPanel();
           }//end if(modes[0]=='tree'&&modes.length==1){
           
          //console.log(viewElem.innerHTML);
           
        };

          /**
                 Enregistrement en BD

          **/
          $scope.saveOrUpdate = function(){
               //On affiche le dialog
               commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
              try{  
                     var validate = $scope.validateFields($scope.metaData , $scope.currentObject);
//                     console.log("$scope.saveOrUpdate === "+$scope.windowType+" ====== "+angular.toJson($scope.currentObject));
                     if($scope.pagination.totalPages>0){
                         $scope.pagination.currentPage = $scope.pagination.beginIndex+1;
                     }else{
                         $scope.pagination.currentPage = 0;
                     }//end if($scope.pagination.totalPages>0)                 
                     if(validate.length>0){
                        var message = "";
                        for(var i=0; i<validate.length;i++){
                            message = message+"<br/>"+validate[i];
                        }//end for(var i=0; i<validate.length;i++)
                        commonsTools.hideDialogLoading();
                        $scope.notifyWindow("Les champs suivants sont incorrects" ,message,"danger");                        
                     }else{
                        if($scope.windowType=='update'){
                           restService.update($scope.currentObject).$promise
                             .then(function(entity){ 
                                        //Reinitialisation du context
//                                        $scope.reset();
                                        //Rechargement des donnÃ©es
                                         $scope.windowType = 'view';
                                         $scope.selectedObjects = [];         
                                        $scope.currentObject = entity;
                                        var index = commonsTools.getIndex($scope.datas,$scope.currentObject);
                                        if(angular.isDefined(index)){
                                            $scope.pagination.currentPage = $scope.pagination.beginIndex+index+1;
                                        }//end if(angular.isDefined(index))
                                        $scope.suffixedittitle = $scope.currentObject.designation;
                                         //Cas exceptionnel des application
                                        if($scope.showApplication==true){
                                            //alert(angular.toJson($scope.currentObject));
                                            if($scope.currentObject.active){
                                                $scope.exportbtnlabel = "Desinstaller";
                                            }else{
                                                $scope.exportbtnlabel = "Installer";
                                            }//end if($scope.currentObject.active){
                                        }//end if($scope.showApplication==true){                                       
    //                                    $scope.loadData();
                                        commonsTools.hideDialogLoading();
                                        $scope.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success");
                                        if($scope.dataCache['resources']&&$scope.dataCache['resources'].length>0){
                                            for(var i=0 ; i<$scope.dataCache['resources'].length;i++){
                                                var arrayR = $scope.dataCache['resources'];
                                                var arrayN = $scope.dataCache['names'];
                                                var resource = new Array();
                                                var name = new Array();
                                                resource.push(arrayR[i]);
                                                name.push(arrayN[i]);
                                                $http.defaults.headers.common['names']= angular.toJson(name); 
                                                restService.uploadFile(resource)
                                                    .then(function(response){
//                                                        alert(angular.toJson(response))
                                                          if(i==($scope.dataCache['resources'].length-1)){
                                                            $scope.dataCache['resources'] = new Array();
                                                            $scope.dataCache['names'] = new Array();
                                                          }//end if(i==($scope.dataCache['resources'].length-1)){
                                                           $scope.displayEditPanel();
                                                    },function(error){
                                                        if(i==($scope.dataCache['resources'].length-1)){
                                                            $scope.dataCache['resources'] = new Array();
                                                            $scope.dataCache['names'] = new Array();
                                                          }//end if(i==($scope.dataCache['resources'].length-1)){
                                                           $scope.displayEditPanel();
                                                        $scope.notifyWindow("ERREUR" ,"Le transfert des ressources a Ã©chouÃ© <br> Veuillez consulter les logs pour plus de dÃ©tails","warning");
                                                    });
                                            }//end for(var i=0 ; i<$scope.dataCache['resources'].length;i++)                                               
                                        }else{
                                             $scope.displayEditPanel();
                                        }//end if($scope.dataCache['resource']&&$scope.dataCache['resource'].length>0)
                          },function(error){
                              commonsTools.hideDialogLoading();
                              commonsTools.showMessageDialog(error);
                          });          
                        }else if($scope.windowType=='new'){
                                restService.uniqueProperties($scope.uniqueContraints).$promise.then(function(response){
                                if(response&&response.length>0){
                                    var message ="";
                                    for(var i=0; i<response.length;i++){
                                        message = message+"<br/>"+response[i].fieldLabel;
                                    }//end for(var i=0; i<response.length;i++){
                                    $scope.notifyWindow("Les champs suivants violent la contrainte d'unicitÃ©e" ,message,"danger");
                                    commonsTools.hideDialogLoading();
                                }else{
                                    delete $scope.currentObject.id;
                                    restService.save($scope.currentObject)
                                            .$promise.then(function(entity){
//                                         console.log("$scope.saveOrUpdate === Constraint result inner2 ==================="+$scope.windowType+" === contraints : "+angular.toJson($scope.currentObject));
                                        //Reinitialisation du context
                                          //Rechargement des donnÃ©es
//                                          $http.defaults.headers.common['names']= angular.toJson($scope.dataCache['names']); 
                                            restService.findByCompareid($scope.currentObject.compareid)
                                               .$promise.then(function(data){
//                                                    $scope.pagination.currentPage=1;
//                                                   $scope.pagination.totalPages = data.value ;                                                  
//                                                    //$scope.metaData = metaData;                                        
//                                                    $scope.searchCriteria = new String();               
                                                    //$scope.listFramePanelBuilder(metaData);
//                                                    $scope.loadData();
//                                                    $scope.reset();
                                                      $scope.predicats = new Array();                                                    
                                                    $scope.windowType = 'view';
                                                    $scope.selectedObjects = [];     
                                                    $scope.currentObject = data;
                                                    var index = commonsTools.getIndex($scope.datas,$scope.currentObject);
                                                    if(angular.isDefined(index)){
                                                        $scope.pagination.currentPage = $scope.pagination.beginIndex+index+1;
                                                    }//end if(angular.isDefined(index))
                                                    $scope.suffixedittitle = $scope.currentObject.designation;
                                                     //Cas exceptionnel des application
                                                    if($scope.showApplication==true){
                                                        //alert(angular.toJson($scope.currentObject));
                                                        if($scope.currentObject.active){
                                                            $scope.exportbtnlabel = "Desinstaller";
                                                        }else{
                                                            $scope.exportbtnlabel = "Installer";
                                                        }//end if($scope.currentObject.active){
                                                    }//end if($scope.showApplication==true){
                                                    //Mise a jour de la pagination
                                                    restService.count($scope.predicats)
                                                          .$promise.then(function(data){                                                               
                                                               $scope.pagination.totalPages = data.value ;    
                                                               $scope.pagination.currentPage= $scope.pagination.totalPages;
                                                          }
                                                          , function(error){
                                                              commonsTools.hideDialogLoading();
                                                              commonsTools.showMessageDialog(error);
                                                          });  
                                                    $scope.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success"); 
                                                    if($scope.dataCache['resources']&&$scope.dataCache['resources'].length>0){
                                                        for(var i=0 ; i<$scope.dataCache['resources'].length;i++){
                                                            var arrayR = $scope.dataCache['resources'];
                                                            var arrayN = $scope.dataCache['names'];
                                                            var resource = new Array();
                                                            var name = new Array();
                                                            resource.push(arrayR[i]);
                                                            name.push(arrayN[i]);
                                                            $http.defaults.headers.common['names']= angular.toJson(name); 
                                                            restService.uploadFile(resource)
                                                                .then(function(response){
            //                                                        alert(angular.toJson(response))
                                                                      $scope.displayEditPanel();                                                   
                                                                      if(i==($scope.dataCache['resources'].length-1)){
                                                                        $scope.dataCache['resources'] = new Array();
                                                                        $scope.dataCache['names'] = new Array();
                                                                      }//end if(i==($scope.dataCache['resources'].length-1))
                                                                      $scope.displayEditPanel();
                                                                },function(error){
                                                                    if(i==($scope.dataCache['resources'].length-1)){
                                                                        $scope.dataCache['resources'] = new Array();
                                                                        $scope.dataCache['names'] = new Array();
                                                                    }//end if(i==($scope.dataCache['resources'].length-1))
                                                                    $scope.displayEditPanel();
                                                                    $scope.notifyWindow("ERREUR" ,"Le transfert des ressources a Ã©chouÃ© <br> Veuillez consulter les logs pour plus de dÃ©tails","success");
                                                                });
                                                        }//end for(var i=0 ; i<$scope.dataCache['resources'].length;i++)
                                                    }else {
                                                        $scope.displayEditPanel();                                                    
                                                    }//end if($scope.dataCache['resource']&&$scope.dataCache['resource'].length>0)
                                              }
                                              , function(error){
                                                  commonsTools.hideDialogLoading();
                                                  commonsTools.showMessageDialog(error);                                        
                                                    
                                            });                                            
                                          //$scope.displayListPanel();
                                          commonsTools.hideDialogLoading();
                                           
                                    },function(error){
                                        commonsTools.hideDialogLoading();
                                        commonsTools.showMessageDialog(error);
                                    });     
                                //end of the insertion
                              }   
                            } , function(error){
                                  commonsTools.hideDialogLoading();
                                  commonsTools.showMessageDialog(error);
                            });
                                   
                        }
                         //Reinitialisation du context
                        //$scope.reset();
                        //Rechargement des donnÃ©es
                        //$scope.displayListPanel();                           
                     }   
                    
                }catch(ex){
                    //$scope.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+ex.message,"danger");
                     commonsTools.hideDialogLoading();
                     commonsTools.showMessageDialog(ex);
                     //console.log(ex.message);
                }        
            
          };
          
          /**
           * Dupliquer the current object
           * @returns {undefined}
           */
          $scope.dupliquerAction = function(item){ 
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
               if(angular.isDefined(item)){
                   if(!$scope.isEditableList()){
                       $scope.viewAction(item);
                   }//end if(!$scope.isEditableList()){
               }//end if(angular.isDefined(item)){
              $scope.dataCache['resources'] = new Array();
               $scope.dataCache['names'] = new Array();
               $scope.windowType = 'new';               
                //Recuperation du premier element
                var clone = new Object();
                if(angular.isDefined(item)){
                    $scope.currentObject = item;
                }//end if(angular.isDefined(item)){
               angular.copy($scope.currentObject,clone)
               delete clone.id ;
               var today = new Date();
               clone.compareid = today.getTime();
               clone.id = -1;
               $scope.currentObject = clone ;
               $scope.selectedObjects = [];
               //Chargement rafresh data from server
               $scope.suffixedittitle = $scope.currentObject.designation;                   
               //$scope.currentObject = restService.findById($scope.currentObject.code);
               //$scope.createEmptyObject($scope.metaData);
               if(!$scope.isEditableList()){
                   $scope.displayEditPanel();    
               }else{
                  if($scope.datas.length==0
                          ||$scope.datas[0].id>0){
                     $scope.datas.unshift($scope.currentObject);
                  }else{
                      $scope.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>Veuillez enregistrer la ligne courante et rÃ©essayer","danger");
                  }//end if($scope.datas.length==0
               }//end if(!$scope.isEditableList())
                         
          };

//          /**
//               Update 
//          **/
          $scope.updateAction = function(item){
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){     
               if(angular.isDefined(item)){
                   $scope.viewAction(item);
               }//end if(angular.isDefined(item)){ 
               $scope.dataCache['resources'] = new Array();
               $scope.dataCache['names'] = new Array();
               $scope.windowType = 'update';
               if($scope.showApplication==false){
                    //Recuperation du premier element
                   if($scope.selectedObjects.length>0){
                       $scope.currentObject = $scope.selectedObjects[0];
                   }//end if($scope.selectedObjects.length>0){
                   $scope.selectedObjects = [];
                   //Chargement rafresh data from server
                   $scope.suffixedittitle = $scope.currentObject.designation;                   
                   //$scope.currentObject = restService.findById($scope.currentObject.code);
                   //$scope.createEmptyObject($scope.metaData);
                   if(!$scope.isEditableList()){
                       $scope.displayEditPanel();
                   }else{
                       $scope.saveOrUpdateEditableListtAction(item);
                   }//end if(!$scope.isEditableList()){
               }else{
                   //Traitement des modules
                   if($scope.currentObject.active==true){
                       //Mise a jour de l'installation
                      $scope.installApplication();
                   }else{
                       //Mise a jour des informations du repertoires addons
                        $scope.updateApplication();
                   }//end if($scope.currentObject.active==true){
               }//end if($scope.showApplication==false)
               //console.log("Vous avez cliquez sur  Update : "+$scope.currentObject.name+" ::::: "+$scope.currentObject.shortDescription);              
          };
          /**
           * 
           * @returns {undefined}Back to Preview View
           */
          $scope.backAction = function(){
//              console.log("principal.backAction ==================================== "+angular.toJson($scope.navigatorcontainer.getMementos()));
              var memento = $scope.navigatorcontainer.gotoPreview();
//              console.log("principal.backAction ==================================== "+angular.toJson(memento));
               $scope.getActionByName(memento.action,null,null,memento.item);               
          };           
          /**
           * 
           * @param {type} item
           * @returns {undefined}
           */
          $scope.viewAction = function(item){
//                console.log("$scope.viewAction ============== "+angular.toJson(item));
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
                commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                $scope.windowType = 'view';               
                $scope.selectedObjects = [];               
                //Recuperation du premier element
                $scope.currentObject = item;
                var index = commonsTools.getIndex($scope.datas,item);
                if(angular.isDefined(index)){
                    $scope.pagination.currentPage = $scope.pagination.beginIndex+index+1;
                }//end if(angular.isDefined(index))
                $scope.suffixedittitle = $scope.currentObject.designation;
                 //Cas exceptionnel des application
                if($scope.showApplication==true){
                    //alert(angular.toJson($scope.currentObject));
                    if($scope.currentObject.active){
                        $scope.exportbtnlabel = "Desinstaller";
                    }else{
                        $scope.exportbtnlabel = "Installer";
                    }//end if($scope.currentObject.active){
                }//end if($scope.showApplication==true){
//                console.log("principal.viewAction ==================== "+angular.toJson(item));
                if(commonsTools.isexternemodule($scope.currentModule.name)){
                    if(item.ownermodule && item.ownermodule!= $scope.currentModule.name){
                        $http.defaults.headers.common['modulename']= item.ownermodule;       
                    }else{
                        $http.defaults.headers.common['modulename']= $scope.currentModule.name;       
                    }//end if($scope.item.ownermodule){
                }else{
                    $http.defaults.headers.common['modulename']= null;
                }//end if(commonsTools.isexternemodule($scope.currentModule.name)){
                restService.findById(item.id).$promise
                        .then(function(data){
                            $scope.currentObject = data;
                            //Cacher la navigation
                            $scope.navigatorcontainer.addRule($scope.currentAction.name,data.id,data.designation);
//                            console.log("$scope.viewAction ============== "+angular.toJson(data));
                            $scope.displayEditPanel();
//                            console.log("$scope.viewAction after display ============== "+angular.toJson(data));
                            commonsTools.hideDialogLoading();
                },function(error){
                     commonsTools.hideDialogLoading();
                     commonsTools.showMessageDialog(error);
                } );
                //refresh data from data store
                //$scope.currentObject = restService.findById($scope.currentObject.code);         
               //$scope.createEmptyObject($scope.metaData);               
          };

/**
 * 
 * @param {type} id
 * @returns {undefined}
 */
          $scope.viewbyIDAction = function(id){
//                console.log("$scope.viewAction ============== "+angular.toJson(id));
                commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                $scope.windowType = 'view';
                $scope.selectedObjects = [];     
                 restService.findById(id).$promise
                        .then(function(data){
                            $scope.currentObject = data;   
                            if($scope.currentObject.ownermodule && $scope.currentObject.ownermodule!= $scope.currentModule.name){
                               $http.defaults.headers.common['modulename']= $scope.currentObject.ownermodule;       
                            }else{
                               $http.defaults.headers.common['modulename']= $scope.currentModule.name;       
                            }//end if($scope.item.ownermodule){
                            //Recuperation du premier element
                            var index = commonsTools.getIndex($scope.datas,data);
                            if(angular.isDefined(index)){
                                $scope.pagination.currentPage = $scope.pagination.beginIndex+index+1;
                            }//end if(angular.isDefined(index))
                            $scope.suffixedittitle = $scope.currentObject.designation;
                             //Cas exceptionnel des application
                            if($scope.showApplication==true){
                                //alert(angular.toJson($scope.currentObject));
                                if($scope.currentObject.active){
                                    $scope.exportbtnlabel = "Desinstaller";
                                }else{
                                    $scope.exportbtnlabel = "Installer";
                                }//end if($scope.currentObject.active){
                            }//end if($scope.showApplication==true){
                            //
//                            console.log("$scope.viewAction ============== "+angular.toJson(data));
                            $scope.displayEditPanel();
//                            console.log("$scope.viewAction after display ============== "+angular.toJson(data));
                            commonsTools.hideDialogLoading();
                },function(error){
                     commonsTools.hideDialogLoading();
                     commonsTools.showMessageDialog(error);
                } );               
               
                //refresh data from data store
                //$scope.currentObject = restService.findById($scope.currentObject.code);         
               //$scope.createEmptyObject($scope.metaData);               
          };
          /**
           * 
           * @param {type} dasboardID
           * @returns {undefined}
           */
          $scope.showEntrypanel = function(dasboardID , entryID ){
              var data = commonsTools.getDashoardEntryDataFromID($scope.currentObject,dasboardID ,entryID);
//              alert("vous avez clique sur showEntrypanel ::: "+angular.toJson(data)+" == "+dasboardID+"   "+entryID);
              if(data){
                  var container = document.createElement("div");
                  container.setAttribute("style","height: 100%; width: 100%;");
                  container.setAttribute("id",dasboardID);
                  commonsTools.dashboardEntryBuilder(dasboardID,data,$scope);
                   //listElem.append(angular.element(content));                 
//                  if(viewElem){
//                    container.appendChild(viewElem);
//                     // ///Remplacement dans la vue
                      var items = $element.find("div");
                      var viewElem = null;
                      for(var i=0; i<items.length;i++){
                           if(items.eq(i).attr("id")==dasboardID){
                               viewElem = items.eq(i);
                               break;
//                                 items.eq(i).replaceWith(container);
                                  //console.log(" ======================= on a trouve report  innerpanel");
                           }//end if(items.eq(i).attr("id")=="innerpanel")  
                      }//end if(items.eq(i).attr("id")=="innerpanel")
                      var compileFn = $compile(viewElem);
                      compileFn($scope);                                
//                  }//end if(viewElem)
              }//end if(data)
          };
          /**
           * 
           * @param {type} model
           * @param {type} entity
           * @param {type} method
           * @returns {undefined}
           */
          $scope.dashboardEntryBtn = function(model , entity , method){
              //chargement des metaData
              var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(model)+"/"+angular.lowercase(entity)+"/meta";
              commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
              $http.get(url)
                      .then(function(response){
                          var metadata = response.data ;
                          var url2 = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(model)+"/"+angular.lowercase(entity)+"/"+method;
                          $http.get(url2)
                                  .then(function(response){
                                      var data = response.data;
//                                      console.log("principal.dashboardEntryBtn = function(model , entity , method) ============ url : "+url2+" === \n data : "+angular.toJson(data));
                                      $scope.listDialogBuilderExternal(data,metadata,1);
                                      commonsTools.hideDialogLoading();
                                      $("#globalModal").modal("toggle");
                                      $("#globalModal").modal("show");
                                  },function(error){
                                        commonsTools.hideDialogLoading();
                                        commonsTools.showMessageDialog(error);
                                  });
                      },function(error){
                          commonsTools.hideDialogLoading();
                          commonsTools.showMessageDialog(error);
                      });
          };
          /**
           * 
           */
          $scope.$on("displayitem",function(event , args){
                var index = (args.index-1)%$scope.pagination.pageSize;
                var item = $scope.datas[index];
//                console.log("displayitem ======== "+index);
                if($scope.windowType=='view'){
                     $scope.viewAction(item);
                }else if($scope.windowType=='update'){
                     $scope.viewAction(item);
                     $scope.windowType = 'update';
                }//end if($scope.windowType=='view')
                $scope.pagination.currentPage = args.index ;
          });
          /**
           * 
           * @returns {undefined}
           */
          $scope.deleteListAction = function(){
              var result = confirm("Voulez vous supprimer les "+$scope.selectedObjects.length+" selectionnÃ©s ?");
              if(result==true){
                    commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                    if($scope.selectedObjects && $scope.selectedObjects.length>0){
                       restService.deleteAll($scope.selectedObjects).$promise
                              .then(function(){
                                     $scope.reset();
                                     //Rechargement des donnÃ©es
                                     $scope.displayListPanel();
                                     commonsTools.hideDialogLoading();
                                     $scope.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success");
                              },function(error){
                                  commonsTools.hideDialogLoading();
                                  commonsTools.showMessageDialog(error);
                              });
                      //$scope.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success");                   
                 }else{
                     $scope.notifyWindow("Suppression Impossible" ,"<br/> Veuillez selectionner au moins une ligne","warning");
                 }      
             }//end if(result==true){
          };
           $scope.saveOrUpdateEditableListtAction = function(item){
                    commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                     var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase($scope.metaData.moduleName)+"/"+angular.lowercase($scope.metaData.entityName);
                     var validate = $scope.validateFields($scope.metaData , item);
                     if(validate.length>0){
                        var message = "";
                        for(var i=0; i<validate.length;i++){
                            message = message+"<br/>"+validate[i];
                        }//end for(var i=0; i<validate.length;i++)
                        commonsTools.hideDialogLoading();
                        $scope.notifyWindow("Les champs suivants sont incorrects" ,message,"danger");                        
                     }else if(item.id<0){
//                        console.log("$scope.saveOrUpdateEditableListtAction === "+$scope.windowType+" ====== "+angular.toJson(item));
                        delete item.id;
                        restService.save(item).$promise
                                .then(function(entity){
                                         $scope.reset();
                                         //Rechargement des donnÃ©es
                                         $scope.windowType = 'list';
                                         $scope.displayListPanel();
                                         commonsTools.hideDialogLoading();
                                         $scope.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success");
                                  },function(error){
                                      commonsTools.hideDialogLoading();
                                      commonsTools.showMessageDialog(error);
                                  });
                    }else{
                       restService.update(item).$promise
                             .then(function(entity){
                                        $scope.reset();
                                        //Rechargement des donnÃ©es
                                        $scope.windowType = 'list';
                                        $scope.displayListPanel();
                                        commonsTools.hideDialogLoading();
                                        $scope.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success");
                                 },function(error){
                                     commonsTools.hideDialogLoading();
                                     commonsTools.showMessageDialog(error);
                                 });
                    }//end if(item.id<0){
                      //$scope.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success");                   
                              
          };
          /**
           * Suppression des informations
           * @returns {undefined}
           */
          $scope.deleteAction = function(item){              
                    var result = confirm("Voulez vous supprimer : "+$scope.currentObject.designation+" ?");
                    if(angular.isDefined(item)){
                        $scope.currentObject = item;
                    }//end if(angular.isDefined(item)){
                    if(result==true){
                            commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                            try{ // console.log("$scope.deleteAction = Vous avez cliquez sur  delete == "+$scope.selectedObjects);
                                  if($scope.currentObject){
                                      restService.delete($scope.currentObject).$promise.then(function(){
                                          $scope.reset();
                                          //Retour precedent
                                           $scope.navigatorcontainer.gotoPreview();
                                         //Rechargement des donnÃ©es
                                         $scope.displayListPanel();
                                         commonsTools.hideDialogLoading();
                                         commonsTools.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success");
                                      },function(error){
                                          commonsTools.hideDialogLoading();
                                          commonsTools.showMessageDialog(error);
                                          //console.log(angular.toJson(error));
                                      });
                                  }else{
                                      commonsTools.notifyWindow("Suppression Impossible" ,"<br/> Veuillez selectionner au moins une ligne","warning");
                                  }
                            }catch(ex){
                              commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+ex.message,"danger");
                            }   
                        }//end if(result==true)
          };

          /**
           impoort
          **/
          $scope.importAction = function(){  
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
              $scope.importData = commonsTools.createImportEntity($scope.metaData);
              $scope.displayImportPanel();
//              console.log("Vous avez cliquez sur  Import "+angular.toJson($scope.importData));
          };
          /**
        * Creation du memento pour 
        * @returns {undefined}
        */
       $scope.createsession = function(){         
           var session = new Object();
           session.module = $scope.currentModule.name ;
           session.navigator = $scope.navigatorcontainer.getMementos() ;
           session.user = $rootScope.globals.user.id;
           commonsTools.createCookie("session_"+session.user,angular.toJson(session),30);
//           console.log("principal.createsession ===== cookie read : "+commonsTools.readCookie("session_"+session.user));
           return session ;
       };
          
          /**
           * Send the importData to the back end
           * @returns {undefined}
           */
          $scope.importFileAction = function(){
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
              if($scope.importData.fichier!=null){
                var imp = angular.copy($scope.importData);
                var parts = $scope.importData.fichier.split('\\');
                imp.fichier = parts[parts.length-1];
                commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase($scope.metaData.moduleName)+"/"+angular.lowercase($scope.metaData.entityName)+"/import";
                $http.put(url,imp)
                        .then(function(response){
                            var errors = commonsTools.converErrorsMap(response.data);
                            commonsTools.hideDialogLoading();
                            if(errors.length>0){
                                $scope.showValidationMessageDialog(errors);
                            }//end if(errors.length>0){
                        },function(error){
                            commonsTools.hideDialogLoading();
                            commonsTools.showMessageDialog(error);
                        });
                
             }else{
                 var message="Veuillez selectionner le fichier Ã  importer";
                 commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+message,"danger");
             }//end if($scope.importData.fichier!=null){
          };
       /**
        * 
        * @returns {undefined}
        */
       $scope.validerFileAction = function(){
            var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
             if($scope.importData.fichier!=null){
                var imp = angular.copy($scope.importData);
                var parts = $scope.importData.fichier.split('\\');
                imp.fichier = parts[parts.length-1];
                commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase($scope.metaData.moduleName)+"/"+angular.lowercase($scope.metaData.entityName)+"/validateimport";
                $http.put(url,imp)
                        .then(function(response){
                            var errors = commonsTools.converErrorsMap(response.data);
                            commonsTools.hideDialogLoading();
                            if(errors.length>0){
                                $scope.showValidationMessageDialog(errors);
                            }else{
                                commonsTools.notifyWindow("Statut opÃ©ration" ,"<br/>La validation s'est dÃ©roulÃ©e avec success","success");
                            }//end if(errors.length>0){
                        },function(error){
                            commonsTools.hideDialogLoading();
                            commonsTools.showMessageDialog(error);
                        });
                
             }else{
                 var message="Veuillez selectionner le fichier Ã  importer";
                 commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+message,"danger");
             }//end if($scope.importData.fichier!=null){
       };
      
          /**
           * 
           * @returns {undefined}
           */
          $scope.showValidationMessageDialog = function(errors){
//                    var errorobj = angular.fromJson(angular.toJson(error));
//                    console.log(angular.toJson(error));
                       var viewElem =  document.createElement('div'); //;
                        viewElem.setAttribute('id' , 'gmodalbody');
                        viewElem.setAttribute('style','margin:10px;');
                        var tabelem = document.createElement('table');
                        tabelem.setAttribute('class','table table-striped table-hover table-responsive table-sm');
                        viewElem.appendChild(tabelem);
                        var thead = document.createElement('thead');
                        tabelem.appendChild(thead);
                        var trelem = document.createElement('tr');
                        trelem.setAttribute('class','table-header');
                        thead.appendChild(trelem);
                        var thelem = document.createElement('th');
                        thelem.appendChild(document.createTextNode("{{'Ligne' | translate}}"));
                        trelem.appendChild(thelem);
                        thelem = document.createElement('th');                        
                        thelem.appendChild(document.createTextNode("{{'Champ' | translate}}"));
                        trelem.appendChild(thelem);
                        thelem = document.createElement('th');
                        thelem.appendChild(document.createTextNode("{{'Valeur' | translate}}"));
                        trelem.appendChild(thelem);
                        thelem = document.createElement('th');
                        thelem.appendChild(document.createTextNode("{{'Message' | translate}}"));
                        trelem.appendChild(thelem);
                        //Traitement body
                        var bodyelem = document.createElement('tbody');
                        tabelem.appendChild(bodyelem);
                        for(var i=0 ; i<errors.length;i++){
                            var error = errors[i];
                            trelem = document.createElement('tr');
                            tabelem.appendChild(trelem);
                            var thelem = document.createElement('td');
                            thelem.appendChild(document.createTextNode(error['line']));
                            trelem.appendChild(thelem);
                            thelem = document.createElement('td');                        
                            thelem.appendChild(document.createTextNode(error['field']));
                            trelem.appendChild(thelem);
                            thelem = document.createElement('td');
                            thelem.appendChild(document.createTextNode(error['value']));
                            trelem.appendChild(thelem);
                            thelem = document.createElement('td');
                            thelem.appendChild(document.createTextNode(error['message']));
                            trelem.appendChild(thelem);
                        }//end for(var i=0 ; i<errors.length;i++){
                        //Construction du footer
                        var footerDiv = document.createElement('div');
                        footerDiv.setAttribute('class' , 'modal-footer');
                        footerDiv.setAttribute('id' , 'gmodalfooter');
                        //Button annuler
                        var buttonElem = document.createElement('button');
                        footerDiv.appendChild(buttonElem);
                        buttonElem.setAttribute('class' , 'btn btn-default');
                        buttonElem.setAttribute('data-dismiss' , "modal");
                        buttonElem.setAttribute('type' , 'button');
                        buttonElem.appendChild(document.createTextNode('Annuler'));
                        //Entete modal
                        var titleheader = document.createElement('h4');
                        titleheader.setAttribute('class','modal-title');
                        titleheader.setAttribute('id','gmodaltitle');
                        titleheader.appendChild(document.createTextNode("{{'VALIDATETITRE' | translate}}"));                    
                        var items = $(document).find("div");
                        var compileFn = $compile(viewElem);
                         compileFn($scope);
                        for(var i=0; i<items.length;i++){               
                            if(items.eq(i).attr("id")=="gmodalbody"){
                                  items.eq(i).replaceWith(viewElem);                              

                            } else if(items.eq(i).attr("id")=="gmodalfooter"){
                                items.eq(i).replaceWith(footerDiv);
                            }//end if(items.eq(i).attr("id")=="gmodalbody"){
                        }//end for(var i=0; i<items.length;i++){     
                         var compileFn = $compile(titleheader);
                         compileFn($scope);
                        items = $(document).find("h4");
                        for(var i=0; i<items.length;i++){               
                            if(items.eq(i).attr("id")=="gmodaltitle"){
                                  items.eq(i).replaceWith(titleheader);                                     
                            }//end if(items.eq(i).attr("id")=="gmodaltitle"){ 
                        } //end for(var i=0; i<items.length;i++){    
                        //Appele de la fenetre modale
                        $("#globalModal").modal("toggle");
                        $("#globalModal").modal("show");
                    
                   
            },
          /**
           * 
           * @returns {undefined}
           */
          $scope.exportDataAction = function(){
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
              $scope.importData.fichier = $scope.metaData.entityName;
              if($scope.tableheaderselected==false && $scope.selectedObjects.length<=0){
                  var message="Veuillez selectionner les donnÃ©es Ã  exporter";
                  commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+message,"danger");
              }else if($scope.importData.typeexport=="0" && $scope.exportFieldSelectd()==false){
                  var message="Veuillez selectionner les champs concernÃ©s";
                  commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+message,"danger");
              }else{
                  $scope.importData.datas = new Array();
                  if($scope.tableheaderselected==false){
                      for(var i=0 ;i<$scope.selectedObjects.length;i++){
                          $scope.importData.datas.push($scope.selectedObjects[i].id);
                      }//end for(var i=0 ;i<$scope.selectedObjects.length;i++){
                  }//end if($scope.tableheaderselected==false){
                  commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");   
                  var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase($scope.metaData.moduleName)+"/"+angular.lowercase($scope.metaData.entityName)+"/export";
                  $http.put(url,$scope.importData,{responseType: "arraybuffer"})
                          .then(function(response){
                                var linkElement = document.createElement('a');
                                try{
                                        var type = "cvs";
                                        if($scope.importData.format=='excel'){
                                            type = 'xlsx';
                                        }//end if($scope.importData.format=='excel'){
                                        var attachment = angular.lowercase($scope.metaData.entityName);
                                        var today = new Date();
                                        attachment +="_"+today.getTime()+"."+type;
                                        var arrayBufferView = new Uint8Array(response.data );
                                       var blob = new Blob( [ arrayBufferView ], { type: type } );
                                       var urlCreator = window.URL || window.webkitURL;
                                       var docUrl = urlCreator.createObjectURL( blob );
                                       linkElement.setAttribute('href', docUrl);
                                       linkElement.setAttribute("download", attachment);
                                       linkElement.setAttribute("target", "_blank");
                                       var clickEvent = new MouseEvent("click", {
                                           "view": window,
                                           "bubbles": true,
                                           "cancelable": false
                                       });
                                       linkElement.dispatchEvent(clickEvent);
                                } catch (ex) {
                                  commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+ex.message,"danger");
                               }
                                commonsTools.hideDialogLoading();
                          },function(error){
                                commonsTools.hideDialogLoading();
                               commonsTools.showMessageDialog(error);
                            });
              }//end if($scope.tableheaderselected==false && $scope.selectedObjects.length<=0){
//              console.log("Vous avez cliquez sur  exportDataAction "+angular.toJson($scope.importData));
          };
          
          $scope.exportFieldSelectd = function(){
              for(var i=0 ; i<$scope.importData.fields.length;i++){
                  if($scope.importData.fields[i].selected == true){
                      return true ;
                  }//end if($scope.importData.fields[i].selected == true){
              }//end for(var i=0 ; i<$scope.importData.fields.length;i++){
              return false ;
          };
          $scope.exportAction = function(){
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
                 $scope.importData = commonsTools.createImportEntity($scope.metaData);
                 $scope.exportDialogBuilderExtern(1);             
          };
          
         
          /**
           * 
           * @param {type} source
           * @returns {undefined}
           */
          $scope.printAction = function(){  
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
              $scope.showreporttitle = true;
            $scope.displayReportPanel();            
          };
          /**
           * Installation et desinstallation
           * @returns {undefined}
           */
          $scope.installAction = function(item){
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
               if(angular.isDefined(item)){
                 $scope.currentObject = item;
               }//end if(angular.isDefined(item)){
              if($scope.currentObject.active){
                  //Deja installer on va proceder a la desinstallation
                  $scope.uninstallApplication();
              }else{
                  //Non installer on va proceder a la desinstallation
                  $scope.installApplication();
              }//end if($scope.currentObject.active)
          };

/**
 * 
 * @param {type} model
 * @returns {undefined}
 */
         $scope.annulerAction2 = function(model){
              var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
            $scope.innerWindowType = false;            
             if(model){
                var key = commonsTools.keygenerator(model);
                var obj = {id:'load' , designation:'Charger les donnÃ©es ....'};
                $scope.dataCache[key] = new Array();
                $scope.dataCache[key].push(obj);
//                alert("Vous avez ferme la fenetre modal ::::: "+model+"===="+key+" === "+angular.toJson(data));
//                 if(data && angular.isArray(data)){
//                   
//                 } //end if(data && angular.isArray(data)){            
            }//end if(model){
            $timeout(function() {
                $('.selectpicker').selectpicker('refresh');

            });
         };
         /**
          * 
          * @param {type} type
          * @returns {undefined}
          */
         $scope.switchTo = function(type){
             if(type=="calendar"){
                 $scope.previousType="calendar";
                 $scope.calendarFramePanelBuilder($scope.metaData);
             }else if(type=="tree"){
                 $scope.previousType="list";
                 $scope.listFramePanelBuilder($scope.metaData);
             }else if(type=="kaban"){
                 $scope.previousType="kaban";
                 $scope.kabanFramePanelBuilder($scope.metaData);
             }//end if(type=="calendar"){
         };
          /**
            Annulation de la saisie
          **/
          $scope.annulerAction = function(){
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);               
               if(session===null){
                   $scope.deconnexion();
                   $scope.navigations = new Array();
                   return;
               }//end if(session==null){
               $scope.navigatorcontainer.gotoPreviewIFExist();
             //console.log("Vous avez cliquez sur annulerAction");
             commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
             $scope.enablefollowerpanel = false;           
             try{                
                 if(angular.isDefined($scope.currentObject)){
                    restService.cancel($scope.currentObject);                      
                 }
//                 $scope.pagination.currentPage = $scope.pagination.beginIndex+1;
                 $scope.reset(); 
                 $scope.dataCache['resources'] = new Array();
                 $scope.dataCache['names'] = new Array();
                 if($scope.pagination.currentPage!=0){
                     $scope.pagination.currentPage = $scope.pagination.beginIndex+1;
                 }//end if($scope.pagination.currentPage!=0){
                 $scope.displayListPanel();

             }catch(ex){
                $scope.notifyWindow("Une erreur est servenu pendant le traitement..." ,"<br/>"+ex.message,"danger");
             }
            
          };

          /**
             Recherche les donnÃ©es selon les criteres contenu dans predicats
          **/
          $scope.searchAction = function(){
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session===null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
               $http.defaults.headers.common['search_text']= $scope.searchCriteria;  
              restService.count($scope.predicats)
                .$promise.then(function(data){
                    $scope.pagination.currentPage=0;
                    $scope.pagination.beginIndex = 0;
                    $scope.pagination.totalPages = data.value ;                                                  
                    $scope.loadData();
                }
                , function(error){
                    commonsTools.hideDialogLoading();
                    commonsTools.showMessageDialog(error);
                });       
          };

/**
 * 
 * @param {type} elementID
 * @returns {undefined}
 */
          $scope.searchCriteriaBuilder = function(elementID){
//              console.log("$scope.searchCriteriaBuilder = function(elementID) ================== "+$scope.temporalPredicats.length+" === "+elementID);
              if(!angular.isDefined(elementID)){
                $scope.searchCriteria = new String();
                for(var i=0; i<$scope.predicats.length;i++){
                    if($scope.predicats[i].value){
                      var oredicat = $scope.predicats[i].fieldName+" "+$scope.predicats[i].type+" "+$scope.predicats[i].value;
                       $scope.searchCriteria = $scope.searchCriteria+" "+oredicat+" ;"
                    }//end if($scope.predicats[i].value){
                }//end for(var i=0; i<$scope.predicats.length;i++){
              }else {
                  $scope.temporalSearchCriteria = new String();                  
                  for(var i=0; i<$scope.temporalPredicats.length;i++){
                    if($scope.temporalPredicats[i].value){
                      var oredicat = $scope.temporalPredicats[i].fieldName+" "+$scope.temporalPredicats[i].type+" "+$scope.temporalPredicats[i].value;
                       $scope.temporalSearchCriteria = $scope.temporalSearchCriteria+" "+oredicat+" ;"
                    }//end if($scope.temporalPredicats[i].value){
                  }//end for(var i=0; i<$scope.temporalPredicats.length;i++){
              }//end if(!angular.isDefined(elementID))
          };

         /**
             Gestion des messages
         **/
         $scope.messagesAction = function(){
              var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
             //activer le zone de saisie des messages
             $scope.enablefollowerpanel = true;
             $scope.dataCache['messageobject'] = $scope.createemptyMessage(null,null,null);
             $scope.messageType = "outer";           
//             console.log("Vous avez cliquez sur  messagesAction ");
         };


          /**
             Gestion des notes internes
          **/
         $scope.notesInterneAction = function(){
              var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
              $scope.enablefollowerpanel = true;
              $scope.dataCache['messageobject'] = $scope.createemptyMessage(null,$rootScope.globals.user,null);
              $scope.dataCache['messageobject'].sender = $rootScope.globals.user;
              $scope.dataCache['messageobject'].reciever = $rootScope.globals.user;
              $scope.messageType = "inner";                 
//              console.log("Vous avez cliquez sur  notesInterneAction ");
         };
/**
             * 
             * @param {type} canal
             * @param {type} reciever
             * @param {type} body
             * @returns {controllers_L18.$scope.createemptyMessage.message|type.createemptyMessage.message|type@call;$asArray.createemptyMessage.message|cfg.type.createemptyMessage.message|Object|paramTypes@call;type.createemptyMessage.message}
             */
            $scope.createemptyMessage = function(canal,reciever,body){
                var message = new Object();
                message.id = -1;message.compareid=-1;message.designation=null;
                message.editTitle=null;message.listTitle=null;message.moduleName=null;
                message.selected=false;message.createonfield=true;message.desablecreate=false;
                message.desabledelete=false;message.serial=null;message.activefilelien=false;
                message.footerScript=null;message.activatefollower=false;message.date=null;
                message.status=false;message.piecesjointe=new Array();message.sender=$scope.currentUser;
                message.canal=canal;message.reciever=reciever;message.body=body;message.recievers=[];
                message.canaux=[];
                return message;
            };
         /**
           Ajout d'un abornÃ©e pour un message
         **/
         $scope.editPanelAjoutAborne = function(){            
            var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/utilisateur/meta";
            $http.get(url)
                    .then(function(response){
                        var metaData = response.data;
                        var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/canal/directe/"+$rootScope.globals.user.courriel;
                        $http.get(url)
                                .then(function(response){
                                    var datas = response.data;                                    
//                                    console.log("Vous avez cliquez sur  editPanelAjoutAborne "+datas.length);  
                                    $scope.listDialogWithDataBuilder("dataCache.follower",metaData,datas,1);
                                    //Appele de la fenetre modale
                                    $("#myModal").modal("toggle");
                                    $("#myModal").modal("show");
                                },function(error){
                                    commonsTools.showMessageDialog(error);
                                });
                    },function(error){
                        commonsTools.showMessageDialog(error);
                    });
            
            
         };
         /**
          * 
          * @returns {undefined}
          */
         $scope.buildfollowermenu = function(){
             var ulElem = document.createElement("ul");
             ulElem.setAttribute("class","dropdown-menu");
             ulElem.setAttribute("role","menu");
             ulElem.setAttribute("aria-labelledby","followerbtn");
             ulElem.setAttribute("id","followermenuid");
             var lielem = document.createElement("li");
             ulElem.appendChild(lielem);
             lielem.setAttribute("role","presentation");
             var aElem = document.createElement("a");
             lielem.appendChild(aElem);
             aElem.setAttribute("role","menuitem");aElem.setAttribute("tabindex","-1");
             aElem.setAttribute("href","#");aElem.setAttribute("ng-click","editPanelAjoutAborne()");
             aElem.appendChild(document.createTextNode("Ajouter des abonnÃ©es"));
             //Menu canaux
             lielem = document.createElement("li");
             ulElem.appendChild(lielem);
             lielem.setAttribute("role","presentation");
             aElem = document.createElement("a");
             lielem.appendChild(aElem);
             aElem.setAttribute("role","menuitem");aElem.setAttribute("tabindex","-1");
             aElem.setAttribute("href","#");aElem.setAttribute("ng-click","editPanelAjoutCanaux()");
             aElem.appendChild(document.createTextNode("Ajouter des canaux"));
             lielem = document.createElement("li");
             ulElem.appendChild(lielem);
             lielem.setAttribute("role","presentation");
             //Bar separateur
             lielem = document.createElement("li");
             ulElem.appendChild(lielem);
             lielem.setAttribute("class","dropdown-divider");
             //Construction des menus
             if($scope.dataCache['follower'].abonnes.length>0){
                 for(var i=0;i<$scope.dataCache['follower'].abonnes.length;i++){
                        var abonne = $scope.dataCache['follower'].abonnes[i];
                        lielem = document.createElement("li");
                        ulElem.appendChild(lielem);
                        lielem.setAttribute("role","presentation");
                        var spanElem = document.createElement("span");
                        lielem.appendChild(spanElem);
                        spanElem.setAttribute("style","display: inline-block;");
                        var span1 = document.createElement("span");
                        spanElem.appendChild(span1);
                        span1.setAttribute("style","display: inline-block;margin-right: 15px;");
                        aElem = document.createElement("a");
                        span1.appendChild(aElem);
                        aElem.setAttribute("role","menuitem");aElem.setAttribute("tabindex","-1");
                        aElem.setAttribute("href","#");aElem.setAttribute("ng-click","editPanelAjoutCanaux()");
                        aElem.appendChild(document.createTextNode(abonne.designation));
                        span1 = document.createElement("span");
                        spanElem.appendChild(span1);
                        span1.setAttribute("style","display: inline-block;");
                        aElem = document.createElement("a");
                        span1.appendChild(aElem);
                        aElem.setAttribute("role","menuitem");aElem.setAttribute("tabindex","-1");
                        aElem.setAttribute("href","#");aElem.setAttribute("ng-click","deletefollower('abonnes','"+i+"')");
                        var span2 = document.createElement("span");
                        aElem.appendChild(span2);
                        span2.setAttribute("class","glyphicon glyphicon-trash");
                        span2.setAttribute("aria-hidden","true");
                 }//end for(var i=0;i<$scope.dataCache['follower'].abonnes.length;i++)
           }//end if($scope.dataCache['follower'].abonnes.length>0)
           if($scope.dataCache['follower'].canaux.length>0){
            for(var i=0;i<$scope.dataCache['follower'].canaux.length;i++){
                   var canal = $scope.dataCache['follower'].canaux[i];
                   lielem = document.createElement("li");
                    ulElem.appendChild(lielem);
                    lielem.setAttribute("role","presentation");
                    var spanElem = document.createElement("span");
                    lielem.appendChild(spanElem);
                    spanElem.setAttribute("style","display: inline-block;");
                    var span1 = document.createElement("span");
                    spanElem.appendChild(span1);
                    span1.setAttribute("style","display: inline-block;margin-right: 15px;");
                    aElem = document.createElement("a");
                    span1.appendChild(aElem);
                    aElem.setAttribute("role","menuitem");aElem.setAttribute("tabindex","-1");
                    aElem.setAttribute("href","#");aElem.setAttribute("ng-click","editPanelAjoutCanaux()");
                    aElem.appendChild(document.createTextNode(canal.designation));
                    span1 = document.createElement("span");
                    spanElem.appendChild(span1);
                    span1.setAttribute("style","display: inline-block;");
                    aElem = document.createElement("a");
                    span1.appendChild(aElem);
                    aElem.setAttribute("role","menuitem");aElem.setAttribute("tabindex","-1");
                    aElem.setAttribute("href","#");aElem.setAttribute("ng-click","deletefollower('canaux','"+i+"')");
                    var span2 = document.createElement("span");
                    aElem.appendChild(span2);
                    span2.setAttribute("class","glyphicon glyphicon-trash");
                    span2.setAttribute("aria-hidden","true");
            }//end for(var i=0;i<$scope.dataCache['follower'].abonnes.length;i++)
           }//end if($scope.dataCache['follower'].abonnes.length>0)
           var compileFn = $compile(ulElem);
           compileFn($scope);
           //Cas des canaux
           $("#followermenuid").replaceWith(ulElem);
         };
         /**
          * 
          * @param {type} type
          * @param {type} id
          * @returns {undefined}
          */
         $scope.deletefollower = function(type , id){
             if(type=='abonnes'){
                 $scope.dataCache['follower'].abonnes.splice(id ,1);
             }else if(type=='canaux'){
                 $scope.dataCache['follower'].canaux.splice(id ,1);
             }//end if(type=='abonnes')
              var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/follower/"+$scope.dataCache['follower'].id;
              $http.put(url,$scope.dataCache['follower'])
                    .then(function(response){
                         var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/follower/entity/"+$scope.currentObject.serial+"/"+$scope.currentObject.id;
                        $http.get(url)
                                .then(function(response){
                                    $scope.dataCache['follower'] = response.data;  
                                    $scope.buildfollowermenu();
                                },function(error){
                                    commonsTools.showMessageDialog(error);
                                });
                    },function(error){
                        commonsTools.showMessageDialog(error);
                    });
                    
         };
          /**
           Ajout d'un abornÃ©e pour un message
         **/
         $scope.editPanelAjoutCanaux = function(){
            var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/canal/meta";
            $http.get(url)
                    .then(function(response){
                        var metaData = response.data;
                        var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/canal/canaux/"+$rootScope.globals.user.courriel;
                        $http.get(url)
                                .then(function(response){
                                    var datas = response.data;                                    
//                                    console.log("Vous avez cliquez sur  editPanelAjoutAborne "+datas.length);  
                                    $scope.listDialogWithDataBuilder("dataCache.follower",metaData,datas,1);
                                    //Appele de la fenetre modale
                                    $("#myModal").modal("toggle");
                                    $("#myModal").modal("show");
                                },function(error){
                                    commonsTools.showMessageDialog(error);
                                });
                    },function(error){
                        commonsTools.showMessageDialog(error);
                    });
         };
         
         /**
             Active ou desactive le suivie
         **/
         $scope.suivreAction = function(){
              var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
             $scope.activefollower = !$scope.activefollower;
             $scope.dataCache['follower'].actif = $scope.activefollower;
             if($scope.activefollower==false){
                 alert("Vous ne pourriez plus envoyer des followers");
             }//end if($scope.activefollower==false)
         };
         
        /**
         * 
         * @param {type} module
         * @param {type} model
         * @returns {undefined}
         */
         $scope.listsearchAction = function(model){
             var metaData = $scope.getCurrentMetaData(model);  
//             console.log("$scope.listsearchAction LEVEL 1 = "+angular.toJson(metaData.searchfields)+" ==================== "+model+" ====== temporalSearch : "+$scope.temporalSearchCriteria);
             if(metaData){                           
                     var part = model.split(".");
                     $http.defaults.headers.common['predicats']= angular.toJson($scope.temporalPredicats);  
                     $http.defaults.headers.common['search_text']= angular.toJson($scope.temporalSearchCriteria);  
                     $scope.temporalPagination.currentPage=1;
                     $scope.temporalPagination.module = metaData.moduleName;
                     $scope.temporalPagination.model = metaData.entityName;
                     var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase(metaData.moduleName)+"/"+angular.lowercase(metaData.entityName)+"/count";
                     commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                     $http.get(url)
                             .then(function(response){
                                 var itemscount = response.data.value;
                                 $scope.temporalPagination.totalPages = response.data.value;
                                 $scope.temporalPagination.endIndex = $scope.temporalPagination.pageSize;
                                 if(itemscount<$scope.temporalPagination.pageSize){
                                    $scope.temporalPagination.endIndex = itemscount;
                                 }//end if(itemscount<$scope.temporalPagination.pageSize){
                                 $scope.getData2("dataCache."+metaData.entityName,metaData.entityName,metaData.moduleName);//                              
                             },function(error){
                                commonsTools.hideDialogLoading();
                                commonsTools.showMessageDialog(error);
                             });
             }//end if(metaData) 
         };
         /**
          * 
          * @param {type} filename
          * @returns {undefined}
          */
         $scope.followerpiecejointeviewAction = function(id,filename){
             $scope.piecejointeviewAction(id);
         };
         /**
          * 
          * @param {type} filename
          * @returns {undefined}
          */
         $scope.followerpiecejointedeleteAction = function(filename){
                commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%"); 
                var url2 = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/temporal/"+filename;
                $http({method:"DELETE" , url:url2
                }).then(function(response){
                     for(var i=0 ; i<$scope.dataCache['messageobject'].piecesjointe.length;i++){
                         var pj = $scope.dataCache['messageobject'].piecesjointe[i];
                         if(pj.filename==filename){
                             $scope.dataCache['messageobject'].piecesjointe.splice(i,1);
                         }//end if(pj.filename==filename)
                     }//end for(var i=0 ; i<$scope.messageobject.length;i++)
                     $scope.followerpiecejointeMenu($scope.dataCache['messageobject']);
                     commonsTools.hideDialogLoading();
                },function(error){
                    commonsTools.hideDialogLoading();
                    commonsTools.showDialogLoading(error);
                });          
        };
         /**
          * Suppression des piece jointes
          * @returns {undefined}
          */
         $scope.piecejointedeleteAction = function(id,filename){
             var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/piecejointe/";
             commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");              
             $http({
                 method:"DELETE", url:url+id                 
             }).then(function(response){
                 $scope.piecejointeMenu(null,$scope.currentObject,$scope.metaData);
                 var url2 = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/";
                 $http({method:"DELETE" , url:url2+filename
                 }).then(function(response){
                     commonsTools.hideDialogLoading();
                 },function(error){
                     commonsTools.hideDialogLoading();
                     commonsTools.showMessageDialog(error);
                 });          
                 
             },function(error){
                 commonsTools.hideDialogLoading();
                 commonsTools.showMessageDialog(error);
             });
//             console.log("Vous avez cliquez sur piecejointedelelteAction pour la piece "+id);
         };
         /**
          * 
          * @param {type} id
          * @returns {undefined}
          */
         $scope.showpiecejointe = function(id){
             $scope.piecejointeviewAction(id);
         };
         /**
          * Evenement lie au piece jointe dans discussion
          */
         $scope.$on("showpiecejointe",function(event , args){
               if(args.pjID){
                 $scope.showpiecejointe(args.pjID); 
               }//end if(args.pjID)                      
          });
         /**
          * Consultation de la piece jointe selectionne
          * @returns {undefined}
          */
         $scope.piecejointeviewAction = function(id){
             //Recuperation de la piece jointe
             var url =$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/piecejointe/byid/id/"+id;
             commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");   
             $http.get(url)
                     .then(function(response){
                         var pj = response.data;
                         if(pj){
                             var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/";
                             var parts = pj.attachename.split(".");
                             var type = "application/pdf";
                             var extension = parts[parts.length-1];
                             if(extension=='pdf'){
                                 url = url+'pdf/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='png'||extension=='jpeg'){
                                 type = "image/png";
                                 url = url+'img/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='doc'||extension=='dot'){
                                 type = "application/msword";
                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='docx'||extension=='dotx'){
                                 type = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='xls'||extension=='xlt'||extension=='xla'){
                                 type = "application/vnd.ms-excel";
                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='xlsx'||extension=='xltx'){
                                 type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='ppt'||extension=='pot'||extension=='pps'||extension=='ppa'){
                                 type = "application/vnd.ms-powerpoint";
                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='pptx'){
                                 type = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='mdb'){
                                 type = "application/vnd.ms-access";
                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='rar'){
                                 type = "application/x-rar-compressed, application/octet-stream";
                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='mdb'){
                                 type = "application/zip, application/octet-stream";
                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else /*if(extension=='txt'||extension=='sql')*/{
                                 url = url+'text/'+pj.filename+'/'+pj.attachename;
                                 type = "text/plain";
                             }//end if(extension=='pdf')
                             $http.get(url, {responseType: "arraybuffer"})
                                     .then(function(response){
//                                         console.log("$scope.piecejointeviewAction  ============================================= "+angular.toJson(response));
//                                         var filename = response.headers['x-filename'];
//                                         var contentType = response.headers['content-type'];
                                         var linkElement = document.createElement('a');
                                         try{
                                                 var arrayBufferView = new Uint8Array(response.data );
                                                var blob = new Blob( [ arrayBufferView ], { type: type } );
                                                var urlCreator = window.URL || window.webkitURL;
                                                var docUrl = urlCreator.createObjectURL( blob );
                                                linkElement.setAttribute('href', docUrl);
                                                linkElement.setAttribute("download", pj.attachename);
                                                linkElement.setAttribute("target", "_blank");
                                                var clickEvent = new MouseEvent("click", {
                                                    "view": window,
                                                    "bubbles": true,
                                                    "cancelable": false
                                                });
                                                linkElement.dispatchEvent(clickEvent);
                                         } catch (ex) {
                                           commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+ex.message,"danger");
                                        }
                                         commonsTools.hideDialogLoading();
                                     },function(error){
                                         commonsTools.hideDialogLoading();
                                         commonsTools.showMessageDialog(error);
                                     });
                         }else{
                             commonsTools.hideDialogLoading();
                             commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+"Impossible de trouve la piÃƒÂ¨ce jointe  : "+pj.attachename,"danger");
                         }//end if(pj)
                     },function(error){
                         commonsTools.hideDialogLoading();
                        commonsTools.showMessageDialog(error);
                     });
         };
         
         /**
          * 
          * @param {type} model
          * @param {type} fieldName
          * @returns {undefined}
          */
          $scope.downloadAction = function(model , fieldName){
             //Recuperation de la piece jointe
             var data = $scope.getParentModel(model);
             var pj = data[fieldName];
//             console.log("$scope.downloadAction = function(model , fieldName) =================== model :"+model+" === fieldName :"+fieldName+" ==== pj:"+pj);
            commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");   
                  if(pj){
                             var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/";
                             var parts = pj.split(".");
                             var type = "application/pdf";
                             var extension = parts[parts.length-1];
                             if(extension=='pdf'){
                                 url = url+'pdf/'+pj+'/'+pj;
                             }else if(extension=='png'||extension=='jpeg'){
                                 type = "image/png";
                                 url = url+'img/'+pj+'/'+pj;
                             }else if(extension=='doc'||extension=='dot'){
                                 type = "application/msword";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='docx'||extension=='dotx'){
                                 type = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='xls'||extension=='xlt'||extension=='xla'){
                                 type = "application/vnd.ms-excel";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='xlsx'||extension=='xltx'){
                                 type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='ppt'||extension=='pot'||extension=='pps'||extension=='ppa'){
                                 type = "application/vnd.ms-powerpoint";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='pptx'){
                                 type = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='mdb'){
                                 type = "application/vnd.ms-access";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='rar'){
                                 type = "application/x-rar-compressed, application/octet-stream";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='mdb'){
                                 type = "application/zip, application/octet-stream";
                                 url = url+'file/'+pj+'/'+pj;
                             }else /*if(extension=='txt'||extension=='sql')*/{
                                 url = url+'text/'+pj+'/'+pj;
                                 type = "text/plain";
                             }//end if(extension=='pdf')
                             $http.get(url, {responseType: "arraybuffer"})
                                     .then(function(response){
//                                         console.log("$scope.piecejointeviewAction  ============================================= "+angular.toJson(response));
//                                         var filename = response.headers['x-filename'];
//                                         var contentType = response.headers['content-type'];
                                         var linkElement = document.createElement('a');
                                         try{
                                                 var arrayBufferView = new Uint8Array(response.data );
                                                var blob = new Blob( [ arrayBufferView ], { type: type } );
                                                var urlCreator = window.URL || window.webkitURL;
                                                var docUrl = urlCreator.createObjectURL( blob );
                                                linkElement.setAttribute('href', docUrl);
                                                linkElement.setAttribute("download", pj);
                                                linkElement.setAttribute("target", "_blank");
                                                var clickEvent = new MouseEvent("click", {
                                                    "view": window,
                                                    "bubbles": true,
                                                    "cancelable": false
                                                });
                                                linkElement.dispatchEvent(clickEvent);
                                         } catch (ex) {
                                           commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+ex.message,"danger");
                                        }
                                         commonsTools.hideDialogLoading();
                                     },function(error){
                                         commonsTools.hideDialogLoading();
                                         commonsTools.showMessageDialog(error);
                                     });
                         }else{
                             commonsTools.hideDialogLoading();
                             commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+"Impossible de trouve la piÃƒÂ¨ce jointe  : "+pj,"danger");
                         }//end if(pj)
                     
         };
/**
             * 
             * @returns {undefined}
             */
            $scope.sendAction = function(){
                if($scope.dataCache['messageobject'].body && $scope.dataCache['messageobject'].body.trim()!=""){
//                    var message = $scope.createemptyMessage($scope.canal,$scope.connecteduser,$scope.messagebody);
//                       $scope.dataCache['messageobject'].body = $scope.messagebody;  
                    if($scope.messageType=="outer" && $scope.activefollower==false){
                        alert("Veuillez activer le suivie des followers");
                        return;
                    }
                    if($scope.messageType=="inner"){
                        $scope.dataCache['messageobject'].sender = $rootScope.globals.user;
                        $scope.dataCache['messageobject'].reciever = $rootScope.globals.user;
                    }//end if($scope.messageType=="inner")
                    $scope.dataCache["follower"].messages.push($scope.dataCache['messageobject']);
//                    console.log("$scope.sendAction ==== "+$scope.messageType);
                    var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/follower/send/"+$rootScope.globals.user.id;
                    commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                    $http.post(url,$scope.dataCache["follower"])
                            .then(function(response){                               
                                     $scope.dataCache["messageobject"] = $scope.createemptyMessage(null,null,"");
                                     $scope.dataCache['follower']=response.data;
                                     $scope.buildfollowermenu();    
                                     $scope.buildFollowerMessagesView(null,$scope.dataCache['follower'].messages);
                                     $scope.followerpiecejointeMenu($scope.dataCache["messageobject"]);
                                     $scope.enablefollowerpanel = false;
                                     commonsTools.hideDialogLoading();
                            },function(error){
                                commonsTools.hideDialogLoading();
                                commonsTools.showDialogLoading(error);
                            });
                    
                }else{
                    commonsTools.notifyWindow("Erreur" ,"Le corps du message ne peut ÃƒÂªtre vide","danger"); 
                }//end if($scope.messagebody && $scope.messagebody.trim()!="")
            };
            /**
             * 
             * @param {type} messages
             * @returns {undefined}
             */
            $scope.buildFollowerMessagesView = function(viewElem , messages){     
                    messages = $filter('orderBy')(messages,'-date',false);  
                    var tableElem = document.createElement('table');
                    tableElem.setAttribute('class','table table-inbox table-hover');
                    tableElem.setAttribute("id","tablefollowersid");
                    var tbody = document.createElement('tbody');
                    tableElem.appendChild(tbody);
                    if(messages){
                        for(var i=0;i<messages.length;i++){
                            var msge = messages[i];
                            var trElem = document.createElement('tr');
                            tbody.appendChild(trElem);
                            if(msge.status==false){
                                trElem.setAttribute('class', ""); 
                            };
                            var tdElem = document.createElement('td');
                            trElem.appendChild(tdElem);
                            tdElem.setAttribute('class',"view-message  dont-show");
                            tdElem.appendChild(document.createTextNode(msge.sender.intitule));
                         //Marqueur de lecture    
                            tdElem = document.createElement('td');
                            trElem.appendChild(tdElem);
                            tdElem.setAttribute('class',"view-message");
                            tdElem.appendChild(document.createTextNode(msge.body));                            
                            //piecejointe
                            tdElem = document.createElement('td');
                            trElem.appendChild(tdElem);
                            tdElem.setAttribute('class',"view-message");
                            if(msge.piecesjointe){
                                var spanElem= document.createElement("span");
                                tdElem.appendChild(spanElem);
                                spanElem.setAttribute("style","display:inline-block;")
                                for(var j=0 ; j<msge.piecesjointe.length;j++){
                                    var pj = msge.piecesjointe[j];
                                    var span = document.createElement("span");
                                    spanElem.appendChild(span);
                                    span.setAttribute("class","glyphicon glyphicon-paperclip");
                                    span.setAttribute("aria-hidden","true");
                                    var aElem = document.createElement("a");
                                    aElem.setAttribute("href","#");
                                    aElem.setAttribute("ng-click","showpiecejointe('"+pj.id+"')");
                                    aElem.appendChild(document.createTextNode(pj.attachename)),
                                    span.appendChild(aElem);
                                }//end for(var j=0 ; j<msge.piecesjointe.lenth;j++)
                            }//end if(msge.piecesjointe)
                            //Heuree
                            tdElem = document.createElement('td');
                            trElem.appendChild(tdElem);
                            tdElem.setAttribute('class',"view-message");
//                            alert(msge.date+" === "+angular.isNumber(msge.date));
                            tdElem.appendChild(document.createTextNode(commonsTools.formatDat(new Date(msge.date))));
                        }//end for(var i=0;i<$scope.messages.length;i++)
                    }//end if($scope.messages){                    
                    var compileFn = $compile(tableElem);
                    compileFn($scope);                    
                    if(viewElem==null){
                        ///Remplacement dans la vue
                        var pbjmenu = document.querySelector('#tablefollowersid');
                        if(pbjmenu!=null){
//                            console.log("Trouve !!!!!!!!!!!!!!!!");
                             pbjmenu.replaceWith(tableElem);
                        }     
                    }else{
//                        viewElem = angular.element(viewElem);
                        var items = viewElem.find("table");
                        for(var i=0; i<items.length;i++){
                            if(items.eq(i).attr("id")=="tablefollowersid"){
//                                console.log("Trouve !!!!!!!!!!!!!!!!");
                                  items.eq(i).replaceWith(tableElem);
                            }  
                        }                        
                    }//end if(viewElem==null)
            };
        /**
         * 
         * @param {type} data
         * @param {type} type
         * @param {type} states
         * @param {type} index
         * @param {type} extern
         * @returns {undefined}
         */
        $scope.buttonAction = function(data,type,states,index,extern){
            try{  //Verifier que l'object est definie
                if(angular.isString(data)){
                    data = angular.fromJson(data);
                }//end if(angular.isString(data))
//                console.log("$scope.buttonAction = function(data,type,states,index) type:"+type+" ========= "+angular.toJson(data));
                if(data.critical===true){
                    var result = false ;
                    if(data.alert && data.alert!==""){
                        result =confirm(data.alert);
                    }else{
                        result =confirm("Cette action est irreversible \n Voulez vous continuer?");
                    }//end if(data.alert && data.alert!=""){
                    if(result===false){
                        return ;
                    }//end if(result==false){
                }//end if(data.critical==true){
                if(data){                    
                   if(type=='action'){
                      if(data.name&&data.name=="update_pwd"){
                          var action = {id:-100,name:"update_pwd" , label:"Elements de Menu",icon:"glyphicon glyphicon-th",entityName:"PwdUser",moduleName:"kerencore",modal:true,securitylevel:0,model:'kerencore'};
                          $rootScope.$broadcast("currentActionUpdate" ,{
                                   action:action , verticalMenu:$scope.enabledVerticalMenu,index:index});  
                      }else {//Cas des autres button des types actions
                          //Create differ
                          commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                          var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/menuaction/bystringproperty/name/"+data.name;
                          //console.log("$scope.buttonAction = "+angular.toJson(data)+" == "+type+" === "+data.name+"==== "+url); 
                          $http.get(url)
                                  .then(function(response){                    
                                      var datas = response.data;
                                      if(datas && datas.length>0){
                                          var action = datas[0];
                                           var template = $scope.templateDataBuilder(data['template'],extern);
                                           //commonsTools.hideDialogLoading();
                                           $rootScope.$broadcast("currentActionUpdateModal" ,{
                                                action:action , verticalMenu:$scope.enabledVerticalMenu , template:template,index:index});  
                                      }else{
                                           commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+"Impossible de trouve l'action : "+data.name,"danger");     
                                      }//end if(datas && datas.length>0){
                                      commonsTools.hideDialogLoading();                                      
                                  },function(error){
                                      commonsTools.hideDialogLoading();
                                      commonsTools.showMessageDialog(error);
                                  });
                      }   
                   }else if(type==='link') {
                       //Create differ
                          commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                          var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/menuaction/bystringproperty/name/"+data.name;
                          if(!$rootScope.globals.headers){
                              $rootScope.globals.headers = new Array();
                          }//end if(!$rootScope.globals.headers)
                          //console.log("$scope.buttonAction = "+angular.toJson(data)+" == "+type+" === "+data.name+"==== "+url); 
                          $http.get(url)
                                  .then(function(response){                    
                                      var datas = response.data;
                                      if(datas && datas.length>0){
                                          var action = datas[0];
                                           var template = $scope.templateDataBuilder(data['template'],extern);
                                           var hearders = data['header'];
//                                           console.log("$scope.buttonAction ========================"+hearders+" == "+angular.isArray(hearders)+"== template : "+angular.toJson(template)); 
                                           if(angular.isDefined(hearders)){
                                               if(angular.isArray(hearders)){
                                                   for(var i=0;i<hearders.length;i++){
                                                       var key = hearders[i];
                                                       $rootScope.globals.headers.push(key);
                                                       if(template[key+""]){
                                                            var obj = template[key+""];
//                                                            console.log("$scope.buttonAction ========================"+hearders+" == "+angular.isArray(hearders)+"== template : "+angular.isObject(obj)); 
                                                            if(angular.isObject(obj)){
                                                                $http.defaults.headers.common[key+""]=obj.id;
                                                            }else{
                                                                $http.defaults.headers.common[key+""]=obj;
                                                            }//end if(angular.isObject(obj)){
                                                       }//end if(template[hearders]){
                                                   }//end for(var i=0;i<hearders.length;i++){
                                               }else{
                                                   if(template[hearders]){
                                                        var obj = template[hearders+""];
                                                        if(angular.isObject(obj)){
                                                            $http.defaults.headers.common[hearders+""]=obj.id;
                                                        }else{
                                                            $http.defaults.headers.common[hearders+""]=obj;
                                                        }//end if(angular.isObject(obj)){
                                                   }//end if(template[hearders]){
                                               }//end if(angular.isArray(hearders)){
                                           }//end if(angular.isDefined(hearders)){
                                            var mode = null ;
                                            if(action.viewMode){
                                                mode = action.viewMode.split(",");
                                            }//end if($scope.currentAction.viewMode) 
//                                            console.log("$scope.buttonAction ========================"+hearders+" == == mode : "+mode);   
                                            //Traitement des actions de type website
                                            if(mode && mode.length>0 && mode[0]=='website'){
                                                $rootScope.$broadcast("website" , {website:action.model,currentuser:$rootScope.globals.currentUser});
                                                return ;
                                            }//end if(mode && mode.length>0 && mode[0]=='dashboard'){
                                           $rootScope.$broadcast("currentActionUpdate" ,{
                                                action:action , verticalMenu:$scope.enabledVerticalMenu , template:template,index:index,inner:true});  
                                      }else{
                                           commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+"Impossible de trouve l'action : "+data.name,"danger");
//                                           commonsTools.hideDialogLoading();
                                      }//end if(datas && datas.length>0){
                                      commonsTools.hideDialogLoading();                                           
                                  },function(error){
                                      commonsTools.hideDialogLoading();
                                      commonsTools.showMessageDialog(error);
                                  });
                   }else if(type=='object'){//Traitement des objects message en background
                       if(data.model&&data.entity&&data.method){
                           var template = $scope.templateDataBuilder(data['template'],extern);
                           commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                           var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+data.model+"/"+data.entity+"/"+data.method;
                           $http.post(url,template)
                                   .then(function(response){
                                       $scope.notifyWindow("Status Operation" ,"L'opération s'est déroulée avec sucess","success");  
                                       commonsTools.hideDialogLoading();
                                   },function(error){
                                       commonsTools.hideDialogLoading();
                                       commonsTools.showMessageDialog(error);
                                   });
                           //alert("Vous voulez executer la methode::: "+data.method+" de l'entite :: "+data.entity+" disponible sur la resource :: "+data.model+" data template : "+angular.toJson(template));
                       }                          
                   }else if(type=='workflow'){//Traitement du workflow
//                      console.log("$scope.buttonAction = function(data,type,states) ====== "+angular.toJson($scope.currentObject));
                      if(data.states && data.states.length>0){
                          states = data.states;
                      }//end if(data.states && data.states.length>0){
                     if(states){
                       if(data.model&&data.entity&&data.method && $scope.currentObject){
                           commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                           var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+data.model+"/"+data.entity+"/"+data.method;
                            $http.defaults.headers.common['states']=states;
                            $http.put(url,$scope.currentObject)
                                   .then(function(response){
                                       $scope.currentObject = response.data;
                                       $scope.displayEditPanel();
                                       $scope.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success");  
                                       commonsTools.hideDialogLoading();
                                   },function(error){
                                       commonsTools.hideDialogLoading();
                                       commonsTools.showMessageDialog(error);
                                   });
                       }//end if(data.model&&data.entity&&data.method)
                     }else{
                         $scope.notifyWindow("Erreur" ,"Aucun état n'est programmé","danger");
                     }
                  }else if(type=='report'){
                      var entity = $scope.currentObject;
                       if(extern==true){
                            entity = $scope.temporalData;
                       }//end if(extern==true){
                       var template = $scope.templateDataBuilder(data['template'],extern);
                      if(data.name && data.name!=""){
                          var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/reportrecord/byname/"+data.name;  
                          $http.get(url)
                                  .then(function(response){
                                      var report = response.data;
                                      if(report && report!=null){
                                          //Chargement des données du rapport dans le templateDatas
                                          var url2=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+data.model+"/"+data.entity+"/"+data.method;  
                                          $http.put(url2,entity)
                                                  .then(function(response){
                                                      $scope.temporalDatas = response.data;
                                                      $scope.customPrintAction(report.id,template);
                                                      commonsTools.hideDialogLoading();
                                                  },function(error){
                                                        commonsTools.hideDialogLoading();
                                                        commonsTools.showMessageDialog(error);
                                                  });                                          
                                      }else{
                                          $scope.notifyWindow("Erreur" ,"Impossible de trouver le template "+data.name,"danger");
                                      }//end if(report && report!=null){
                                      commonsTools.hideDialogLoading();
                                  },function(error){
                                      commonsTools.hideDialogLoading();
                                      commonsTools.showMessageDialog(error);
                                  });                          
                      }else if(data.model&&data.entity&&data.method){
//                           var template = $scope.templateDataBuilder(data['template']);
                           commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");                           
//                           console.log("$scope.buttonAction = function(data,type,states,index,extern) ================== innerWindow : "+$scope.innerWindowType+" ====== Type Window : "+$scope.windowType+" ===== extern : "+extern+" === data : "+angular.toJson(data));
                            var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+data.model+"/"+data.entity+"/bi/"+data.method;                        
                            $http.put(url,entity, {responseType: 'arraybuffer'})
                              .then(function(response){
                                    var contentElem = $scope.viewSelector("report");
//                               console.log(angular.toJson("$scope.addDialogAction ====== "+angular.toJson(response)));
                                    var viewer = document.createElement("iframe");
                                    viewer.setAttribute("id","iframe0001");
                                    viewer.setAttribute("src",url);
                                    viewer.setAttribute("alt","pdf");
                                    viewer.setAttribute("width","100%");
                                    viewer.setAttribute("height","700px");
     //                               viewer.setAttribute("pluginspage","http://www.adobe.com/products/acrobat/readstep2.html");
     //                               viewer.setAttribute("class","ng-isolate-scope");
                                    var divElem = document.createElement("div");
                                    divElem.setAttribute("id","report");
                                    divElem.setAttribute("width","100%");
                                    divElem.setAttribute("height","100%");
                                    divElem.appendChild(viewer);
                                    var items = contentElem.find('div');
                                     for(var i=0; i<items.length;i++){
                                        if(items.eq(i).attr("id")=="report"){
                                              items.eq(i).replaceWith(divElem);                               
                                        }  
                                    }//enn$d for(var i=0; i<items.length;i++){                               
                                    // ///Remplacement dans la vue
                                   var items = $element.find("div");
                                   for(var i=0; i<items.length;i++){
                                        if(items.eq(i).attr("id")=="innerpanel"){
                                              items.eq(i).replaceWith(contentElem);
                                               //console.log(" ======================= on a trouve report  innerpanel");
                                        }//end if(items.eq(i).attr("id")=="innerpanel")  
                                   }//end for(var i=0; i<items.length;i++)
                                    var compileFn = $compile(contentElem);
                                    compileFn($scope);                              
                                     var arrayBufferView = new Uint8Array(response.data );
                                     var blob = new Blob( [ arrayBufferView ], { type: "application/pdf" } );
                                     var urlCreator = window.URL || window.webkitURL;
                                     var pdfUrl = urlCreator.createObjectURL( blob );
                                     var pdf = document.querySelector( "#iframe0001");
                                     pdf.src = pdfUrl;
     //                               console.log($scope.temporalData);                      
                                     commonsTools.hideDialogLoading();
                                },function(error){
                                    commonsTools.hideDialogLoading();
                                    commonsTools.showMessageDialog(error);
                                });
                           //alert("Vous voulez executer la methode::: "+data.method+" de l'entite :: "+data.entity+" disponible sur la resource :: "+data.model+" data template : "+angular.toJson(template));
                       }//end if(data.model&&data.entity&&data.method)            
                  }else if(type=='download'){//Telechargement
                      if(data.model&&data.entity&&data.method){
                          commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                           var template = $scope.templateDataBuilder(data['template'],extern);
//                           $http.defaults.headers.common['states']=states;
                           for(var key in template){
                               if(angular.isDate(template[key])){
                                   $http.defaults.headers.common[key]=angular.toJson(template[key]);
                               }else if(angular.isObject(template[key])){
                                   $http.defaults.headers.common[key]=angular.toJson(template[key].id);
                               }else if(!angular.isArray(template[key])){
                                   $http.defaults.headers.common[key]=angular.toJson(template[key]);
                               } 
                           }//end for(var key in template){
//                           console.log("$scope.buttonAction = function(data,type,states,index,extern){ =============== extern : "+extern+"=== template : "+angular.toJson($http.defaults.headers.common));
                            var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+data.model+"/"+data.entity+"/"+data.method;   
                             var parts = template.linkfile.split(".");
                             var type = "application/pdf";
                             var extension = parts[parts.length-1];
                             if(extension=='pdf'){
//                                 url = url+'pdf/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='png'||extension=='jpeg'){
                                 type = "image/png";
//                                 url = url+'img/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='doc'||extension=='dot'){
                                 type = "application/msword";
//                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='docx'||extension=='dotx'){
                                 type = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
//                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='xls'||extension=='xlt'||extension=='xla'){
                                 type = "application/vnd.ms-excel";
//                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='xlsx'||extension=='xltx'){
                                 type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='ppt'||extension=='pot'||extension=='pps'||extension=='ppa'){
                                 type = "application/vnd.ms-powerpoint";
//                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='pptx'){
                                 type = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
//                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='mdb'){
                                 type = "application/vnd.ms-access";
//                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='rar'){
                                 type = "application/x-rar-compressed, application/octet-stream";
//                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='mdb'){
                                 type = "application/zip, application/octet-stream";
//                                 url = url+'file/'+pj.filename+'/'+pj.attachename;
                             }else if(extension=='txt'||extension=='sql'){
//                                 url = url+'text/'+pj.filename+'/'+pj.attachename;
                                 type = "text/plain";
                             }else{
                                 type = "";
                             }
                           $http.get(url, {responseType: "arraybuffer"})
                                     .then(function(response){
//                                         console.log("$scope.piecejointeviewAction  ============================================= "+angular.toJson(response));
//                                         var filename = response.headers['x-filename'];
//                                         var contentType = response.headers['content-type'];
                                         var linkElement = document.createElement('a');
                                         try{
                                                 var arrayBufferView = new Uint8Array(response.data );
                                                var blob = new Blob( [ arrayBufferView ], { type: type } );
                                                var urlCreator = window.URL || window.webkitURL;
                                                var docUrl = urlCreator.createObjectURL( blob );
                                                linkElement.setAttribute('href', docUrl);
                                                var today = new Date();
                                                var fileName = template.linkfile;                                                
                                                linkElement.setAttribute("download", fileName);
                                                var clickEvent = new MouseEvent("click", {
                                                    "view": window,
                                                    "bubbles": true,
                                                    "cancelable": false
                                                });
                                                linkElement.dispatchEvent(clickEvent);
                                         } catch (ex) {
                                           commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+ex.message,"danger");
                                        }
                                         commonsTools.hideDialogLoading();
                                     },function(error){
                                         commonsTools.hideDialogLoading();
                                         commonsTools.showMessageDialog(error);
                                     });
                      }//end if(data.model&&data.entity&&data.method){
                  }//end  if(type=='action'){
                    
                }//end  if(data){    
                 var modalID = "";
                 var endIndex = index;            
                 if(endIndex==1){
                    modalID = "myModal";
                 }else if(endIndex==2){
                    modalID = "globalModal";
                 }else if(endIndex==3){
                    modalID = "myModal1";
                 }else if(endIndex==4){
                    modalID = "myModal2";
                 }
                 $('#'+modalID).modal('hide');    
             }catch(ex){
//                 console.error(ex);
                 commonsTools.showMessageDialog(ex);
             }
        };
       /**
        * Construit un object a partir d'un template
        * name:
        * @param {type} template
        * @returns {undefined}
        */   
      $scope.templateDataBuilder = function(template,extern){
          
          if(template==null||!angular.isDefined(template)){
              return null;
          }//end if(template==null||!angular.isDefined(template)){
//          console.log("$scope.templateDataBuilder = function(template) ==================== "+extern);
          //Construction du template
          var data = new Object();
          for(var key in template){  
//              console.log("$scope.templateDataBuilder = function(template) ==================== "+angular.toJson(template)+" ::::: key : "+key+" === att : "+template[key]);
              var attr = template[key];
              if(key=='this'){
                  if(attr=='object'){
                      if(angular.isDefined(extern) && extern==true){
                          return $scope.temporalData;
                      }else{
                          return $scope.currentObject;
                      }//end if(angular.isDefined(extern) && extern==true){
                  }else if(attr=='user'){
                      return $rootScope.globals.user;
                  }//ed if(attr=='object'){
              }//end if(key=='this')
              var part = attr.split(".");             
              if(part.length>=1&&part[0].split('@').length==1){//Il sagit des champs
                  var value = null;
                  if(part[0]=='user'){
                     if($rootScope.globals.user){  
                        value = $rootScope.globals.user;
                     }//end if($rootScope.globals.user["'"+part[1]+"'"])
                  }else if(part[0]=='object'){
                      if(angular.isDefined(extern) && extern==true){
                          value =  $scope.temporalData;
                      }else{
                          if($scope.currentObject){
                                value = $scope.currentObject;
                          }//end if($scope.currentObject["'"+part[1]+"'"])
                      }//end if(angular.isDefined(extern) && extern==true){                      
                  }else{//Text a recopier
                      value = part[0];
                  }//end if(part[0]=='user')
                  for(var i=1 ; i<part.length;i++){
                      if(value[part[i]]){
                          value = value[part[i]];
                      }else{
                          value = null;
                          break ;
                      }//end if(value["'"+part[i]+'"'])
                  }//end for(var i=1 ; i<part.length;i++)
                  data[key] = value ;                  
              }else{//traitement des champs text
                  //console.log(key+" ================== "+attr);
                  var mesages = attr.split("@");
                  var msg = "";
                  if(mesages.length<=1){
                      data[key] = mesages ;
                  }else{
                        for(var i=0;i<mesages.length;i++){
                            //console.log(key+" ================== "+mesages[i]);
                            var block = mesages[i].split(".");
                            if(block.length==1){
                                if(i==0){
                                    msg = mesages[i];
                                }else{
                                    msg +=" @ "+mesages[i];
                                }//end if(i==0)
                            }else if(block.length>1){
                                  var value = null;
                                  if(block[0]=='user'){
                                      if($rootScope.globals.user){  
                                         value = $rootScope.globals.user;
                                      }//end if($rootScope.globals.user["'"+part[1]+"'"])
                                  }else if(block[0]=='object'){
                                      if($scope.currentObject){
                                          value = $scope.currentObject;
                                      }//end if($scope.currentObject["'"+part[1]+"'"])
                                  }//end if(part[0]=='user')
                                  for(var i=1 ; i<block.length;i++){
                                      if(value[block[i]]){
                                          value = value[block[i]];
                                      }else{
                                          value = null;
                                          break ;
                                      }//end if(value["'"+part[i]+'"'])
                                  }//end for(var i=1 ; i<part.length;i++)
                                  msg += " "+value ;           
                            }//end if(part.length==1)
                        }//end for(var i=0;i<mesages.length;i++)
                        data[key] = msg ; 
                    }//end if(mesages.length<=1){
              }//end if(part.length>=1&&part[0].split('@').length==1)
//              console.log(key+" ================== "+angular.toJson(data));
              //console.log(key+" ====== "+angular.toJson(data)+" === Current Data : "+angular.toJson($scope.currentObject)+" Current User :"+angular.toJson($rootScope.globals.user));
          }
                        
          return data ;
      };
      /**
       * Sorted table base of the value of fieldname
       * @param {type} column
       * @returns {undefined}
       */
      $scope.globaltablecolumnsorter = function(column){
          $scope.datas = $filter('orderBy')($scope.datas,column,false); 
      };
      $scope.currentSort ={
          column:null,
          reverse:false
      };
      /**
       * 
       * @param {type} item
       * @param {type} fieldname
       * @returns {undefined}
       */
      $scope.stateIcon = function(state){
          var states = angular.fromJson(angular.toJson($scope.metaData.states));
          for(var i=0 ; i<states.length;i++){
              if(states[i].code==state){
                  if(angular.isDefined(states[i].icone)
                          && states[i].icone!=null){
                      return states[i].icone;
                  }else{
                      return "fa fa-circle";
                  }
              }//end if(states[i].code===item[fieldname]){
          }//end for(var i=0 ; i<states.length;i++){
      };
      $scope.stateColor= function(state){
          var states = angular.fromJson(angular.toJson($scope.metaData.states));
          for(var i=0 ; i<states.length;i++){
              if(states[i].code==state){
                  if(angular.isDefined(states[i].couleur)
                          && states[i].couleur!=null){
//                      console.log("principal.stateIcon_10886 ============================== "+state+" ==== "+angular.toJson(states[i])+" ===== "+(states[i].code==state)+" ==== "+(angular.isDefined(states[i].icone)&& states[i].icone!=null));
                      return states[i].couleur;
                  }else{
                      return null;
                  }
              }//end if(states[i].code===item[fieldname]){
          }//end for(var i=0 ; i<states.length;i++){
      };
      /**
         Algorithme de creation du tableau     
       **/
         $scope.tableListComponent = function(metaData){
            $scope.currentSort.column =null;
            $scope.currentSort.reverse = false;
             var tableElem = document.createElement('table');
             tableElem.setAttribute('class' , 'table table-sm table-striped table-hover');
             tableElem.setAttribute('style' , 'margin-top: -10px;');
             tableElem.setAttribute('id' , 'table');
             //Creation du table header
             var theadElem = document.createElement('thead');
             tableElem.appendChild(theadElem);
             //Creation entete
             var  rheadElem = document.createElement('tr');
             rheadElem.setAttribute('class' ,'table-header');
             theadElem.appendChild(rheadElem);
             var thElem0 = document.createElement('th');
             var inputElem0 = document.createElement('input');
             inputElem0.setAttribute('type' , 'checkbox');
             inputElem0.setAttribute('ng-model' , 'tableheaderselected');
             inputElem0.setAttribute('ng-click' , 'onCheckboxClick()');
            thElem0.appendChild(inputElem0);
            rheadElem.appendChild(thElem0);
            //Array of field name
            var fieldnames = new Array();
            var fieldtypes = new Array();
            //Contient des reference au champs de type combobox
            var comboMap = new Object();
            //Traitement des champs columns
            if(metaData.columns){
                //Sort of array
                metaData.columns = $filter('orderBy')(metaData.columns,'colsequence',false);             
                for(var i=0 ; i< metaData.columns.length;i++){
                  if(angular.isDefined(metaData.columns[i].search)
                            &&(metaData.columns[i].search==true)){
                      if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'){  //&&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'
                            var thElem = document.createElement('th');
                            thElem.innerHTML = metaData.columns[i].fieldLabel+" <span ng-show=down('"+metaData.columns[i].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.columns[i].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                            thElem.setAttribute("ng-click","listeSorter('"+metaData.columns[i].fieldName+"')");
                            rheadElem.appendChild(thElem);
                            fieldnames.push( metaData.columns[i].fieldName);
                            if(metaData.columns[i].type=='number'){
                                fieldtypes.push(true);
                            }else{
//                                if(metaData.columns[i].type=='combobox'){
//                                    comboMap[metaData.columns[i].fieldName]= metaData.columns[i].value.split(";");
//                                }//end if(metaData.columns[i].type=='combobox'){
                                fieldtypes.push(false);
                            }//end if(metaData.columns[i].type=='number')
                       }//end if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'&&metaData.columns[i]
                   }//end if(angular.isDefined(metaData.columns[i].search)
                }
            }//end if(metaData.columns){
            //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){
                                 if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image'){   //&&metaData.groups[i].columns[j].type.type!='textarea'&&metaData.groups[i].columns[j].type.type!='richeditor'
                                    var thElem = document.createElement('th');
                                    thElem.innerHTML = metaData.groups[i].columns[j].fieldLabel+" <span ng-show=down('"+metaData.groups[i].columns[j].fieldName+"')==true class='glyphicon glyphicon-chevron-down' aria-hidden='true' ></span> <span ng-show=up('"+metaData.groups[i].columns[j].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                                    thElem.setAttribute("ng-click","listeSorter('"+metaData.groups[i].columns[j].fieldName+"')");
                                    rheadElem.appendChild(thElem);
                                    fieldnames.push(metaData.groups[i].columns[j].fieldName);
                                    if(metaData.groups[i].columns[j].type=='number'){
                                        fieldtypes.push(true);
                                    }else{
//                                        if(metaData.groups[i].columns[j].type=='combobox'){
//                                            comboMap[metaData.groups[i].columns[j].fieldName]= metaData.groups[i].columns[j].value.split(";");
//                                        }//end if(metaData.columns[i].type=='combobox'){
                                        fieldtypes.push(false);
                                    }
                                }//end if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image')
                            }
                        }//end For
                    }//Fin traitement des colommes
                }
            }//end if(metaData.groups){
             var thElem = document.createElement('th');
             rheadElem.appendChild(thElem);
            //Creation du corps du tableau
            var tbodyElem = document.createElement('tbody');
            tableElem.appendChild(tbodyElem);
            var rbodyElem = document.createElement('tr');
            rbodyElem.setAttribute('ng-repeat' , ' obj in datas');
            tbodyElem.appendChild(rbodyElem);
            var tdElem = document.createElement('td');
            rbodyElem.appendChild(tdElem);
            rbodyElem.setAttribute('style' , "cursor: pointer;");
            inputElem0 = document.createElement('input');
            inputElem0.setAttribute('type' , 'checkbox');
            inputElem0.setAttribute('ng-model' , 'obj.selected');
            inputElem0.setAttribute('ng-click' , 'onRowCheckboxClick(obj)');
            tdElem.appendChild(inputElem0);
            for(var i=0 ; i< metaData.columns.length;i++){
                  if(angular.isDefined(metaData.columns[i].search)
                        &&(metaData.columns[i].search==true)){//end &&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'
                      if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'){  
                        var thElem = document.createElement('td');
                        thElem.setAttribute('ng-click' , "viewAction(obj)");
                        if(metaData.columns[i].type=='object'){
                          thElem.innerHTML = "{{obj."+metaData.columns[i].fieldName+".designation}}";
                        }else if(metaData.columns[i].type=='combobox'){
                            thElem.innerHTML = "{{comboboxselctionvalues(obj."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}";
                        }else if(metaData.columns[i].type=='radio'){
                            thElem.innerHTML = "{{radioselctionvalues(obj."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}";
                        }else if(metaData.columns[i].type=='color'){
                            thElem.setAttribute('style',"background-color:{{obj."+metaData.columns[i].fieldName+"}};");
//                            thElem.innerHTML = "{{comboboxselctionvalues(obj."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}";
                        }else if(metaData.columns[i].type=='state'){
                            var ielem = document.createElement('i');
                            ielem.setAttribute('class',"{{stateIcon(obj."+metaData.columns[i].fieldName+")}}");
                            ielem.setAttribute("style","color:{{stateColor(obj."+metaData.columns[i].fieldName+")}};");
                            thElem.appendChild(ielem);
                        }else if(metaData.columns[i].type=='boolean'){
                            var input = document.createElement('input');
                            input.setAttribute('type' , 'checkbox');
                            input.setAttribute('ng-model' , 'obj.'+metaData.columns[i].fieldName);
                            thElem.appendChild(input);
                        }else if(metaData.columns[i].type=='date'){
                            if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                thElem.innerHTML = '{{obj.'+metaData.columns[i].fieldName+' | date:"'+$rootScope.globals.langue.formatDate+'"}}';
                            }else{
                                thElem.innerHTML = '{{obj.'+metaData.columns[i].fieldName+' | date:"dd-MM-yyyy"}}';
                            }//end if($rootScope.globals.langue && $rootScope.globals.langue.formatDate)
                        }else if(metaData.columns[i].type=='number'){
                                thElem.innerHTML = "{{obj."+metaData.columns[i].fieldName+" | number:0}}";            
                        }else{                            
                          thElem.innerHTML = "{{obj."+metaData.columns[i].fieldName+"}}";
                        }//end if(metaData.columns[i].type=='object'){
                        if(metaData.columns[i].type=='number'){
                            thElem.setAttribute('class','text-center');
                        }
                        rbodyElem.appendChild(thElem);
                     }
                  }
             }//end for(var i=0 ; i< metaData.columns.length;i++){
             //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){//&&metaData.groups[i].columns[j].type!='textarea'&&metaData.groups[i].columns[j].type!='richeditor'
                                  if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image'){   
                                    var thElem = document.createElement('td');
                                    thElem.setAttribute('ng-click' , "viewAction(obj)");
                                    if(metaData.groups[i].columns[j].type=='object'){
                                      thElem.innerHTML = "{{obj."+metaData.groups[i].columns[j].fieldName+".designation}}";
                                    }else if(metaData.groups[i].columns[j].type=='combobox'){
                                        thElem.innerHTML = "{{comboboxselctionvalues(obj."+metaData.groups[i].columns[j].fieldName+",'"+metaData.groups[i].columns[j].value+"')}}";
                                    }else if(metaData.groups[i].columns[j].type=='radio'){
                                        thElem.innerHTML = "{{radioselctionvalues(obj."+metaData.groups[i].columns[j].fieldName+",'"+metaData.groups[i].columns[j].value+"')}}";
                                    }else if(metaData.groups[i].columns[j].type=='color'){
                                        thElem.setAttribute('style',"background-color:{{obj."+metaData.groups[i].columns[j].fieldName+"}};");
            //                            thElem.innerHTML = "{{comboboxselctionvalues(obj."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}";
                                    }else if(metaData.groups[i].columns[j].type=='boolean'){
                                        var input = document.createElement('input');
                                        input.setAttribute('type' , 'checkbox');
                                        input.setAttribute('ng-model' , 'obj.'+metaData.groups[i].columns[j].fieldName);
                                        thElem.appendChild(input);
                                    }else if(metaData.groups[i].columns[j].type=='date'){
                                        if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                            thElem.innerHTML = '{{obj.'+metaData.groups[i].columns[j].fieldName+' | date:"'+$rootScope.globals.langue.formatDate+'"}}';  
                                        }else{
                                            thElem.innerHTML = '{{obj.'+metaData.groups[i].columns[j].fieldName+' | date:"dd-MM-yyyy"}}';  
                                        }//end if($rootScope.globals.langue && $rootScope.globals.langue.formatDate){
                                    }else if(metaData.groups[i].columns[j].type=='number'){
                                        thElem.innerHTML = "{{obj."+metaData.groups[i].columns[j].fieldName+" | number:0}}";            
                                    }else{
                                      thElem.innerHTML = "{{obj."+metaData.groups[i].columns[j].fieldName+"}}";                                      
                                    }//end if(metaData.groups[i].columns[j].type=='object'){
                                    if(metaData.groups[i].columns[j].type=='number'){
                                        thElem.setAttribute('class','text-center');
                                    }
                                    rbodyElem.appendChild(thElem);
                                }//end if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image')
                            }
                        }//end For
                    }//Fin traitement des colommes
                }
            }//end if(metaData.groups){
            //Span
//            var spanElem = document.createElement("span");
//            spanElem.setAttribute("class" ,"glyphicon glyphicon-option-vertical pull-right");
            var tdelem = document.createElement('td');
            commonsTools.menusActions($scope,tdelem,1,'obj');
            rbodyElem.appendChild(tdelem);
            //Construction du footer du tableau
            var footerElem = document.createElement('tfoot');
            footerElem.setAttribute('style','background-color: #eeeeee;');
            var trElem = document.createElement('tr');
            var thElem = document.createElement('th');
            trElem.appendChild(thElem);
            footerElem.appendChild(trElem);
            var numeric_fields = 0 ;
            for(var i=0;i<fieldnames.length;i++){
                var total = null;
                if(fieldtypes[i]==true){
                    total = commonsTools.sumTableField(fieldnames[i],$scope.datas);
//                    console.log("$scope.tableListComponent === begin  "+i+" ****** "+fieldnames[i]+"=== "+total);
                }
                thElem = document.createElement('th');
                trElem.appendChild(thElem);      
                if(total){                    
                    numeric_fields++ ;
                    thElem.appendChild(document.createTextNode(total));
                    thElem.setAttribute('class','text-center');
                }//end if(total)
            }//end for(var i=0;i<fieldnames.length;i++){
            var thElem = document.createElement('th');
            trElem.appendChild(thElem);
            if(numeric_fields>0){
                tableElem.appendChild(footerElem);
            }//end if(numeric_fields>0)
//             var divElem = document.createElement('div');            
            return tableElem;
         };
         /**
          * 
          * @param {type} metaData
          * @returns {unresolved}
          */
         $scope.editableTableListComponent = function(metaData){
            $scope.currentSort.column =null;
            $scope.currentSort.reverse = false;
             var tableElem = document.createElement('table');
             tableElem.setAttribute('class' , 'table table-sm table-striped table-hover');
             tableElem.setAttribute('style' , 'margin-top: -10px;');
             tableElem.setAttribute('id' , 'table');
             //Creation du table header
             var theadElem = document.createElement('thead');
             tableElem.appendChild(theadElem);
             //Creation entete
             var  rheadElem = document.createElement('tr');
             rheadElem.setAttribute('class' ,'table-header');
             theadElem.appendChild(rheadElem);
             var thElem0 = document.createElement('th');
             var inputElem0 = document.createElement('input');
             inputElem0.setAttribute('type' , 'checkbox');
             inputElem0.setAttribute('ng-model' , 'tableheaderselected');
             inputElem0.setAttribute('ng-click' , 'onCheckboxClick()');
            thElem0.appendChild(inputElem0);
            rheadElem.appendChild(thElem0);
            //Array of field name
            var fieldnames = new Array();
            var fieldtypes = new Array();
            //Contient des reference au champs de type combobox
            var comboMap = new Object();
            //Traitement des champs columns
            if(metaData.columns){
                //Sort of array
                metaData.columns = $filter('orderBy')(metaData.columns,'colsequence',false);             
                for(var i=0 ; i< metaData.columns.length;i++){
                  if(angular.isDefined(metaData.columns[i].search)
                            &&(metaData.columns[i].search==true)){
                      if(metaData.columns[i].type!='image'){  //metaData.columns[i].type!='array'&&&&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'
                            var thElem = document.createElement('th');
                            thElem.innerHTML = metaData.columns[i].fieldLabel+" <span ng-show=down('"+metaData.columns[i].fieldName+"')==true  class='glyphicon glyphicon-chevron-down' aria-hidden='true'></span> <span ng-show=up('"+metaData.columns[i].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                            thElem.setAttribute("ng-click","listeSorter('"+metaData.columns[i].fieldName+"')");
                            rheadElem.appendChild(thElem);
                            fieldnames.push( metaData.columns[i].fieldName);
                            if(metaData.columns[i].type=='number'){
                                fieldtypes.push(true);
                            }else{
//                                if(metaData.columns[i].type=='combobox'){
//                                    comboMap[metaData.columns[i].fieldName]= metaData.columns[i].value.split(";");
//                                }//end if(metaData.columns[i].type=='combobox'){
                                fieldtypes.push(false);
                            }//end if(metaData.columns[i].type=='number')
                       }//end if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'&&metaData.columns[i]
                   }//end if(angular.isDefined(metaData.columns[i].search)
                }
            }//end if(metaData.columns){
            //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){
                                 if(metaData.groups[i].columns[j].type!='image'){   //metaData.groups[i].columns[j].type!='array'&&&&metaData.groups[i].columns[j].type.type!='textarea'&&metaData.groups[i].columns[j].type.type!='richeditor'
                                    var thElem = document.createElement('th');
                                    thElem.innerHTML = metaData.groups[i].columns[j].fieldLabel+" <span ng-show=down('"+metaData.groups[i].columns[j].fieldName+"')==true class='glyphicon glyphicon-chevron-down' aria-hidden='true' ></span> <span ng-show=up('"+metaData.groups[i].columns[j].fieldName+"')==true class='glyphicon glyphicon-chevron-up' aria-hidden='true' ></span>";
                                    thElem.setAttribute("ng-click","listeSorter('"+metaData.groups[i].columns[j].fieldName+"')");
                                    rheadElem.appendChild(thElem);
                                    fieldnames.push(metaData.groups[i].columns[j].fieldName);
                                    if(metaData.groups[i].columns[j].type=='number'){
                                        fieldtypes.push(true);
                                    }else{
//                                        if(metaData.groups[i].columns[j].type=='combobox'){
//                                            comboMap[metaData.groups[i].columns[j].fieldName]= metaData.groups[i].columns[j].value.split(";");
//                                        }//end if(metaData.columns[i].type=='combobox'){
                                        fieldtypes.push(false);
                                    }
                                }//end if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image')
                            }
                        }//end For
                    }//Fin traitement des colommes
                }
            }//end if(metaData.groups){
             var thElem = document.createElement('th');
             rheadElem.appendChild(thElem);
            //Creation du corps du tableau
            var tbodyElem = document.createElement('tbody');
            tableElem.appendChild(tbodyElem);
            var rbodyElem = document.createElement('tr');
            rbodyElem.setAttribute('ng-repeat' , ' obj in datas');
            tbodyElem.appendChild(rbodyElem);
//            var tdElem = document.createElement('td');
//            rbodyElem.appendChild(tdElem);
            rbodyElem.setAttribute('style' , "cursor: pointer;");
            var key = "currentobject";
            $scope.dataCache["row"+key] = null;
            $scope.listDisplayTemplate(metaData,rbodyElem,key,0);
            //Construction du footer du tableau
            var footerElem = document.createElement('tfoot');
            footerElem.setAttribute('style','background-color: #eeeeee;');
            var trElem = document.createElement('tr');
            var thElem = document.createElement('th');
            trElem.appendChild(thElem);
            footerElem.appendChild(trElem);
            var numeric_fields = 0 ;
            for(var i=0;i<fieldnames.length;i++){
                var total = null;
                if(fieldtypes[i]==true){
                    total = commonsTools.sumTableField(fieldnames[i],$scope.datas);
//                    console.log("$scope.tableListComponent === begin  "+i+" ****** "+fieldnames[i]+"=== "+total);
                }
                thElem = document.createElement('th');
                trElem.appendChild(thElem);      
                if(total){                    
                    numeric_fields++ ;
                    thElem.appendChild(document.createTextNode(total));
                    thElem.setAttribute('class','text-center');
                }//end if(total)
            }//end for(var i=0;i<fieldnames.length;i++){
            thElem = document.createElement('th');
            trElem.appendChild(thElem);     
            if(numeric_fields>0){
                tableElem.appendChild(footerElem);
            }//end if(numeric_fields>0)
//             var divElem = document.createElement('div');            
            return tableElem;
         };
         /**
          * 
          * @param {type} fieldname
          * @returns {Boolean}
          */
         $scope.up = function(fieldname){
//             console.log("$scope.up = function(fieldname) ======================= "+fieldname);
             return $scope.currentSort.column==fieldname&&$scope.currentSort.reverse==false;
         };
         /**
          * 
          * @param {type} fieldname
          * @returns {Boolean}
          */
         $scope.down = function(fieldname){
//             console.log("$scope.down = function(fieldname) ======================= "+fieldname);
              return $scope.currentSort.column==fieldname&&$scope.currentSort.reverse==true;
         };
         /**
          * 
          * @returns {undefined}
          */
         $scope.listeSorter = function(fieldname){
             if($scope.currentSort.column==fieldname){
                 $scope.currentSort.reverse = !$scope.currentSort.reverse;
             }else{
                 $scope.currentSort.column = fieldname;
                 $scope.currentSort.reverse = false;
             }//end if($scope.currentSort.column==fieldname)
//             console.log("$scope.listeSorter = function(fieldname)============= column : "+$scope.currentSort.column+"  reverse : "+$scope.currentSort.reverse);
             $scope.datas = $filter('orderBy')($scope.datas,fieldname,$scope.currentSort.reverse);
//             if($scope.currentSort.reverse==true){
//                 $scope.datas = $filter('orderBy')($scope.datas,fieldname,false);
//             }else {
//                   $scope.datas = $filter('orderBy')($scope.datas,fieldname,false);
//             }//end if($scope.currentSort.reverse==true)
         };
           /**
           * Tree view Builder
           * @param {type} metaData
           * @returns {undefined}
           */
         $scope.tableTreeComponent = function(metaData){
            var tableElem = document.createElement('table');
             tableElem.setAttribute('class' , 'table tree');
             tableElem.setAttribute('style' , 'margin-top: -10px;');
             tableElem.setAttribute('id' , 'table');
             //Creation du table header
             var theadElem = document.createElement('thead');
             tableElem.appendChild(theadElem);
             //Creation entete
             var  rheadElem = document.createElement('tr');
             rheadElem.setAttribute('class' ,'table-header');
             theadElem.appendChild(rheadElem);
             var thElem0 = document.createElement('th');
             var inputElem0 = document.createElement('input');
             inputElem0.setAttribute('type' , 'checkbox');
             inputElem0.setAttribute('ng-model' , 'tableheaderselected');
             inputElem0.setAttribute('ng-click' , 'onCheckboxClick()');
            thElem0.appendChild(inputElem0);
            rheadElem.appendChild(thElem0);
            //Array of field name
            var fieldnames = new Array();
            var fieldtypes = new Array();
            //Contient des reference au champs de type combobox
            var comboMap = new Object();
            //Traitement des champs columns
            if(metaData.columns){
                //Sort of array
                metaData.columns = $filter('orderBy')(metaData.columns,'colsequence',false);             
                for(var i=0 ; i< metaData.columns.length;i++){
                  if(angular.isDefined(metaData.columns[i].search)
                            &&(metaData.columns[i].search==true)){
                      if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'){  //&&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'
                            var thElem = document.createElement('th');
                            thElem.innerHTML = metaData.columns[i].fieldLabel;
                            rheadElem.appendChild(thElem);
                            fieldnames.push( metaData.columns[i].fieldName);
                            if(metaData.columns[i].type=='number'){
                                fieldtypes.push(true);
                            }else{
//                                if(metaData.columns[i].type=='combobox'){
//                                    comboMap[metaData.columns[i].fieldName]= metaData.columns[i].value.split(";");
//                                }//end if(metaData.columns[i].type=='combobox'){
                                fieldtypes.push(false);
                            }//end if(metaData.columns[i].type=='number')
                       }//end if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'&&metaData.columns[i]
                   }//end if(angular.isDefined(metaData.columns[i].search)
                }
            }//end if(metaData.columns){
            //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){
                                 if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image'){   //&&metaData.groups[i].columns[j].type.type!='textarea'&&metaData.groups[i].columns[j].type.type!='richeditor'
                                    var thElem = document.createElement('th');
                                    thElem.innerHTML = metaData.groups[i].columns[j].fieldLabel;
                                    rheadElem.appendChild(thElem);
                                    fieldnames.push(metaData.groups[i].columns[j].fieldName);
                                    if(metaData.groups[i].columns[j].type=='number'){
                                        fieldtypes.push(true);
                                    }else{
//                                        if(metaData.groups[i].columns[j].type=='combobox'){
//                                            comboMap[metaData.groups[i].columns[j].fieldName]= metaData.groups[i].columns[j].value.split(";");
//                                        }//end if(metaData.columns[i].type=='combobox'){
                                        fieldtypes.push(false);
                                    }
                                }//end if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image')
                            }
                        }//end For
                    }//Fin traitement des colommes
                }
            }//end if(metaData.groups){

            //Creation du corps du tableau
            var tbodyElem = document.createElement('tbody');
            tableElem.appendChild(tbodyElem);
            var rbodyElem = document.createElement('tr');
            rbodyElem.setAttribute('ng-repeat' , ' obj in datas');
            tbodyElem.appendChild(rbodyElem);
            var tdElem = document.createElement('td');
            rbodyElem.appendChild(tdElem);
            rbodyElem.setAttribute('style' , "cursor: pointer;");
            inputElem0 = document.createElement('input');
            inputElem0.setAttribute('type' , 'checkbox');
            inputElem0.setAttribute('ng-model' , 'obj.selected');
            inputElem0.setAttribute('ng-click' , 'onRowCheckboxClick(obj)');
            tdElem.appendChild(inputElem0);
            for(var i=0 ; i< metaData.columns.length;i++){
                  if(angular.isDefined(metaData.columns[i].search)
                        &&(metaData.columns[i].search==true)){//end &&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'
                      if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'){  
                        var thElem = document.createElement('td');
                        thElem.setAttribute('ng-click' , "viewAction(obj)");
                        if(metaData.columns[i].type=='object'){
                          thElem.innerHTML = "{{obj."+metaData.columns[i].fieldName+".designation}}";
                        }else if(metaData.columns[i].type=='combobox'){
                            thElem.innerHTML = "{{comboboxselctionvalues(obj."+metaData.columns[i].fieldName+",'"+metaData.columns[i].value+"')}}";
                        }else{                            
                          thElem.innerHTML = "{{obj."+metaData.columns[i].fieldName+"}}";
                        }//end if(metaData.columns[i].type=='object'){
                        if(metaData.columns[i].type=='number'){
                            thElem.setAttribute('class','text-right');
                        }
                        rbodyElem.appendChild(thElem);
                     }
                  }
             }//end for(var i=0 ; i< metaData.columns.length;i++){
             //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){//&&metaData.groups[i].columns[j].type!='textarea'&&metaData.groups[i].columns[j].type!='richeditor'
                                  if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image'){   
                                    var thElem = document.createElement('td');
                                    thElem.setAttribute('ng-click' , "viewAction(obj)");
                                    if(metaData.groups[i].columns[j].type=='object'){
                                      thElem.innerHTML = "{{obj."+metaData.groups[i].columns[j].fieldName+".designation}}";
                                    }else if(metaData.groups[i].columns[j].type=='combobox'){
                                        thElem.innerHTML = "{{comboboxselctionvalues(obj."+metaData.groups[i].columns[j].fieldName+",'"+metaData.groups[i].columns[j].value+"')}}";
                                    }else{
                                      thElem.innerHTML = "{{obj."+metaData.groups[i].columns[j].fieldName+"}}";                                      
                                    }
                                    if(metaData.groups[i].columns[j].type=='number'){
                                        thElem.setAttribute('class','text-right');
                                    }
                                    rbodyElem.appendChild(thElem);
                                }//end if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image')
                            }
                        }//end For
                    }//Fin traitement des colommes
                }
            }//end if(metaData.groups){
            //Construction du footer du tableau
            var footerElem = document.createElement('tfoot');
            footerElem.setAttribute('style','background-color: #eeeeee;');
            var trElem = document.createElement('tr');
            var thElem = document.createElement('th');
            trElem.appendChild(thElem);
            footerElem.appendChild(trElem);
            var numeric_fields = 0 ;
            for(var i=0;i<fieldnames.length;i++){
                var total = null;
                if(fieldtypes[i]==true){
                    total = commonsTools.sumTableField(fieldnames[i],$scope.datas);
//                    console.log("$scope.tableListComponent === begin  "+i+" ****** "+fieldnames[i]+"=== "+total);
                }
                thElem = document.createElement('th');
                trElem.appendChild(thElem);      
                if(total){                    
                    numeric_fields++ ;
                    thElem.appendChild(document.createTextNode(total));
                    thElem.setAttribute('class','text-right');
                }//end if(total)
            }//end for(var i=0;i<fieldnames.length;i++){
            if(numeric_fields>0){
                tableElem.appendChild(footerElem);
            }//end if(numeric_fields>0)
             var divElem = document.createElement('div');            
            return tableElem;
         };
         /**
          * 
          * @param {type} selectedValue
          * @param {type} value
          * @returns {undefined}
          */
         $scope.comboboxselctionvalues = function(selectedValue,value){
//             console.log("$scope.comboboxselctionvalues = function(selectedValue,value){ =========== "+selectedValue+" ==== "+value)
             var values = value.split(";");
             var index = new Number(selectedValue);
             return values[index];
         };
         /**
          * 
          * @param {type} selectedValue
          * @param {type} value
          * @returns {principal_L973.principalAnonym$41.controller.$scope.radioselctionvalues.values}
          */
         $scope.radioselctionvalues = function(selectedValue,value){
//             console.log("$scope.comboboxselctionvalues = function(selectedValue,value){ =========== "+selectedValue+" ==== "+value)
             var values = value.split(";");
             var index = new Number(selectedValue);
             return values[index];
         };
        /**
         * Algorithme de creation du tableau    
         * @param {type} metaData
         * @returns {Element}
         */
         $scope.tableListComponentReport = function(metaData){
            var divresponsive = document.createElement("div");
            divresponsive.setAttribute("class","table-responsive");
             var tableElem = document.createElement('table');
//             tableElem.setAttribute('style','border:solid 1px;')
             divresponsive.appendChild(tableElem);     
             var columns = new Array();
             tableElem.setAttribute('class' , 'table  table-condensed');
             tableElem.setAttribute('style' , 'width: 100%;');
             tableElem.setAttribute('id' , 'table');
             //Creation du table header
             var theadElem = document.createElement('thead');
//             theadElem.setAttribute('style','display: table-header-group;vertical-align: middle; border-color: inherit;');
             tableElem.appendChild(theadElem);
             //Creation entete
             var  rheadElem = document.createElement('tr');
//             rheadElem.setAttribute('class' , 'small');
             theadElem.appendChild(rheadElem);
//             rheadElem.setAttribute('style','border:solid 5px;position: center;');
            //Traitement des champs columns
            if(metaData.columns){
                //Sort of array
                metaData.columns = $filter('orderBy')(metaData.columns,'colsequence',false);  
                var k =0;
                for(var i=0 ; i< metaData.columns.length;i++){
                  if(angular.isDefined(metaData.columns[i].search)
                            &&(metaData.columns[i].search==true)){
                      if(metaData.columns[i].type!='array'&&metaData.columns[i].type!='image'&&metaData.columns[i].type!='textarea'&&metaData.columns[i].type!='richeditor'){  
                            var thElem = document.createElement('th');
                            thElem.setAttribute("style","font-size: small;");
                            thElem.setAttribute("class","text-center small");
                            thElem.appendChild(document.createTextNode(metaData.columns[i].fieldLabel))  ;
                            columns[k]=metaData.columns[i].fieldName;
                            k++;
                            rheadElem.appendChild(thElem);
                       }//end if(metaData.columns[i].type!='array'
                     }//end if(angular.isDefined(metaData.columns[i].search)
                }
            }
            //Traitement des groups
            if(metaData.groups){
                //Cas des columns
                for(var i=0 ; i<metaData.groups.length;i++){
                    if(metaData.groups[i]&&metaData.groups[i].columns){
                        for(var j=0 ; j< metaData.groups[i].columns.length;j++){
                            if(angular.isDefined(metaData.groups[i].columns[j].search)
                                      &&(metaData.groups[i].columns[j].search==true)){
                                 if(metaData.groups[i].columns[j].type!='array'&&metaData.groups[i].columns[j].type!='image'
                                         &&metaData.groups[i].columns[j].type.type!='textarea'&&metaData.groups[i].columns[j].type.type!='richeditor'){   
                                    var thElem = document.createElement('th');
                                    thElem.setAttribute("style","font-size: small;");
                                    thElem.setAttribute("class","text-center small");
                                    thElem.appendChild(document.createTextNode(metaData.groups[i].columns[j].fieldLabel));
                                    columns[k]=metaData.groups[i].columns[j].fieldName;
                                     k++;
                                    rheadElem.appendChild(thElem);
                                }
                            }
                        }//end For
                    }//Fin traitement des colommes
                }
            }

            //Creation du corps du tableau
            var tbodyElem = document.createElement('tbody');
            tableElem.appendChild(tbodyElem);            
 
            for(var i=0 ; i< $scope.selectedObjects.length;i++){
                    var data = $scope.selectedObjects[i];
                    var rbodyElem = document.createElement('tr');   
                    //rbodyElem.setAttribute('class','small');
                    tbodyElem.appendChild(rbodyElem);
                    for(var j=0 ; j<columns.length;j++){ 
                        /*if(data[columns[j]])*/{   
                             var tdElem = document.createElement('td');
                            rbodyElem.appendChild(tdElem);
                            tdElem.setAttribute("style","font-size: small;");
                            tdElem.setAttribute("class","text-center small");
                            var col = data[columns[j]];
                            //console.log(columns[j]+"=============="+angular.toJson(col));                        
                            if(angular.isObject(col)){
                                tdElem.appendChild(document.createTextNode(col['designation']));
                            }else if(col){
                                 tdElem.appendChild(document.createTextNode(col));
//                                tdElem.innerHTML = col;
                                 if(angular.isNumber(col)){
                                     tdElem.setAttribute("class","text-right small");
                                 }//end if(angular.isNumber(col))
                            }else{
                                tdElem.appendChild(document.createTextNode(""));
                            }//end if(col['designation'])
                            //var tdElem = document.createElement('td');
                            //rbodyElem.appendChild(tdElem);
                        }
                       
                    }
                    
             }//construction du tableau        

            var divElem = document.createElement('div');
            divElem.appendChild(divresponsive);
//            console.log(divElem.innerHTML);
            return divresponsive;
         };
      
         /**
          * Fonction de construction du filtre de recherche
          * @param {type} metaData
          * @param {type} elementID: porte de l'element
          * @returns {unresolved}
          */
         $scope.filterOptionsComponent = function(metaData,elementID){
               if($scope.currentAction&&angular.isString($scope.currentAction)){
                   $scope.currentAction = angular.fromJson($scope.currentAction);
               }//end if($scope.currentAction&&angular.isString($scope.currentAction)){
                var ulElem = document.createElement('ul');
               ulElem.setAttribute('class','dropdown-menu');
               ulElem.setAttribute('role' , 'menu');
               ulElem.setAttribute('aria-labelledby' , 'filterbtn');
               ulElem.setAttribute('ng-repeat' , ' obj in metaData');
               if(!angular.isDefined(elementID)){
                    $scope.desablecreate = metaData.desablecreate || !$scope.canCreate();
                    $scope.desableupdate = !$scope.canUpdate();
                    $scope.desabledelete = !$scope.canDelete();
                    $scope.desableprint = !$scope.canPrint();
                    ulElem.setAttribute('id' , 'filterActionsId');               
                }else {
                    ulElem.setAttribute('id' , elementID);                   
                }//end if(!angular.isDefined(porte)){
//               console.log("$scope.filterOptionsComponent  desablecreate = "+angular.toJson($scope.metaData));
               //Initialisation de la lisif(!$scope.predicats){
              
                var j = 0 ;
               for(var i=0 ; i< metaData.columns.length;i++){
                 if(angular.isDefined(metaData.columns[i].search)
                        &&(metaData.columns[i].search==true)){                  
                     var predicat = new Object();
                     predicat['fieldName'] = metaData.columns[i].fieldName;
                     predicat['fieldLabel'] = metaData.columns[i].fieldLabel;
                     if(!angular.isDefined(elementID)){
                         predicat['value'] = angular.isDefined($scope.predicats[j]) ? $scope.predicats[j].value : null; 
                     }else{
                        predicat['value'] = angular.isDefined($scope.temporalPredicats[j]) ? $scope.temporalPredicats[j].value : null;  
                     }//end if(!angular.isDefined(elementID)){
                     predicat['type'] = 'EQUAL';
                     predicat['target'] = 'string';
                     predicat['searchfields'] = metaData.columns[i].searchfields;
                     if(!angular.isDefined(elementID)){
                          $scope.predicats[j] = predicat;
                     }else{
                         $scope.temporalPredicats[j] =predicat;
                     }//end if(!angular.isDefined(elementID)){                    
                     //if($scope.predicats)
                     var liElem = document.createElement('li');
                     liElem.setAttribute('role' , 'presentation');
                     ulElem.appendChild(liElem);
                     //  alert("TATATATATATA === "+metaData.columns[i].type);        
                    if(metaData.columns[i].type!='array'){
                        if(metaData.columns[i].type!='image'){ 
                             //creation d'un predicat
                              var aElem = document.createElement('span');
                             //aElem.setAttribute('style' , 'border:');
                             //aElem.setAttribute()
                             aElem.setAttribute('role' , 'menuitem');
                             aElem.setAttribute('tabindex' , '-1');
                             aElem.setAttribute('href' , '#');
                             liElem.appendChild(aElem);
                             var spanElem = document.createElement('span');
                             aElem.appendChild(spanElem);
                             var inputElem = document.createElement('input');
                             spanElem.appendChild(inputElem);
                             //inputElem.setAttribute('ng-model' , 'obj.value');
                             inputElem.setAttribute('style' , 'border:none;');
                             if(metaData.columns[i].type=='string'){
                                predicat['type'] = 'LIKE';
                                inputElem.setAttribute('type' , 'text');
                             }else if(metaData.columns[i].type=='number'){
                                 predicat['type'] = 'EQUAL';
                                 predicat['target'] = 'number';
                               inputElem.setAttribute('type' , 'number');
                             }else if(metaData.columns[i].type=='date'){
                               predicat['type'] = 'EQUAL';
                               predicat['target'] = 'date';
                               inputElem.setAttribute('type' , 'date');
                             }else if(metaData.columns[i].type=='tel'){
                               inputElem.setAttribute('type' , 'tel');
                             }else if(metaData.columns[i].type=='email'){
                               inputElem.setAttribute('type' , 'email');
                             }else if(metaData.columns[i].type=='url'){
                               inputElem.setAttribute('type' , 'url');
                             }else if(metaData.columns[i].type=='time'){
                               inputElem.setAttribute('type' , 'time');
                             }else if(metaData.columns[i].type=='datetime'){
                                 predicat['target'] = 'date';
                               inputElem.setAttribute('type' , 'datetime');
                             }else if(metaData.columns[i].type=='boolean'){
                               predicat['target'] = 'boolean';
                               var labelElem = document.createElement('label');
                               labelElem.setAttribute('for' , metaData.columns[i].fieldName);
                               labelElem.appendChild(document.createTextNode(metaData.columns[i].fieldLabel)); 
                               spanElem.appendChild(labelElem);
                               inputElem.setAttribute('type' , 'checkbox');
                             }else if(metaData.columns[i].type!='object'){
                                 predicat['target'] = 'object';
                                 inputElem.setAttribute('type' , 'text');                                 
                             }//end if(metaData.columns[i].type=='string'){  
                             if(!angular.isDefined(elementID)){
                                  inputElem.setAttribute('ng-change' , "searchCriteriaBuilder()");
                                  inputElem.setAttribute('ng-model', 'predicats['+j+'].value'); 
                             }else{
                                  inputElem.setAttribute('ng-change' , "searchCriteriaBuilder('"+elementID+"')");
                                  inputElem.setAttribute('ng-model', 'temporalPredicats['+j+'].value');
                             }//end if(!angular.isDefined(elementID)){
                           inputElem.setAttribute('placeholder' , metaData.columns[i].fieldLabel);
                         }
                             j++;
                      
                   }else if(metaData.columns[i].type=='object'){       
                      
                   }else if(metaData.columns[i].type=='array'){
                        //alert("HOLALALALA");
                   }
               }
            } 
               return ulElem;               
         };

/**
 * 
 * @returns {undefined}
 */
         $scope.viewModeBuilder = function(){
             var divelem = document.createElement("div");
             divelem.setAttribute("id","viewmodeid");
             if($scope.viewmode){
                 var part = $scope.viewmode.split(",");
                 if(part.length>2){
                     divelem.setAttribute("class","btn-group");
                     divelem.setAttribute("role","group");
                     divelem.setAttribute("aria-label","group3");
                     for(var i=0;i<part.length;i++){
                         var buttonElem = document.createElement("button");
                         buttonElem.setAttribute("type","button");
                         buttonElem.setAttribute("class","btn btn-default btn-sm");
                         if(part[i]=="calendar"){
                             var spanElem = document.createElement("span");
                             buttonElem.appendChild(spanElem);
                             buttonElem.setAttribute("ng-click","switchTo('calendar')");
                             spanElem.setAttribute("class","glyphicon glyphicon-calendar");
                             spanElem.setAttribute("aria-hidden","true");
                             divelem.appendChild(buttonElem);
                         }else if(part[i]=="tree"){
                             var spanElem = document.createElement("span");
                             buttonElem.appendChild(spanElem);
                             buttonElem.setAttribute("ng-click","switchTo('tree')");
                             spanElem.setAttribute("class","glyphicon glyphicon-list");
                             spanElem.setAttribute("aria-hidden","true");
                             divelem.appendChild(buttonElem);
                         }else if(part[i]=="kaban"){
                             var spanElem = document.createElement("span");
                             buttonElem.appendChild(spanElem);
                             buttonElem.setAttribute("ng-click","switchTo('kaban')");
                             spanElem.setAttribute("class","glyphicon glyphicon-th");
                             spanElem.setAttribute("aria-hidden","true");
                             divelem.appendChild(buttonElem);
                         }//end if(part[i]=="calendar")
                     }//end for(var i=0;i<part.length;i++)
                     
                 }//end if(part.length>1)
             }//end if($scope.viewmode)
             return divelem;
         };
         /**
          * 
          * @returns {Boolean}
          */
         $scope.isEditableList = function(){
              if(angular.isDefined($scope.currentAction.viewMode)){
                  var modes = $scope.currentAction.viewMode.split(',');
                  if(modes[0]=='tree'&&modes.length==1){
                      return true;
                  }//end if(modes[0]=='tree'&&modes.length==1){
              }//end if(angular.isDefined($scope.currentAction.viewMode)){
              return false;
         };
         /**
          * Building table list panel
          * @param {type} metaData
          * @returns {undefined}
          */
          $scope.listPanelComponent = function(metaData){  
              $scope.filtertemplate = new Object();
               $scope.windowType = "list";
                var listElem  = null ; 
                var content = $scope.viewSelector('list') ;                
                listElem = angular.element(content);
                if(metaData==null||!angular.isDefined(metaData)){
                   return ;
                }//end if(metaData==null||!angular.isDefined(metaData)){                
                $scope.desablecreate = metaData.desablecreate || !$scope.canCreate();
                $scope.desableupdate = !$scope.canUpdate()||$scope.isEditableList();
                $scope.desabledelete = !$scope.canDelete();
                $scope.desableprint = !$scope.canPrint();
                 listElem = $scope.buildActionsMenu(listElem,null,0);
                 listElem = $scope.buildPrintActionsMenu(listElem);
                //Insertion de la zone de filter
                var items = listElem.find("ul");
                for(var i=0; i<items.length;i++){                     
                     if(items.eq(i).attr("id")=="filterActionsId"){
                           items.eq(i).replaceWith($scope.filterOptionsComponent(metaData));
                     }//end if(items.eq(i).attr("id")=="filterActionsId"){  
                }//end for(var i=0; i<items.length;i++){                
                var divElem = document.createElement("div");
//                divElem.setAttribute("class","panel-body container-body-panel");
                divElem.setAttribute("id","datawidget");
//                divElem.setAttribute("style","height: 82%;overflow: auto;margin-top: -8%;");
//                console.log("principal_11190 :::::::::::::::::::::::::::::::: "+angular.toJson($scope.currentAction))
                var modes = [];
                if(angular.isDefined($scope.currentAction.viewMode)){
                    modes =$scope.currentAction.viewMode.split(",");
                }//end if(angular.isDefined($scope.currentAction.viewMode))
                if(modes.length==1 && modes[0]=='tree'){
                    $scope.updatebtnlabel ='Enregistrer';
                    divElem.appendChild($scope.editableTableListComponent(metaData));
                }else{
                    $scope.updatebtnlabel ='Modifier';
                    if($scope.currentAction.treeView!=null 
                            && $scope.currentAction.treeView.template!=null){
                        divElem.appendChild(commonsTools.xmlListParser($scope.currentAction.treeView.template));
                    }else{
                        divElem.appendChild($scope.tableListComponent(metaData));
                    }//end if($scope.currentAction.treeView!=null){
                }//end if(modes.length==1 && modes[0]=='tree'){
                //Insertion du tableau
                var items = listElem.find("div");
                for(var i=0; i<items.length;i++){                     
                     if(items.eq(i).attr("id")=="datawidget"){
                           items.eq(i).replaceWith(divElem);
                     }//end if(items.eq(i).attr("id")=="datatable"){  
                     if(items.eq(i).attr("id")=="viewmodeid"){
                           items.eq(i).replaceWith($scope.viewModeBuilder());
                     }  //end  if(items.eq(i).attr("id")=="viewmodeid"){
                }//end for(var i=0; i<items.length;i++){ 
                return listElem;
          };
          
           /**
           * 
           * @returns {unresolved}
           */
           $scope.kabanPanelComponent = function(metaData){
//                var url =$location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+angular.lowercase($scope.currentObject.moduleName)+"/"+angular.lowercase($scope.currentObject.entity)+"/"+angular.lowercase($scope.currentObject.method);
                $scope.windowType ="kaban";
                $scope.previousType="kaban";
                var listElem  = null ; 
                var content = $scope.viewSelector('kaban') ;                
                listElem = angular.element(content);
                if(metaData==null||!angular.isDefined(metaData)){
                   return ;
                 }
                 $scope.windowType = "kaban";                
                $scope.desablecreate = metaData.desablecreate || !$scope.canCreate();
                $scope.desableupdate = !$scope.canUpdate();
                $scope.desabledelete = !$scope.canDelete();
                $scope.desableprint = !$scope.canPrint();
                 listElem = $scope.buildActionsMenu(listElem,null,0);
                 listElem = $scope.buildPrintActionsMenu(listElem);
                //Insertion de la zone de filter
                var items = listElem.find("ul");
                for(var i=0; i<items.length;i++){                     
                     if(items.eq(i).attr("id")=="filterActionsId"){
                           items.eq(i).replaceWith($scope.filterOptionsComponent(metaData));
                     }//end if(items.eq(i).attr("id")=="filterActionsId"){  
                }//end for(var i=0; i<items.length;i++){
                //Insertion viewMode               
                var divElem = document.createElement("div");
//                divElem.setAttribute("class","panel-body container-body-panel");
                divElem.setAttribute("id","datawidget");
//                divElem.setAttribute("style","height: 82%;overflow: auto;margin-top: -8%;");
                var kabancontainer = commonsTools.kabanContainerBuilder($scope);
                divElem.appendChild(kabancontainer);
                /**
                 * 
                 * @param {type} metaData
                 * @returns {undefined}Remplacement 
                 */
                var items = listElem.find("div");
                for(var i=0; i<items.length;i++){                     
                     if(items.eq(i).attr("id")=="datawidget"){
                           items.eq(i).replaceWith(divElem);
                     }//end if(items.eq(i).attr("id")=="datatable"){  
                     if(items.eq(i).attr("id")=="viewmodeid"){
                           items.eq(i).replaceWith($scope.viewModeBuilder());
                     }  //end  if(items.eq(i).attr("id")=="viewmodeid"){
                }//end for(var i=0; i<items.length;i++){ 
//                console.log("principal.displayKabanPanel ================================ "+metaData);                
                return listElem;
          };
          /**
           * 
           * @param {type} metaData
           * @returns {undefined}
           */
          $scope.treePanelComponent = function(metaData){
               $scope.windowType = "tree";
               $scope.previousType="tree";
               var listElem  = null ; 
                var content = $scope.viewSelector("calendar") ;
                listElem = angular.element(content);
                if(metaData==null||!angular.isDefined(metaData)){
                   return ;
                }//end if(metaData==null||!angular.isDefined(metaData)){
                $scope.desablecreate = true;
                $scope.desableupdate = true;
                $scope.desabledelete = true;
                $scope.desableprint = true;
//                 listElem = $scope.buildActionsMenu(listElem);
                listElem = $scope.buildPrintActionsMenu(listElem);
                //Insertion de la zone de filter
                var items = listElem.find("ul");
                for(var i=0; i<items.length;i++){                     
                     if(items.eq(i).attr("id")=="filterActionsId"){
                           items.eq(i).replaceWith($scope.filterOptionsComponent(metaData));
                     }//end if(items.eq(i).attr("id")=="filterActionsId"){  
                }               
                var divElem = document.createElement("div");
                divElem.setAttribute("class","treeview");
                divElem.setAttribute("id","datawidget");
                //Insertion du tableau
                var items = listElem.find("div");
                for(var i=0; i<items.length;i++){                     
                     if(items.eq(i).attr("id")=="datawidget"){
                           items.eq(i).replaceWith(divElem);
                     }//end if(items.eq(i).attr("id")=="datawidget"){  
                     if(items.eq(i).attr("id")=="viewmodeid"){
                           items.eq(i).replaceWith($scope.viewModeBuilder());
                     }  
                }//end for(var i=0; i<items.length;i++){     

                return listElem;
          };
          /**
           * 
           * @param {type} metaData
           * @returns {undefined}
           */
           $scope.calendarPanelComponent = function(metaData){               
               $scope.windowType = "calendar";
               $scope.previousType="calendar";
//               $scope.viewmode = "calendar"; 
               var listElem  = null ; 
                var content = $scope.viewSelector("calendar") ;
                listElem = angular.element(content);
                if(metaData==null||!angular.isDefined(metaData)){
                   return ;
                }//end if(metaData==null||!angular.isDefined(metaData)){
                $scope.desablecreate = true;
                $scope.desableupdate = true;
                $scope.desabledelete = true;
                $scope.desableprint = true;
//                 listElem = $scope.buildActionsMenu(listElem);
                listElem = $scope.buildPrintActionsMenu(listElem);
                //Insertion de la zone de filter
                var items = listElem.find("ul");
                for(var i=0; i<items.length;i++){                     
                     if(items.eq(i).attr("id")=="filterActionsId"){
                           items.eq(i).replaceWith($scope.filterOptionsComponent(metaData));
                     }//end if(items.eq(i).attr("id")=="filterActionsId"){  
                }               
                var divElem = document.createElement("div");
                divElem.setAttribute("class","calendar-panel");
                divElem.setAttribute("id","datawidget");
                divElem.setAttribute("ui-calendar","uiConfig.calendar");
                divElem.setAttribute("ng-model","eventSources");
                divElem.setAttribute("calendar","myCalendar");                
                //Insertion du tableau
                var items = listElem.find("div");
                for(var i=0; i<items.length;i++){                     
                     if(items.eq(i).attr("id")=="datawidget"){
                           items.eq(i).replaceWith(divElem);
                     }//end if(items.eq(i).attr("id")=="datawidget"){  
                     if(items.eq(i).attr("id")=="viewmodeid"){
                           items.eq(i).replaceWith($scope.viewModeBuilder());
                     }  
                }//end for(var i=0; i<items.length;i++){     

                return listElem;
          };        
        
     
          /**
             Fonction de construction des 
          **/
          $scope.listFramePanelBuilder = function(metaData,elem){
                  var listElem  = null ;         
                   $scope.previousType="list";
                   $scope.windowType="list";
//                   $scope.viewmode = "list"; 
//                   console.log("listFramePanelBuilder inside ====== "+$scope.activateVerticalMenu);
                   if($rootScope.globals.theme!=null&&$rootScope.globals.theme.container){
                       listElem = angular.element($rootScope.globals.theme.container);
                   }else{
                        if($scope.enabledVerticalMenu){       
                             listElem = angular.element("<div>")
                                           .addClass("col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2")
                                           .attr("id" , "container")
                                           .attr("style" ,"position: absolute;width: 84.2%;height: 91%;margin-left:15.55% ;margin-right:0px;padding:0px;");
                         }else{
                           listElem = angular.element("<div>")
                                            .addClass("col-sm-12  col-md-12")
                                            .attr("id" , "container")
                                            .attr("style" ,"position: absolute;width: 100%;height: 91.0%; margin:0px;padding:0px;" );                   

                         }    
                     }//end if($rootScope.globals.theme!=null&&$rootScope.globals.theme.container){
                    if(metaData){
                        listElem.append($scope.listPanelComponent(metaData));
                    }else{
                         if(elem){
                            listElem.append(elem);
                         }
                    }//endif(metaData)                 
                     //var content = $scope.viewSelector('list') ;
                     //listElem.append(angular.element(content)); 
                     var compileFn = $compile(listElem);
                     compileFn($scope);
                     //Insertion du tableau
                     var items = $element.find("div");
                     for(var i=0; i<items.length;i++){
                          if(items.eq(i).attr("id")=="container"){
                                items.eq(i).replaceWith(listElem);
                               // console.log("listFramePanelBuilder ====== "+$scope.enabledVerticalMenu);
                          }  
                     }

                    return listElem;
          };
          /**
           * formulaire 
           * @param {type} metaData
           * @param {type} elem
           * @returns {unresolved}
           */
          $scope.formFramePanelBuilder = function(elem){
                   var listElem  = null ;         
//                    $scope.previousType="view";
//                    $scope.windowType="view";
                    var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
                    if(session==null){
                        $scope.deconnexion();
                        return;
                    }//end if(session==null){  
//                   $scope.viewmode = "list"; 
//                   console.log("listFramePanelBuilder inside ====== "+$scope.activateVerticalMenu);
                   if($rootScope.globals.theme!=null&&$rootScope.globals.theme.container){
                       listElem = angular.element($rootScope.globals.theme.container);
                   }else{
                        if($scope.enabledVerticalMenu){       
                             listElem = angular.element("<div>")
                                           .addClass("col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2")
                                           .attr("id" , "container")
                                           .attr("style" ,"position: absolute;width: 84.2%;height: 91%;margin-left:15.55% ;margin-right:0px;padding:0px;");
                         }else{
                           listElem = angular.element("<div>")
                                            .addClass("col-sm-12  col-md-12")
                                            .attr("id" , "container")
                                            .attr("style" ,"position: absolute;width: 100%;height: 91.0%; margin:0px;padding:0px;" );                   

                         }    
                     }//end if($rootScope.globals.theme!=null&&$rootScope.globals.theme.container){
                     listElem.append(elem); 
                    //var content = $scope.viewSelector('list') ;
                      //listElem.append(angular.element(content)); 
                      var compileFn = $compile(listElem);
                      compileFn($scope);
                      //Insertion du tableau
                      var items = $element.find("div");
                      for(var i=0; i<items.length;i++){
                           if(items.eq(i).attr("id")=="container"){
                                 items.eq(i).replaceWith(listElem);
                                // console.log("listFramePanelBuilder ====== "+$scope.enabledVerticalMenu);
                           }//end if(items.eq(i).attr("id")=="container")  
                      }//end for(var i=0; i<items.length;i++){

//                    return listElem;
                    commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                    restService.findAll().$promise
                           .then(
                           function(datas){
                               if(datas.length>0){
                                    $scope.currentObject = datas[0];
                                    $scope.viewAction($scope.currentObject);
                               }else{
                                   $scope.addElementAction();
                               }//end if(datas.length>0)                              
                               //Cacher la navigation
                               $scope.navigatorcontainer.addRule($scope.currentAction.name,$scope.currentObject.id,$scope.currentObject.designation);
   //                            console.log("$scope.viewAction ============== "+angular.toJson(data));
                                                             
   //                            console.log("$scope.viewAction after display ============== "+angular.toJson(data));
                               commonsTools.hideDialogLoading();
                   },function(error){
                        commonsTools.hideDialogLoading();
                        commonsTools.showMessageDialog(error);
                   } );                   
          };
            /**
             Fonction de construction des 
          **/
          $scope.kabanFramePanelBuilder = function(metaData){
                  var listElem  = null ;       
//                   $scope.viewmode = "kaban"; 
//                   console.log("listFramePanelBuilder inside ====== "+$scope.activateVerticalMenu);
                   if($rootScope.globals.theme!=null&&$rootScope.globals.theme.container){
                       listElem = angular.element($rootScope.globals.theme.container);
                   }else{
                        if($scope.enabledVerticalMenu){       
                             listElem = angular.element("<div>")
                                           .addClass("col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2")
                                           .attr("id" , "container")
                                           .attr("style" ,"position: absolute;width: 84.2%;height: 91%;margin-left:15.55% ;margin-right:0px;padding:0px;");
                         }else{
                             listElem = angular.element("<div>")
                                            .addClass("col-sm-12  col-md-12")
                                            .attr("id" , "container")
                                            .attr("style" ,"position: absolute;width: 100%;height: 91.0%; margin:0px;padding:0px;" );                   

                         }    
                    }//end if($rootScope.globals.theme!=null&&$rootScope.globals.theme.container){
                    listElem.append($scope.kabanPanelComponent(metaData));                               
                     //var content = $scope.viewSelector('list') ;
                     //listElem.append(angular.element(content)); 
                     var compileFn = $compile(listElem);
                     compileFn($scope);
                     //Insertion du tableau
                     var items = $element.find("div");
                     for(var i=0; i<items.length;i++){
                          if(items.eq(i).attr("id")=="container"){
                                items.eq(i).replaceWith(listElem);
                               // console.log("listFramePanelBuilder ====== "+$scope.enabledVerticalMenu);
                          }//end if(items.eq(i).attr("id")=="container"){  
                     }//end for(var i=0; i<items.length;i++){                     
                    return listElem;
          };
        /**
         * 
         * @param {type} metaData
         * @param {type} elem
         * @returns {unresolved}
         */  
        $scope.calendarFramePanelBuilder = function(metaData,elem){
                  $scope.previousType="calendar";
                  $scope.windowType="calendar";
                  var listElem  = null ;                  
//                   console.log("listFramePanelBuilder inside ====== "+$scope.enabledVerticalMenu+" ==== "+angular.toJson(metaData));             
                  if($rootScope.globals.theme!=null&&$rootScope.globals.theme.container){
                       listElem = angular.element($rootScope.globals.theme.container);
                   }else {
                       if($scope.enabledVerticalMenu){       
                            listElem = angular.element("<div>")
                                          .addClass("col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2")
                                          .attr("id" , "container")
                                          .attr("style" ,"position: absolute;width: 84.2%;height: 91%;margin-left:15.55% ;margin-right:0px;padding:0px;");
                        }else{
                          listElem = angular.element("<div>")
                                           .addClass("col-sm-12  col-md-12")
                                           .attr("id" , "container")
                                           .attr("style" ,"position: absolute;width: 100%;height: 91.0%; margin:0px;padding:0px;" );                   

                        }
                    }//end if($rootScope.globals.theme!=null&&$rootScope.globals.theme.container){
                 if(metaData){
                     listElem.append($scope.calendarPanelComponent(metaData));
                 }else{
                      if(elem){
                         listElem.append(elem);
                      }
                 }//endif(metaData)                 
                  //var content = $scope.viewSelector('list') ;
                  //listElem.append(angular.element(content)); 
                  var compileFn = $compile(listElem);
                  compileFn($scope);
                  //Insertion du tableau
                  var items = $element.find("div");
                  for(var i=0; i<items.length;i++){                       
                       if(items.eq(i).attr("id")=="container"){
                             items.eq(i).replaceWith(listElem);
                            // console.log("listFramePanelBuilder ====== "+$scope.enabledVerticalMenu);
                       }//end if(items.eq(i).attr("id")=="container"){  
                  }//end for(var i=0; i<items.length;i++){  

                 return listElem;
          };
          /**
           * 
           * @param {type} metaData
           * @param {type} elem
           * @returns {unresolved}
           */
          $scope.treeFramePanelBuilder = function(metaData,elem){
                  $scope.previousType="tree";
                  $scope.windowType="tree";
                  var listElem  = null ;                  
//                   console.log("listFramePanelBuilder inside ====== "+$scope.enabledVerticalMenu+" ==== "+angular.toJson(metaData));             
                  if($rootScope.globals.theme!=null&&$rootScope.globals.theme.container){
                       listElem = angular.element($rootScope.globals.theme.container);
                   }else {
                       if($scope.enabledVerticalMenu){       
                            listElem = angular.element("<div>")
                                          .addClass("col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2")
                                          .attr("id" , "container")
                                          .attr("style" ,"position: absolute;width: 84.2%;height: 91%;margin-left:15.55% ;margin-right:0px;padding:0px;");
                        }else{
                          listElem = angular.element("<div>")
                                           .addClass("col-sm-12  col-md-12")
                                           .attr("id" , "container")
                                           .attr("style" ,"position: absolute;width: 100%;height: 91.0%; margin:0px;padding:0px;" );                   

                        }
                    }//end if($rootScope.globals.theme!=null&&$rootScope.globals.theme.container){
                 if(metaData){
                     listElem.append($scope.treePanelComponent(metaData));
                 }else{
                      if(elem){
                         listElem.append(elem);
                      }
                 }//endif(metaData)                 
                  //var content = $scope.viewSelector('list') ;
                  //listElem.append(angular.element(content)); 
                  var compileFn = $compile(listElem);
                  compileFn($scope);
                  //Insertion du tableau
                  var items = $element.find("div");
                  for(var i=0; i<items.length;i++){                       
                       if(items.eq(i).attr("id")=="container"){
                             items.eq(i).replaceWith(listElem);
                            // console.log("listFramePanelBuilder ====== "+$scope.enabledVerticalMenu);
                       }//end if(items.eq(i).attr("id")=="container"){  
                  }//end for(var i=0; i<items.length;i++){ 
                 
                 if($scope.datas.length>0){
                    $('#datawidget').treeview({
 //                        color: "#428bca",
                         showTags: true,
                         data: $scope.datas
                       });
                 }//end if($scope.datas.length>0){
//                  var defaultData = [
//                    {
//                      text: 'Parent 1',
//                      href: '#parent1',
//                      tags: ['4'],
//                      nodes: [
//                        {
//                          text: 'Child 1',
//                          href: '#child1',
//                          tags: ['2'],
//                          nodes: [
//                            {
//                              text: 'Grandchild 1',
//                              href: '#grandchild1',
//                              tags: ['4']
//                            },
//                            {
//                              text: 'Grandchild 2',
//                              href: '#grandchild2',
//                              tags: ['0']
//                            }
//                          ]
//                        },
//                        {
//                          text: 'Child 2',
//                          href: '#child2',
//                          tags: ['0']
//                        }
//                      ]
//                    },
//                    {
//                      text: 'Parent 2',
//                      href: '#parent2',
//                      tags: ['0']
//                    },
//                    {
//                      text: 'Parent 3',
//                      href: '#parent3',
//                       tags: ['0']
//                    },
//                    {
//                      text: 'Parent 4',
//                      href: '#parent4',
//                      tags: ['0']
//                    },
//                    {
//                      text: 'Parent 5',
//                      href: '#parent5'  ,
//                      tags: ['0']
//                    }
//                  ];
//                  $('#datawidget').treeview({
////                        color: "#428bca",
//                        showTags: true,
//                        data: defaultData
//                      });
                 
                 return listElem;
          };

          /**
             Fonction de construction des 
          **/
          $scope.listFrameBuilder = function(metaData){
                  var listElem  = null ;
                  if(($scope.enabledVerticalMenu==true)){
                      listElem = angular.element("<div>")
                                    .addClass("col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2")
                                    .attr("id" , "container")
                                    .attr("style" ,"position: absolute;width: 84.2%;height: 91%;margin-left:15.55% ;margin-right:0px;padding:0px; border:solid 1px red ;");
                  }else{
                    listElem = angular.element("<div>")
                                     .addClass("col-sm-12  col-md-12")
                                     .attr("id" , "container")
                                     .attr("style" ,"position: absolute;width: 100%;height: 91.0%; margin:0px;padding:0px;" );          
                        //console.log("listFrameBuilder ====== "+$scope.enabledVerticalMenu);
                  
                  }
                  
                  listElem.append($scope.listPanelComponent(metaData));                  
                  var compileFn = $compile(listElem);
                  compileFn($scope);
                  $element.append(listElem);               
                 return listElem;
          };

           
           $scope.$on("dataLoad" , function(event ,args){
//                console.log('$scope.$on("dataLoad" , function(event ,args) :::::::::::::::: '+$scope.currentAction.viewMode+" === "+args.item);
                if($scope.windowType=="calendar"){
                     $scope.calendarFramePanelBuilder($scope.metaData);
                }else if($scope.windowType=="kaban"){
                     $scope.kabanFramePanelBuilder($scope.metaData);
                }else if($scope.windowType=="tree"){
                     $scope.treeFramePanelBuilder($scope.metaData);
                }else{
                    $scope.listFramePanelBuilder($scope.metaData);
                } //end if($scope.windowType=="calendar")   
                commonsTools.searchkeyevent('search-text-id',$scope);        
                commonsTools.hideDialogLoading();
               if(angular.isDefined(args.item) && args.item!=null){
                   $scope.viewbyIDAction(args.item);
               }//end if(angular.isDefined(args.item) && args.item!=null){
               $scope.pagination.hasnext();
               $scope.pagination.hasprevious();
           });
           
//         
          /**
            Reception du signal de changement de module
          **/
          $scope.$on("currentModule" , function(event , args){
                  $scope.currentModule = args.module;
                  $scope.company = $rootScope.globals.company;
                  if($scope.currentModule.hasmenu==true){
                        $scope.enabledVerticalMenu = args.verticalMenu;
                        $scope.exportbtnlabel = 'Exporter';    
                        $scope.updatebtnlabel ='Modifier';
                        $scope.deletebtnlabel='Supprimer';
                        $scope.showApplication = false;
                        if($scope.currentModule.name=='application'){                            
                            $scope.exportbtnlabel = 'Installer/Desinstaller';
                            $scope.updatebtnlabel ='Mise à jour';
                            $scope.deletebtnlabel='Supprimer';
                            $scope.showApplication = true;
                        }  //end if($scope.currentModule.name=='application')                        
                }else if($scope.currentModule.hasmenu==false){
//                    alert("Vous avez cliquez sur un module sans menu ....");
                }
                  
          });
      
       /**
        * 
        * @returns {undefined}
        */
         $scope.updateApplication = function(){
              //Create differ
                    commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");                                    
                    //Initialisation de l'url
                    restService.url(angular.lowercase($scope.currentAction.entityName),angular.lowercase($scope.currentAction.moduleName));
                    $scope.metaData = restService.getMetaData(null).$promise
                                    .then(function(metaData){
                                                //console.log("Chargement MetaData "+angular.toJson(metaData));
                                                $scope.predicats = new Array();
                                                $scope.metaData = metaData; 
                                                var url =$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/menumodule/refreshall";
                                                //Parametres pagination
                                                $http.post(url)
                                                        .then(function(response){
//                                                             //console.log("Chargement MetaData "+angular.toJson(metaData));
                                                                $scope.predicats = new Array();
                                                                //Parametres pagination
                                                                restService.count($scope.predicats)
                                                                      .$promise.then(function(data){
                                                                          $scope.pagination.currentPage=1;
                                                                           $scope.pagination.totalPages = data.value ;                                                  
                                                                           $scope.metaData = metaData;                                        
                                                                            $scope.searchCriteria = new String();               
                                                                            $scope.listFramePanelBuilder(metaData);
                                                                            $scope.loadData();
                                                                      }
                                                                      , function(error){
                                                                          commonsTools.hideDialogLoading();
                                                                          commonsTools.showMessageDialog(error);
                                                                      });  
                                                        },function(error){
                                                            commonsTools.hideDialogLoading();
                                                            commonsTools.showMessageDialog(error);
                                                        });
                                        
                                        },function(error){
                                                commonsTools.hideDialogLoading();
                                                commonsTools.showMessageDialog(error);
                                        });
         };
          /**
            * 
            * @param {type} item
            * @returns {undefined}
            */
           $scope.refreshApplication = function(item){
                commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                //Initialisation de l'url
                if(angular.isDefined(item)){
                    $scope.currentObject = item;
                }//end if(angular.isDefined(item)){
                restService.url(angular.lowercase($scope.currentAction.entityName),angular.lowercase($scope.currentAction.moduleName));
                    $scope.metaData = restService.getMetaData(null).$promise
                                    .then(function(metaData){
                                                //console.log("Chargement MetaData "+angular.toJson(metaData));
                                                $scope.predicats = new Array();
                                                $scope.metaData = metaData; 
                                                var url =$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/menumodule/refresh";
                                                //Parametres pagination
                                                $http.post(url,$scope.currentObject)
                                                        .then(function(response){
//                                                             //console.log("Chargement MetaData "+angular.toJson(metaData));
                                                                $scope.predicats = new Array();
                                                                //Parametres pagination
                                                                restService.count($scope.predicats)
                                                                      .$promise.then(function(data){
                                                                          $scope.pagination.currentPage=1;
                                                                           $scope.pagination.totalPages = data.value ;                                                  
                                                                           $scope.metaData = metaData;                                        
                                                                            $scope.searchCriteria = new String();               
                                                                            $scope.listFramePanelBuilder(metaData);
                                                                            $scope.loadData();
                                                                            $scope.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success"); 
                                                                            location.reload();
                                                                      }
                                                                      , function(error){
                                                                          commonsTools.hideDialogLoading();
                                                                          commonsTools.showMessageDialog(error);
                                                                      });  
                                                        },function(error){
                                                            commonsTools.hideDialogLoading();
                                                            commonsTools.showMessageDialog(error);
                                                        });
                                        
                                        },function(error){
                                                commonsTools.hideDialogLoading();
                                                commonsTools.showMessageDialog(error);
                                        });
           };
          /**
           * Installation d'un nouveau module
           * @returns {undefined}
           */
          $scope.installApplication = function(item){
               commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                    //Initialisation de l'url
                    if(angular.isDefined(item)){
                        $scope.currentObject = item;
                    }//end if(angular.isDefined(item)){
                    restService.url(angular.lowercase($scope.currentAction.entityName),angular.lowercase($scope.currentAction.moduleName));
                    $scope.metaData = restService.getMetaData(null).$promise
                                    .then(function(metaData){
                                                //console.log("Chargement MetaData "+angular.toJson(metaData));
                                                $scope.predicats = new Array();
                                                $scope.metaData = metaData; 
                                                var url =$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/menumodule/install";
                                                //Parametres pagination
                                                $http.post(url,$scope.currentObject)
                                                        .then(function(response){
//                                                             //console.log("Chargement MetaData "+angular.toJson(metaData));
                                                                $scope.predicats = new Array();
                                                                //Parametres pagination
                                                                restService.count($scope.predicats)
                                                                      .$promise.then(function(data){
                                                                          $scope.pagination.currentPage=1;
                                                                           $scope.pagination.totalPages = data.value ;                                                  
                                                                           $scope.metaData = metaData;                                        
                                                                            $scope.searchCriteria = new String();               
                                                                            $scope.listFramePanelBuilder(metaData);
                                                                            $scope.loadData();
                                                                            $scope.notifyWindow("Status Operation" ,"L'opÃ©ration s'est dÃ©roulÃ©e avec sucess","success"); 
                                                                            location.reload();
                                                                      }
                                                                      , function(error){
                                                                          commonsTools.hideDialogLoading();
                                                                          commonsTools.showMessageDialog(error);
                                                                      });  
                                                        },function(error){
                                                            commonsTools.hideDialogLoading();
                                                            commonsTools.showMessageDialog(error);
                                                        });
                                        
                                        },function(error){
                                                commonsTools.hideDialogLoading();
                                                commonsTools.showMessageDialog(error);
                                        });
                
          };
          /**
           * Installation d'un nouveau module
           * @returns {undefined}
           */
          $scope.uninstallApplication = function(item){
               commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                    //Initialisation de l'url
                    if(angular.isDefined(item)){
                        $scope.currentObject = item;
                    }//end if(angular.isDefined(item)){
                    restService.url(angular.lowercase($scope.currentAction.entityName),angular.lowercase($scope.currentAction.moduleName));
                    $scope.metaData = restService.getMetaData(null).$promise
                                    .then(function(metaData){
                                                //console.log("Chargement MetaData "+angular.toJson(metaData));
                                                $scope.predicats = new Array();
                                                $scope.metaData = metaData; 
                                                var url =$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/menumodule/uninstall";
                                                //Parametres pagination
                                                $http.post(url,$scope.currentObject)
                                                        .then(function(response){
//                                                             //console.log("Chargement MetaData "+angular.toJson(metaData));
                                                                $scope.predicats = new Array();
                                                                //Parametres pagination
                                                                restService.count($scope.predicats)
                                                                      .$promise.then(function(data){
                                                                          $scope.pagination.currentPage=1;
                                                                           $scope.pagination.totalPages = data.value ;                                                  
                                                                           $scope.metaData = metaData;                                        
                                                                            $scope.searchCriteria = new String();               
                                                                            $scope.listFramePanelBuilder(metaData);
                                                                            $scope.loadData();
                                                                            $scope.notifyWindow("Status Operation" ,"L'opération s'est dÃ©roulÃ©e avec sucess","success");  
                                                                            location.reload();
                                                                      }
                                                                      , function(error){
                                                                          commonsTools.hideDialogLoading();
                                                                          commonsTools.showMessageDialog(error);
                                                                      });  
                                                        },function(error){
                                                            commonsTools.hideDialogLoading();
                                                            commonsTools.showMessageDialog(error);
                                                        });
                                        
                                        },function(error){
                                                commonsTools.hideDialogLoading();
                                                commonsTools.showMessageDialog(error);
                                        });
                
          };
          
          
          /**
           * 
           * @param {type} template
           * @param {type} index
           * @param {type} item
           * @returns {undefined}
           */
         $scope.initAction = function(template,index , item,inner){             
                $scope.createsession();
                $scope.templateData = template;
                $scope.showback = false;
                if(angular.isDefined(inner)&&inner===true){
                    $scope.showback = true;
                }//if(angular.isDefined(inner)&&inner==true){
                if($scope.currentAction.name=="application_update"){
                     $scope.updateApplication();
                }else if($scope.currentAction.name=="export_bd"){//export the data base
                    commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");   
                    var url=$location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/exportbd";
                    $http.get(url,{responseType: "arraybuffer"})
                          .then(function(response){
                                var linkElement = document.createElement('a');
                                try{
                                        var type = "sql";
                                        var attachment = "db_script."+type;
                                       var arrayBufferView = new Uint8Array(response.data );
                                       var blob = new Blob( [ arrayBufferView ], { type: type } );
                                       var urlCreator = window.URL || window.webkitURL;
                                       var docUrl = urlCreator.createObjectURL( blob );
                                       linkElement.setAttribute('href', docUrl);
                                       linkElement.setAttribute("download", attachment);
                                       linkElement.setAttribute("target", "_blank");
                                       var clickEvent = new MouseEvent("click", {
                                           "view": window,
                                           "bubbles": true,
                                           "cancelable": false
                                       });
                                       linkElement.dispatchEvent(clickEvent);
                                } catch (ex) {
                                  commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+ex.message,"danger");
                               }
                                commonsTools.hideDialogLoading();
                          },function(error){
                                commonsTools.hideDialogLoading();
                               commonsTools.showMessageDialog(error);
                            });
                }else{
                    //Create differ
                    //Initialisation de l'url
                    restService.url(angular.lowercase($scope.currentAction.entityName),angular.lowercase($scope.currentAction.model));
                    //Chargement des metaData
                    var mode = null ;
                    if($scope.currentAction.viewMode){
                        mode = $scope.currentAction.viewMode.split(",");
                    }//end if($scope.currentAction.viewMode)     
//                    console.log("InitAction. session information ==========  ==== "+mode[0]+" ====== "+$scope.currentAction.viewMode);                                                    
                    if(mode && mode.length>0 && mode[0]=='dashboard'){
//                        alert("Chargement tableau de bord ....");
                          $scope.hideannuler=true;
                          var model = angular.lowercase($scope.currentAction.model);
                          var entity = angular.lowercase($scope.currentAction.entityName);
                          var method = angular.lowercase($scope.currentAction.method);
                          var templateID = null;                         
                          templateID =$scope.currentAction.dashboard.id;
                          commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                          //end if($scope.currentAction.dashboard)
                          var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/"+model+"/"+entity+"/"+method+"/"+templateID;
                          $http.get(url)
                                  .then(function(response){
                                        $scope.currentObject = response.data;
//                                        console.log("principal.initAction()======================================= "+angular.toJson($scope.currentObject));
                                        $scope.listFramePanelBuilder(null,$scope.displayDashboardPanel());
                                        for(var i=0 ;i<$scope.currentObject.dashboards.length;i++){
                                            var dashboard = $scope.currentObject.dashboards[i];                
                                            commonsTools.dashboardEntryBuilder(dashboard.code,dashboard.entries[0],$scope); 
                                        }//end for(var i=0 ;i<$scope.currentObject.dashboards.length;i++){
                                        commonsTools.hideDialogLoading();
                                    },function(error){
                                         commonsTools.hideDialogLoading();
                                         commonsTools.showMessageDialog(error);
                                    });
                                    
                                    return ;
                    }//end if(mode.length>0 && mode[0]=='dashboard')
                    //Traitement des actions de type website
//                    if(mode && mode.length>0 && mode[0]=='website'){
//                        $rootScope.$broadcast("website" , {website:$scope.currentAction.model,currentuser:$rootScope.globals.currentUser});
//                        return ;
//                    }//end if(mode && mode.length>0 && mode[0]=='dashboard'){
                    //Traitement des action de type report
                    if($scope.currentAction.report!=null && $scope.currentAction.report!=""){
//                        if($scope.windowType!='list' && !angular.isDefined(index)){
//                            $scope.listFramePanelBuilder($scope.metaData);
//                        }//end if($scope.windowType!='list')
                        for(var i=0 ; $scope.currentAction.records.length;i++){
                            var report = $scope.currentAction.records[i];
                            if(report.code==$scope.currentAction.report){
                                $scope.customPrintAction(report.id);
                                return ;
                            }//end if(report.code==$scope.currentAction.report){
                        }//end for(var i=0 ; $scope.currentAction.records.length;i++){
                    }//end if($scope.currentAction.report!=null && $scope.currentAction.report.length>0){
                    $scope.hideannuler=false;
                    if(!$scope.currentAction.modal){                           
                            commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                            restService.getMetaData($scope.currentAction).$promise
                                    .then(function(metaData){
//                                        console.log("Chargement MetaData "+angular.toJson(metaData));
                                        $scope.predicats = new Array();
                                        var filters = $scope.dataCache['restriction'];
                                        if(angular.isDefined(filters) && filters.length>0){
                                            for(var i=0;i<filters.length ;i++){
                                                $scope.predicats.push(filters[i]);
                                            }//end for(var i=0;i<filters.length i++){
                                        }//end if(angular.isDefined(filters) && filters.length>0){
//                                        console.log("principal.initAction_11090 ================= : "+inner);
                                        //Parametres pagination
                                        restService.count($scope.predicats)
                                              .$promise.then(function(data){
                                                  $scope.pagination.currentPage=0;
                                                  if(data.value>0){
                                                      $scope.pagination.currentPage=1;                                                  
                                                  }//end if(data.value>0){
                                                  $scope.pagination.beginIndex = 0;
                                                  var action = angular.fromJson($scope.currentAction);
                                                   $scope.pagination.totalPages = data.value ;                                                  
                                                   $scope.metaData = metaData ;//commonsTools.xmlViewParser($scope.currentAct) metaData;                                        
                                                   //Cacher la navigation
                                                   if((!angular.isDefined(inner)||inner==false)){
                                                       $scope.navigatorcontainer.reset();
                                                   }//end if($scope.navigations.length<=0){
                                                   $scope.navigatorcontainer.addRule(action.name,null,action.label);
                                                   
                                                   $scope.searchCriteria = new String();               
//                                                    console.log("principal.initAction_11090 ================= : "+mode[0]);
                                                    //Liaison du search pour la recherche automatique
                                                    if(mode && mode[0]=="calendar"){
                                                       $scope.calendarFramePanelBuilder(metaData);
                                                       $scope.loadData(item);                                                    
                                                    }else if(mode && mode[0]=="kaban"){
                                                       $scope.kabanFramePanelBuilder(metaData);
                                                       $scope.loadData(item);                                                    
                                                    }else if(mode && mode[0]=="form"){
                                                        $scope.formFramePanelBuilder($scope.displayEditPanel());                                                       
                                                    }else if(mode && mode[0]=="list"){
                                                        $scope.treeFramePanelBuilder(metaData); 
                                                        $scope.loadTreeData(item);
                                                    }else{
                                                        $scope.listFramePanelBuilder(metaData);
                                                        $scope.loadData(item);                                                    
                                                    }//end if(viewType=="tree")
                                                    commonsTools.searchkeyevent('search-text-id',$scope);                                                    
                                                    commonsTools.hideDialogLoading();
                                              }
                                              , function(error){
                                                  commonsTools.hideDialogLoading();
                                                  commonsTools.showMessageDialog(error);
                                              });
                                        
                                    },function(error){
                                        commonsTools.hideDialogLoading();
                                        commonsTools.showMessageDialog(error);
                                    });                            
                        }else if($scope.currentAction.modal){  
                               if($scope.windowType!='list' && !angular.isDefined(index)){
                                   $scope.listFramePanelBuilder($scope.metaData);
                               }//end if($scope.windowType!='list')
//                               console.log("Chargement MetaData apres $scope.editDialogBuilderExtern(metaData) ====== ==== Index : "+index); 
                               commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");
                               restService.getMetaData($scope.currentAction).$promise
                                    .then(function(metaData){  
                                        if(!$scope.metaData){
                                             $scope.metaData = metaData;
                                        }//end if($scope.metaData)
//                                        console.log("Chargement MetaData   = "+angular.toJson(metaData));
                                        if($scope.currentAction.name=='update_pwd'){
                                            var pwduser = {cle:$scope.dataCache['currentObject'].id,user:$scope.dataCache['currentObject'].courriel,password:$scope.dataCache['currentObject'].password};
                                            $scope.temporalData = pwduser;
//                                            console.log("Chargement MetaData apres $scope.createEmptyTemporalObject(metaData)  = "+angular.toJson($scope.currentObject));                               
                                        }else if($scope.currentAction.name=="modifpassword"){
//                                            console.log("Chargement MetaData   = "+angular.toJson($rootScope.globals.user));
                                            var pwduser2 = {cle:$rootScope.globals.user.id,oldpassword:$rootScope.globals.user.oldpassword,newpassword:$rootScope.globals.user.newpassword};
                                            $scope.temporalData = pwduser2;                                                                           
                                        }else{
                                            $scope.temporalData = new Object();
                                            $scope.createEmptyTemporalObject(metaData,template);                                        
                                        }//end if($scope.currentAction.name=='update_pwd'){
                                        if(index===null||!angular.isDefined(index)){
                                            index = 1;
                                        }else{
                                            index = new Number(index)+1;
                                        }//end if(index==null||!angular.isDefined(index))
//                                        console.log("initAction ========== isString : "+angular.isString($scope.currentAction)+" ::::: isobject : "+angular.isObject($scope.currentAction));
                                        if(angular.isString($scope.currentAction)){
                                            $scope.currentAction = angular.fromJson($scope.currentAction);
                                        }//end if(angular.isString($scope.currentAction)){
                                        commonsTools.hideDialogLoading();
                                        $scope.editDialogBuilderExtern(metaData,index,$scope.currentAction.link);
                                        $scope.currentAction = $scope.dataCache['currentAction'];
                                        $scope.currentObject = $scope.dataCache['currentObject'];
                                        //Initialisation de l'url
                                        restService.url(angular.lowercase($scope.currentAction.entityName),angular.lowercase($scope.currentAction.model));
                                        //Appele de la fenetre modale
                                        var modalID = "";
                                        var endIndex = index;            
                                        if(endIndex==1){
                                            modalID = "myModal";
                                        }else if(endIndex==2){
                                            modalID = "globalModal";
                                        }else if(endIndex==3){
                                            modalID = "myModal1";
                                        }else if(endIndex==4){
                                            modalID = "myModal2";
                                        }//end if(endIndex==1){
                                        $("#"+modalID).modal("toggle");
                                        $("#"+modalID).modal("show");
                                        
                                    },function(error){
                                        $scope.currentAction = $scope.dataCache['currentAction'];
                                        $scope.currentObject = $scope.dataCache['currentObject'];
                                        commonsTools.hideDialogLoading();
                                        commonsTools.showMessageDialog(error);
                                    });
                        }//end else if($scope.currentAction.modal)
                    
                }//end if($scope.currentAction.name=="application_update"){
         };
          /**
           * Reception du message de changement de l'action
           */
          $scope.$on("currentActionUpdate" , function(event , args){
               var session = commonsTools.readCookie("session_"+$rootScope.globals.user.id);
               if(session==null){
                   alert('Votre session est expirÃ©e \n Cliquez sur OK et reconnectez vous');
                   $scope.deconnexion();
                   return;
               }//end if(session==null){
               if(args.action){
                    $scope.dataCache['currentObject'] = $scope.currentObject;
                    $scope.dataCache['currentAction'] = $scope.currentAction;
                    $scope.dataCache['restriction'] = args.restriction;
                    $scope.viewmode = args.action.viewMode;   
                    $scope.calendarrecord = args.action.calendar;
                    $scope.currentAction = args.action;
                    var template = args.template;
                    var index = args.index;
//                    console.log("$scope.$on(currentActionUpdate , function(event , args) ===== "+angular.toJson($scope.currentModule));
                    $scope.enabledVerticalMenu = args.verticalMenu;
                    $scope.reset();
                    $scope.initAction(template,index , args.item,args.inner);
              }//end if(args.action){
           });
           /**
            * 
            */
            $scope.$on("currentActionUpdateModal" , function(event , args){
              if(args.action){
                    $scope.dataCache['currentObject'] = $scope.currentObject;
                    $scope.dataCache['currentAction'] = $scope.currentAction;
                    $scope.currentAction = args.action;
                    $scope.currentAction.modal =true ;
                    var index = args.index;
                    $scope.enabledVerticalMenu = args.verticalMenu;
                    var template = args.template;
                    $scope.reset();
                    $scope.initAction(template,index);
              }//end if(args.action){
           });
           /**
            * Reception des evenement de d'edition des etats
            */
          $scope.$on("customreport" , function(event, args){
//               console.log("customreport =========== "+angular.toJson(args.template)); 
               $scope.dataCache["report"] = args.report;
               if(args.report.ignore){
                     $scope.showReport();
               }else{
                   var template = args.template;
                   $scope.temporalData = new Object();
                   if(template){                       
                     $scope.createEmptyTemporalObject(args.metaData,template);     
                   }//end if(template){    
                   $scope.editDialogBuilderExtern(args.metaData,1,null,true);
                   $("#myModal").modal("toggle");
                   $("#myModal").modal("show");
               }//end if(args.report.ignore){               
          });
          
          $scope.getSelectLines = function(){
              var values = new Array();
              for(var i=0 ; i<$scope.datas.length;i++){
                  if($scope.datas[i].selected){
                      values.push($scope.datas[i].id);
                  }//end if($scope.datas[i].selected){
              }//end for(var i=0 ; i<$scope.selectedObjects;i++){
              return values;
          };
          /**
          * 
          * @param {type} model
          * @param {type} fieldName
          * @returns {undefined}
          */
          $scope.downloadAction = function(model , fieldName){
             //Recuperation de la piece jointe
             var data = $scope.getParentModel(model);
             var pj = data[fieldName];
//             console.log("$scope.downloadAction = function(model , fieldName) =================== model :"+model+" === fieldName :"+fieldName+" ==== pj:"+pj);
             commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");   
                  if(pj){
                             var url = $location.protocol()+"://"+$location.host()+":"+$location.port()+"/kerencore/resource/";
                             var parts = pj.split(".");
                             var type = "application/pdf";
                             var extension = parts[parts.length-1];
                             var viewable = false;
                             if(extension=='pdf'){
                                 url = url+'pdf/'+pj+'/'+pj;
                                 viewable = true;
                             }else if(extension=='png'||extension=='jpeg'){
                                 type = "image/png";
                                 url = url+'img/'+pj+'/'+pj;
                                 viewable = true;
                             }else if(extension=='doc'||extension=='dot'){
                                 type = "application/msword";
                                 url = url+'file/'+pj+'/'+pj;
//                                 viewable = true;
                             }else if(extension=='docx'||extension=='dotx'){
                                 type = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                                 url = url+'file/'+pj+'/'+pj;
//                                 viewable = true;
                             }else if(extension=='xls'||extension=='xlt'||extension=='xla'){
                                 type = "application/vnd.ms-excel";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='xlsx'||extension=='xltx'){
                                 type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='ppt'||extension=='pot'||extension=='pps'||extension=='ppa'){
                                 type = "application/vnd.ms-powerpoint";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='pptx'){
                                 type = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='mdb'){
                                 type = "application/vnd.ms-access";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='rar'){
                                 type = "application/x-rar-compressed, application/octet-stream";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='mdb'){
                                 type = "application/zip, application/octet-stream";
                                 url = url+'file/'+pj+'/'+pj;
                             }else if(extension=='odt'){
                                 type = "application/vnd.oasis.opendocument.text";
                                 url = url+'file/'+pj+'/'+pj;
                                 viewable = true;
                             }else /*if(extension=='txt'||extension=='sql')*/{
                                 url = url+'text/'+pj+'/'+pj;
                                 type = "text/plain";
                             }//end if(extension=='pdf')
                             $http.get(url, {responseType: "arraybuffer"})
                                     .then(function(response){
//                                         console.log("$scope.piecejointeviewAction  ============================================= "+type+" === file name : "+pj);
//                                         var filename = response.headers['x-filename'];
//                                         var contentType = response.headers['content-type'];
                                         try{
                                             if(viewable==true){ 
                                                var viewer = document.createElement("iframe");
                                                 viewer.setAttribute("id","iframeviewer");
                                                 viewer.setAttribute("src",url);
                                                 viewer.setAttribute("alt","pdf");
                                                 viewer.setAttribute("width","100%");
                                                 viewer.setAttribute("height","500px");
                  //                               viewer.setAttribute("pluginspage","http://www.adobe.com/products/acrobat/readstep2.html");
                  //                               viewer.setAttribute("class","ng-isolate-scope");
                                                 var divElem = document.createElement("div");
                                                 divElem.setAttribute("id","viewbody");
                                                 divElem.setAttribute("width","100%");
                                                 divElem.setAttribute("height","100%");
                                                 divElem.appendChild(viewer);
                                                 // ///Remplacement dans la vue
                                                 var items = $(document).find("div");
                                                 for(var i=0; i<items.length;i++){
                                                     if(items.eq(i).attr("id")==="viewerbody"){
                                                           items.eq(i).replaceWith(divElem);
 //                                                           console.log(" ======================= on a trouve report  innerpanel");
                                                     }//end if(items.eq(i).attr("id")=="innerpanel")  
                                                 }//end for(var i=0; i<items.length;i++)
                                                 var compileFn = $compile(divElem);
                                                 compileFn($scope);   
                                                  var arrayBufferView = new Uint8Array(response.data );
                                                  var blob = new Blob( [ arrayBufferView ], { type: type } );
                                                  var urlCreator = window.URL || window.webkitURL;
                                                  var pdfUrl = urlCreator.createObjectURL( blob );
                                                  var pdf = document.querySelector("#iframeviewer");
                                                  pdf.src = pdfUrl;                                                  
                                                  $("#viewerid").modal("toggle");
                                                  $("#viewerid").modal("show");
                                              }else{
                                                   var linkElement = document.createElement('a');
                                                   var arrayBufferView = new Uint8Array(response.data );
                                                    var blob = new Blob( [ arrayBufferView ], { type: type } );
                                                    var urlCreator = window.URL || window.webkitURL;
                                                    var docUrl = urlCreator.createObjectURL( blob );
                                                    linkElement.setAttribute('href', docUrl);
                                                    linkElement.setAttribute("download", pj);
                                                    linkElement.setAttribute("target", "_blank");
                                                    var clickEvent = new MouseEvent("click", {
                                                        "view": window,
                                                        "bubbles": true,
                                                        "cancelable": false
                                                    });
                                                    linkElement.dispatchEvent(clickEvent);
                                              }
                                         } catch (ex) {
                                           commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+ex.message,"danger");
                                        }
                                         commonsTools.hideDialogLoading();
                                     },function(error){
                                         commonsTools.hideDialogLoading();
                                         commonsTools.showMessageDialog(error);
                                     });
                         }else{
                             commonsTools.hideDialogLoading();
                             commonsTools.notifyWindow("Une erreur est servenu pendant le traitement" ,"<br/>"+"Impossible de trouve la piÃƒÂ¨ce jointe  : "+pj,"danger");
                         }//end if(pj)
                     
         };
          /**
           * 
           * @returns {undefined}
           */
         $scope.showReport = function(){               
                            var report = $scope.dataCache["report"];
                            $http.defaults.headers.common['predicats']= angular.toJson($scope.predicats); 
                            $http.defaults.headers.common['values']= angular.toJson($scope.getSelectLines()); 
                            var url = 'http://'+$location.host()+':'+$location.port()+'/'+angular.lowercase(report.model)+'/'+angular.lowercase(report.entity)+'/'+report.method;
                            commonsTools.showDialogLoading("Chargement ...","white","#9370db","0%","0%");      
             //$http.get(url, {responseType: 'arraybuffer',data:angular.toJson($scope.temporalData)})
                            if(report.extern==false){
                                $http.put(url,$scope.temporalData)
                                        .then(function(response){
                                            $scope.temporalDatas = response.data;   
             //                               console.log("$scope.addDialogAction ========= "+angular.toJson($scope.temporalDatas));
                                            commonsTools.hideDialogLoading();
                                            $scope.displayReportPanel(report.script);  
                                        },function(error){
                                            commonsTools.showMessageDialog(error);
                                            commonsTools.hideDialogLoading();
                                        });
                            }else{
                                  $http.put(url,$scope.temporalData, {responseType: 'arraybuffer'})
                                    .then(function(response){
                                           var contentElem = $scope.viewSelector("report");
             //                               console.log(angular.toJson("$scope.addDialogAction ====== "+angular.toJson(response)));
                                            var viewer = document.createElement("iframe");
                                            viewer.setAttribute("id","iframe0001");
                                            viewer.setAttribute("src",url);
                                            viewer.setAttribute("alt","pdf");
                                            viewer.setAttribute("width","100%");
                                            viewer.setAttribute("height","700px");
             //                               viewer.setAttribute("pluginspage","http://www.adobe.com/products/acrobat/readstep2.html");
             //                               viewer.setAttribute("class","ng-isolate-scope");
                                            var divElem = document.createElement("div");
                                            divElem.setAttribute("id","report");
                                            divElem.setAttribute("width","100%");
                                            divElem.setAttribute("height","100%");
                                            divElem.appendChild(viewer);
                                            var items = contentElem.find('div');
                                             for(var i=0; i<items.length;i++){
                                                if(items.eq(i).attr("id")==="report"){
                                                      items.eq(i).replaceWith(divElem);                               
                                                }//end if(items.eq(i).attr("id")==="report"){  
                                            }//enn$d for(var i=0; i<items.length;i++){                               
                                            // ///Remplacement dans la vue
                                           var items = $element.find("div");
                                           for(var i=0; i<items.length;i++){
                                                if(items.eq(i).attr("id")=="innerpanel"){
                                                      items.eq(i).replaceWith(contentElem);
                                                       //console.log(" ======================= on a trouve report  innerpanel");
                                                }//end if(items.eq(i).attr("id")=="innerpanel")  
                                           }//end for(var i=0; i<items.length;i++)
                                            var compileFn = $compile(contentElem);
                                            compileFn($scope);                              
                                             var arrayBufferView = new Uint8Array(response.data );
                                             var blob = new Blob( [ arrayBufferView ], { type: "application/pdf" } );
                                             var urlCreator = window.URL || window.webkitURL;
                                             var pdfUrl = urlCreator.createObjectURL( blob );
                                             var pdf = document.querySelector( "#iframe0001");
                                             pdf.src = pdfUrl;
             //                               console.log($scope.temporalData);                      
                                             commonsTools.hideDialogLoading();
                                    },function(error){
                                        commonsTools.showMessageDialog(error);
                                        commonsTools.hideDialogLoading();
                                    });
                            }//end if(report.extern==false)
              
//               console.log("Critere de recherh=c*************** "+$scope.dataCache["report"]+" === "+angular.toJson($scope.temporalData));
              
         };
        
      },      
      /**
       * 
       * @param {type} scope
       * @param {type} element
       * @param {type} attrs
       * @returns {undefined}
       */
    	link : function(scope , element , attrs){                  
                  scope.listFrameBuilder(scope.metaData);
                  //var partial =angular.element(document.querySelector('#container'));
                  //console.log("Vous etes "+partial.html());
                  // console.log("enabledVerticalMenu = "+scope.enabledVerticalMenu);
                  
    	      }
    };
    angular.module('mainApp')
        .directive('fileinput',function(){
             return{  
                 require:"^headerBuilder",
                 scope:{
                     fileinput:"=fileinput",
                     filepreview: "=filepreview"
                 },
                 //replace:true,
                 link:function(scope , element, attrs){
                        element.bind("onchange",function(changeEvent){
                           scope.fileinput = changeEvent.target.files[0];
                           //console.log("link:function(scope , element, attrs) ========= "+scope.fileinput);
                           var reader = new FileReader();
                           reader.onload = function(loadEvent){
                               scope.$apply(function(){
                                   scope.filepreview = loadEvent.target.result;
                               });
                           };
                           reader.readAsDataURL(scope.fileinput);
                        });
                    }              
            };
        });

});