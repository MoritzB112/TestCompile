alter table Activity drop foreign key FKe0jbumyl1uuwpmkpv6bky1pgw;
alter table Activity drop foreign key FKjvo90mt2b7gryt0g0vf07fsgn;
alter table Activity drop foreign key FK3cfvrsbkk3q138h7q7gopn1rn;
alter table Activity drop foreign key FK19xahm3cbjum3oyvlnnho6iut;
alter table Activity drop foreign key FK6hfolh57yy0y7u02yy64i8ak9;
alter table Activity drop foreign key FKdo26eqa2daku4wqd375nnf65s;
alter table Activity drop foreign key FKjqul3hypdobjudbrybojaj1fi;
alter table Activity drop foreign key FK6vyjg340yw2l3vxtjppne3mc1;
alter table Activity drop foreign key FKdi2ufm7w0utk2sf0ap44i09vd;
alter table AttributesActivity drop foreign key FKmi5nlo4yu5dq4d8awrp7mobou;
alter table AttributesActivity drop foreign key FK6nouiylxo0nkdbh7wpymgpnmg;
alter table Business drop foreign key FKiljv8torir7lrgkgpr1cbbiey;
alter table Classroom drop foreign key FKin3biew7xhysviiyfrcyvb8vt;
alter table Classroom drop foreign key FKf402ctiqumh8d30qpr3xet3uk;
alter table Collective drop foreign key FK4dsajmyuauvlaewq4xg1bpblp;
alter table Discount drop foreign key FKbqqh2q8iql0kwjrqnksye6g9i;
alter table Edition drop foreign key FKrdc6x8funa2i6fswd4ijwjh6t;
alter table Edition drop foreign key FKnpc2savdl998sqt1e3aonaul4;
alter table Event drop foreign key FKduei6x0bene10m102j0g2jl4c;
alter table Event drop foreign key FKgl8qo7eo5h4t6bv0gy3pj17lx;
alter table Event drop foreign key FKrvxfvl9mcc252be3eduo0h1b2;
alter table Faculty drop foreign key FK5t4takui4mij26m90nnh7a6s7;
alter table Headquarter drop foreign key FKcq6gysd2rs4ae44ikektyl9t6;
alter table LanguageLevel drop foreign key FKnp71ohoprrffw1px4vas7v6kp;
alter table MailTemplate drop foreign key FKf7cui14im0qi3g54t2h0qnbma;
alter table MailTemplate drop foreign key FK5w92wup9440qe03qx27naqmj4;
alter table Modality drop foreign key FK9kblmcmi1l3eu9iae8rkwa9nr;
alter table Participator drop foreign key FK3551fyp73kj2ameij82hlqobg;
alter table Participator drop foreign key FKit4a824lme34vpnp13ebnvten;
alter table ParticipatorInvoice drop foreign key FKgnuvwf1i6yfmcxjwccdgvwbta;
alter table ParticipatorInvoice drop foreign key FK3g5rmk0tvrdadoftfi83jco9a;
alter table ParticipatorRole drop foreign key FKporkfrfgau4pnceitv60d9a5w;
alter table ParticipatorRole drop foreign key FKqh2b7qvmkgr40ds0kuvr0xu78;
alter table ParticipatorRole drop foreign key FKq3mot4qmlxtecphd81g3ktb67;
alter table PaymentAccount drop foreign key FKdqjmfxc3lkqni657s7mky352o;
alter table Question drop foreign key FKbll3ikvslflfaieu8ro6xcswp;
alter table Rate drop foreign key FKq8ca991epdwol0am7o14bdbae;
alter table Rate drop foreign key FKtne6tkdhc39lqddvl34dqe878;
alter table Rating drop foreign key FKr81a2d0heu8e76bojnlukd20r;
alter table Registration drop foreign key FKg0fsp1hx0kulpfs3n8oul703e;
alter table Registration drop foreign key FK9xvmm3gxsqha73h8fu18jsdkn;
alter table Registration drop foreign key FK8h0smm4ix3yaq52slbk72g6ln;
alter table Registration drop foreign key FKgcycd4dbxg0t3je9c4ufuo757;
alter table Registration drop foreign key FKc4mb4nu4sqken6lnqjch3smuq;
alter table Registration drop foreign key FK9dm51jj12akhckdhn48g2vjbk;
alter table Registration drop foreign key FK2mob6sfgmnw5xaosa9edq8mun;
alter table Registration drop foreign key FKeb2bnppytukjyrylpvnfxto1r;
alter table RequiredDocument_collectives drop foreign key FKqnsf93vv4yqytbo8j8iwunp7b;
alter table RequiredDocument_collectives drop foreign key FKirmv6nh0tqa2mg3q2v70a758p;
alter table RequiredDocument_rates drop foreign key FKac6h3scnhe0y8j745u1qu56he;
alter table RequiredDocument_rates drop foreign key FKgmxsekfpu4n4mw76u2wvihtg6;
alter table Schedule drop foreign key FKei2o6nr0lu4lop5gdg55pj5ak;
alter table Schedule drop foreign key FKli4b8t3g39gubqmhqk1hikk76;
alter table Schedule drop foreign key FKg09avto9051pn7v72p8276ijl;
alter table Section drop foreign key FKin492c5gupsferv9sya2lqbvp;
alter table Section drop foreign key FK4ge3vreqik5uj686xhikhwpb6;
alter table Student drop foreign key FKhbq2fmo2nop8wunsqw07udxq6;
alter table Student drop foreign key FKg4jnkjk5wnhgu9qhbu2v3rl4v;
alter table Student drop foreign key FKeo9m861cmammnjdcx7kf3yisr;
alter table Student drop foreign key FKg5662gnd93q9fuxt2bd4rth69;
alter table Student drop foreign key FKaw70kg92s7e3hb7wv11d06vj2;
alter table Student drop foreign key FKbpuu6itcqale7jincp83tk8fy;
alter table Student drop foreign key FK71mki646okj84exsgi6kngaxp;
alter table Student drop foreign key FKm3qh1a08rpebbi30ca3e3o2f6;
alter table Student_businesses drop foreign key FKqjwisw8484apqgqwpxc2nda98;
alter table Student_businesses drop foreign key FKlcyxwvreavjro6p8xhdvbss8c;
alter table User drop foreign key FKd0k2t48roy5rd5xalxgn7nu3e;
alter table User drop foreign key FK8875ptb7wua2wgeymprloxcns;
alter table User drop foreign key FKqv7u340h10m3tgg0rsr5ydbba;
alter table WebPage drop foreign key FK6iff9e6h2sg4y5wuang3ansjb;
alter table WebPage drop foreign key FKf5ho5gppmm6xjycpbd6kvofpb;
drop table if exists Activity;
drop table if exists AppUser;
drop table if exists Atribute;
drop table if exists AttributesActivity;
drop table if exists BillingType;
drop table if exists Business;
drop table if exists Campus;
drop table if exists City;
drop table if exists Classroom;
drop table if exists Collective;
drop table if exists Comission;
drop table if exists Country;
drop table if exists Department;
drop table if exists DiplomaType;
drop table if exists Discount;
drop table if exists Edition;
drop table if exists EducationalLevel;
drop table if exists Event;
drop table if exists Faculty;
drop table if exists Gender;
drop table if exists Headquarter;
drop table if exists IdentificationDocument;
drop table if exists Language;
drop table if exists LanguageLevel;
drop table if exists MailTemplate;
drop table if exists MailType;
drop table if exists Modality;
drop table if exists Participator;
drop table if exists ParticipatorInvoice;
drop table if exists ParticipatorRole;
drop table if exists PaymentAccount;
drop table if exists PaymentType;
drop table if exists Question;
drop table if exists Rate;
drop table if exists Rating;
drop table if exists RatingType;
drop table if exists Registration;
drop table if exists RegistrationState;
drop table if exists RequiredDocument;
drop table if exists RequiredDocument_collectives;
drop table if exists RequiredDocument_rates;
drop table if exists RetentionType;
drop table if exists Role;
drop table if exists Schedule;
drop table if exists Section;
drop table if exists Student;
drop table if exists Student_businesses;
drop table if exists Title;
drop table if exists TypeRegister;
drop table if exists University;
drop table if exists User;
drop table if exists WebPage;
