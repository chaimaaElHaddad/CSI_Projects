
INSERT INTO `role` VALUES ('BENEFICIAIRE','Bénéficiaire de formation'),('FORMATEUR','Formateur');

INSERT INTO `users` VALUES (1,'Jamaa Mezouak, Tétouan',1,'chaimaahaddad7@gmail.com','chaimaa','0636954339','Chaimaa ElHaddad','BENEFICIAIRE'),(2,'Jamaa Mezouak, Tétouan',1,'sarah.zoumhan@gmail.com','sara','06','Sara Zoumhan','BENEFICIAIRE'),(3,'Akba Halouf, Tétouan',1,'intissar.harras@gmail.com','intissar','06','Intissar Harras','BENEFICIAIRE'),(4,'Wllah Man3raf',1,'naanai@gmail.com','naanai','06','Naanai','FORMATEUR');

INSERT INTO `curriculum_vitae` VALUES (1,4);

INSERT INTO `formation` VALUES (1,'Faculté des scioences de Tétouan','2020-04-02 00:00:00.000000','formation1',20,'objectif1 , objectif2','prerequis1',300,4);

INSERT INTO `element_de_formation` VALUES (1,'2020-04-02','element 1',1,'objectif 1','prerequis1 , prerequis 2',100,60),(2,'2020-04-03','element 2',1,'objectif 2','element 1',200,120);

INSERT INTO `element_inscription` VALUES (1,1),(2,1),(1,2),(3,2);

INSERT INTO `evaluation` VALUES (1,1,0),(2,2,0);

INSERT INTO `evaluation_accueil_criteres` VALUES (1,10,'Espace de travail'),(1,5,'Matériel'),(1,20,'Propreté');

INSERT INTO `evaluation_contenu_criteres` VALUES (1,10,'L\'atteinte des objectifs de la formation'),(1,20,'L\'intérêt du sujet de formation');

INSERT INTO `evaluation_formateur_criteres` VALUES (1,15,'Compétence'),(1,20,'Disponibilité'),(1,15,'Façon d\'expliquer'),(1,15,'Gentillesse'),(1,20,'Maitrise du sujet');
