package org.mrpaulwoods.employee

import groovy.json.JsonSlurper
import org.mrpaulwoods.employee.payroll.Payroll
import org.mrpaulwoods.employee.payroll.PayrollRepository
import org.mrpaulwoods.employee.person.Person
import org.mrpaulwoods.employee.person.PersonRepository
import org.mrpaulwoods.employee.profile.Profile
import org.mrpaulwoods.employee.profile.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

/**
 * Created on 3/7/2016.
 */
@Component
class Bootstrap {

    private final PersonRepository personRepository
    private final ProfileRepository profileRepository
    private final PayrollRepository payrollRepository

    @Autowired
    Bootstrap(PersonRepository personRepository,
              ProfileRepository profileRepository,
              PayrollRepository payrollRepository) {
        this.personRepository = personRepository
        this.profileRepository = profileRepository
        this.payrollRepository = payrollRepository
    }

    @PostConstruct
    def init() {
        new JsonSlurper().parseText(data).each { record ->
            Person person = new Person()
            person.firstName = record.firstname
            person.lastName = record.lastname
            personRepository.save person

            Profile profile = new Profile()
            profile.person = person
            profile.street = record.street
            profile.city = record.city
            profile.state = record.state
            profile.zip = record.zip
            profileRepository.save profile

            Payroll payroll = new Payroll()
            payroll.person = person
            payroll.salary = new BigDecimal(record.salary)
            payrollRepository.save payroll
        }

    }

    String data = '''
[
	{
		"firstname": "Ira",
		"lastname": "Grant",
		"street": "7527 Vivamus Rd.",
		"city": "Chelsea",
		"state": "Quebec",
		"zip": "99368-670",
		"salary": 157011
	},
	{
		"firstname": "Colin",
		"lastname": "Rose",
		"street": "Ap #452-761 Proin Road",
		"city": "Chelsea",
		"state": "QC",
		"zip": "1334VG",
		"salary": 135741
	},
	{
		"firstname": "Lucas",
		"lastname": "Guzman",
		"street": "P.O. Box 452, 8112 Rutrum St.",
		"city": "Macduff",
		"state": "BA",
		"zip": "UY9S 1RG",
		"salary": 119550
	},
	{
		"firstname": "Randall",
		"lastname": "Welch",
		"street": "4883 Nullam Ave",
		"city": "Renfrew",
		"state": "Ontario",
		"zip": "8132",
		"salary": 148708
	},
	{
		"firstname": "Connor",
		"lastname": "Melendez",
		"street": "P.O. Box 970, 7029 Iaculis Av.",
		"city": "Hamburg",
		"state": "HH",
		"zip": "39611",
		"salary": 94902
	},
	{
		"firstname": "Gareth",
		"lastname": "Roberson",
		"street": "Ap #866-1255 Cras Rd.",
		"city": "Woodlands County",
		"state": "AB",
		"zip": "7802ZG",
		"salary": 182694
	},
	{
		"firstname": "Craig",
		"lastname": "Brooks",
		"street": "P.O. Box 310, 2126 Lacinia Ave",
		"city": "Siedlce",
		"state": "Mazowieckie",
		"zip": "11160",
		"salary": 161898
	},
	{
		"firstname": "Wallace",
		"lastname": "Buckner",
		"street": "Ap #453-6602 Ornare Street",
		"city": "Hamburg",
		"state": "Hamburg",
		"zip": "01092",
		"salary": 147126
	},
	{
		"firstname": "Noble",
		"lastname": "Lynn",
		"street": "Ap #495-6908 Aliquet Street",
		"city": "Fontanellato",
		"state": "ERM",
		"zip": "6440CN",
		"salary": 153176
	},
	{
		"firstname": "Ian",
		"lastname": "Carney",
		"street": "535-8925 Nascetur Rd.",
		"city": "Tumba",
		"state": "Stockholms län",
		"zip": "10014",
		"salary": 120210
	},
	{
		"firstname": "Carl",
		"lastname": "Farmer",
		"street": "P.O. Box 285, 3581 Aliquet Av.",
		"city": "Crato",
		"state": "Ceará",
		"zip": "73618",
		"salary": 189532
	},
	{
		"firstname": "Hasad",
		"lastname": "Goodwin",
		"street": "857-1920 Nunc Road",
		"city": "Málaga",
		"state": "Andalucía",
		"zip": "3718",
		"salary": 175883
	},
	{
		"firstname": "Addison",
		"lastname": "Pierce",
		"street": "P.O. Box 215, 316 Mus. Street",
		"city": "Napier",
		"state": "NI",
		"zip": "24993",
		"salary": 160204
	},
	{
		"firstname": "Channing",
		"lastname": "Kim",
		"street": "Ap #439-2765 At, St.",
		"city": "Patos",
		"state": "Paraíba",
		"zip": "58226-896",
		"salary": 157125
	},
	{
		"firstname": "Hall",
		"lastname": "Ferguson",
		"street": "914 Quam Street",
		"city": "Poitiers",
		"state": "PO",
		"zip": "0598NW",
		"salary": 194068
	},
	{
		"firstname": "Scott",
		"lastname": "Stout",
		"street": "Ap #516-1152 Eget Rd.",
		"city": "Hamburg",
		"state": "Hamburg",
		"zip": "80-603",
		"salary": 88399
	},
	{
		"firstname": "Reed",
		"lastname": "White",
		"street": "719-1701 Ac Avenue",
		"city": "Algeciras",
		"state": "Andalucía",
		"zip": "910659",
		"salary": 134245
	},
	{
		"firstname": "Kenneth",
		"lastname": "Mccarthy",
		"street": "9799 Iaculis Av.",
		"city": "Murwara",
		"state": "Madhya Pradesh",
		"zip": "9576",
		"salary": 124182
	},
	{
		"firstname": "Erasmus",
		"lastname": "Benton",
		"street": "Ap #461-2389 Ornare, St.",
		"city": "Chestermere",
		"state": "AB",
		"zip": "QI2 4QE",
		"salary": 197490
	},
	{
		"firstname": "Graiden",
		"lastname": "Coffey",
		"street": "2577 Nulla Road",
		"city": "Sapele",
		"state": "Delta",
		"zip": "9362",
		"salary": 141137
	},
	{
		"firstname": "Hu",
		"lastname": "Bailey",
		"street": "P.O. Box 123, 1514 Risus St.",
		"city": "Kano",
		"state": "Kano",
		"zip": "51710",
		"salary": 193335
	},
	{
		"firstname": "Gabriel",
		"lastname": "Walsh",
		"street": "Ap #318-5786 Nibh St.",
		"city": "Salice Salentino",
		"state": "Puglia",
		"zip": "81015",
		"salary": 126873
	},
	{
		"firstname": "Akeem",
		"lastname": "Wells",
		"street": "P.O. Box 843, 1772 Metus Street",
		"city": "Galway",
		"state": "C",
		"zip": "52419-992",
		"salary": 93127
	},
	{
		"firstname": "Talon",
		"lastname": "Bridges",
		"street": "833-4152 Nec St.",
		"city": "Oosterhout",
		"state": "N.",
		"zip": "895301",
		"salary": 93309
	},
	{
		"firstname": "Clark",
		"lastname": "Kerr",
		"street": "377-3280 Lectus Ave",
		"city": "Grande Prairie",
		"state": "AB",
		"zip": "733741",
		"salary": 121065
	},
	{
		"firstname": "Reed",
		"lastname": "Castaneda",
		"street": "8015 Sit Av.",
		"city": "Liévin",
		"state": "NO",
		"zip": "491952",
		"salary": 76239
	},
	{
		"firstname": "Samson",
		"lastname": "Mckinney",
		"street": "668-7287 Sapien. Rd.",
		"city": "Wodonga",
		"state": "Victoria",
		"zip": "90486",
		"salary": 163806
	},
	{
		"firstname": "Tate",
		"lastname": "Ortiz",
		"street": "6409 Non, Rd.",
		"city": "Bauchi",
		"state": "BA",
		"zip": "15278",
		"salary": 173950
	},
	{
		"firstname": "Alan",
		"lastname": "Leblanc",
		"street": "740-9412 Non Ave",
		"city": "Maser",
		"state": "VEN",
		"zip": "4798",
		"salary": 163945
	},
	{
		"firstname": "Jonah",
		"lastname": "Allison",
		"street": "Ap #722-4768 Sagittis Rd.",
		"city": "Talgarth",
		"state": "Brecknockshire",
		"zip": "1243",
		"salary": 82569
	},
	{
		"firstname": "Chaney",
		"lastname": "Gonzales",
		"street": "1352 Ut Av.",
		"city": "Åkersberga",
		"state": "AB",
		"zip": "24000",
		"salary": 132068
	},
	{
		"firstname": "Adrian",
		"lastname": "Riley",
		"street": "1092 Aliquam Road",
		"city": "Berlin",
		"state": "Berlin",
		"zip": "10948",
		"salary": 106796
	},
	{
		"firstname": "Shad",
		"lastname": "Emerson",
		"street": "P.O. Box 666, 1678 Purus. Avenue",
		"city": "Veere",
		"state": "Zl",
		"zip": "2857",
		"salary": 124385
	},
	{
		"firstname": "Barry",
		"lastname": "Rich",
		"street": "Ap #495-905 Ad St.",
		"city": "Rouen",
		"state": "Haute-Normandie",
		"zip": "61496",
		"salary": 153839
	},
	{
		"firstname": "Benjamin",
		"lastname": "Medina",
		"street": "6168 Per Rd.",
		"city": "Vienna",
		"state": "Wie",
		"zip": "5388",
		"salary": 164574
	},
	{
		"firstname": "Connor",
		"lastname": "Dominguez",
		"street": "Ap #435-6782 Dignissim. Road",
		"city": "Norrköping",
		"state": "E",
		"zip": "4683",
		"salary": 83902
	},
	{
		"firstname": "Magee",
		"lastname": "Garrison",
		"street": "754-7529 Maecenas St.",
		"city": "Sossano",
		"state": "Veneto",
		"zip": "792617",
		"salary": 178313
	},
	{
		"firstname": "Samuel",
		"lastname": "Mcleod",
		"street": "9227 Integer Avenue",
		"city": "Cork",
		"state": "M",
		"zip": "97717",
		"salary": 111406
	},
	{
		"firstname": "Kirk",
		"lastname": "Carney",
		"street": "104-8154 Nibh. Ave",
		"city": "Berlin",
		"state": "BE",
		"zip": "10084",
		"salary": 173337
	},
	{
		"firstname": "Colt",
		"lastname": "Hester",
		"street": "P.O. Box 991, 5353 Auctor St.",
		"city": "Newmarket",
		"state": "ON",
		"zip": "10321-235",
		"salary": 98144
	},
	{
		"firstname": "Otto",
		"lastname": "Franklin",
		"street": "594-696 Pede. Ave",
		"city": "Tampa",
		"state": "FL",
		"zip": "065681",
		"salary": 165076
	},
	{
		"firstname": "Wade",
		"lastname": "Manning",
		"street": "7325 Curabitur St.",
		"city": "Whyalla",
		"state": "South Australia",
		"zip": "04050",
		"salary": 88893
	},
	{
		"firstname": "Sylvester",
		"lastname": "Lyons",
		"street": "6996 Felis Rd.",
		"city": "L�vis",
		"state": "Quebec",
		"zip": "6448EQ",
		"salary": 153512
	},
	{
		"firstname": "Craig",
		"lastname": "Berger",
		"street": "5666 Fusce Ave",
		"city": "Florida",
		"state": "VII",
		"zip": "4318",
		"salary": 78890
	},
	{
		"firstname": "Xenos",
		"lastname": "Taylor",
		"street": "Ap #858-6175 Dolor St.",
		"city": "Jelenia Góra",
		"state": "DS",
		"zip": "C1S 5K9",
		"salary": 101974
	},
	{
		"firstname": "Dalton",
		"lastname": "Zamora",
		"street": "P.O. Box 303, 8505 Magna, St.",
		"city": "Chemnitz",
		"state": "SN",
		"zip": "8865",
		"salary": 159423
	},
	{
		"firstname": "Nero",
		"lastname": "Hoover",
		"street": "209-3897 Enim, St.",
		"city": "Brucargo",
		"state": "Vlaams-Brabant",
		"zip": "62995",
		"salary": 148362
	},
	{
		"firstname": "Rahim",
		"lastname": "Allison",
		"street": "207-4755 Lobortis Ave",
		"city": "Werbomont",
		"state": "LU",
		"zip": "319803",
		"salary": 86598
	},
	{
		"firstname": "Seth",
		"lastname": "Dominguez",
		"street": "241-8236 Massa. Ave",
		"city": "Blind River",
		"state": "Ontario",
		"zip": "47097",
		"salary": 113338
	},
	{
		"firstname": "Bradley",
		"lastname": "Ochoa",
		"street": "P.O. Box 416, 4735 Sed, St.",
		"city": "Zoetermeer",
		"state": "Zuid Holland",
		"zip": "740852",
		"salary": 144697
	},
	{
		"firstname": "Upton",
		"lastname": "Williams",
		"street": "P.O. Box 887, 7455 Pede. Street",
		"city": "Quesada",
		"state": "A",
		"zip": "11491-089",
		"salary": 139928
	},
	{
		"firstname": "Hall",
		"lastname": "Harrington",
		"street": "Ap #224-6864 Integer Av.",
		"city": "Murcia",
		"state": "Murcia",
		"zip": "41410",
		"salary": 85186
	},
	{
		"firstname": "Keefe",
		"lastname": "Kemp",
		"street": "P.O. Box 630, 6132 Quam St.",
		"city": "Montauban",
		"state": "MI",
		"zip": "80546",
		"salary": 87368
	},
	{
		"firstname": "Ian",
		"lastname": "Burnett",
		"street": "7425 Nec, Av.",
		"city": "Kilwinning",
		"state": "Ayrshire",
		"zip": "119420",
		"salary": 199216
	},
	{
		"firstname": "Lester",
		"lastname": "Scott",
		"street": "229-1006 Interdum Rd.",
		"city": "Valera Fratta",
		"state": "LOM",
		"zip": "9855",
		"salary": 176320
	},
	{
		"firstname": "Daniel",
		"lastname": "Nielsen",
		"street": "P.O. Box 355, 8811 Etiam St.",
		"city": "Minna",
		"state": "NI",
		"zip": "53503",
		"salary": 116145
	},
	{
		"firstname": "Erasmus",
		"lastname": "Moody",
		"street": "2667 Semper Street",
		"city": "Levin",
		"state": "NI",
		"zip": "55362",
		"salary": 107911
	},
	{
		"firstname": "Upton",
		"lastname": "Cox",
		"street": "3199 Tortor. Street",
		"city": "Canberra",
		"state": "ACT",
		"zip": "80876",
		"salary": 120772
	},
	{
		"firstname": "Malcolm",
		"lastname": "Fields",
		"street": "7119 Donec St.",
		"city": "Neubrandenburg",
		"state": "Mecklenburg-Vorpommern",
		"zip": "649335",
		"salary": 102614
	},
	{
		"firstname": "Barclay",
		"lastname": "Gibbs",
		"street": "Ap #834-6945 Ultrices St.",
		"city": "Brandon",
		"state": "Manitoba",
		"zip": "579655",
		"salary": 141984
	},
	{
		"firstname": "Griffith",
		"lastname": "Carpenter",
		"street": "8594 Est, Rd.",
		"city": "Putignano",
		"state": "PUG",
		"zip": "13450",
		"salary": 185254
	},
	{
		"firstname": "Myles",
		"lastname": "Snow",
		"street": "Ap #621-5364 Orci, Ave",
		"city": "San Vicente",
		"state": "San José",
		"zip": "1557",
		"salary": 168764
	},
	{
		"firstname": "Beck",
		"lastname": "Hull",
		"street": "Ap #625-8199 Sodales Av.",
		"city": "Gaziantep",
		"state": "Gaz",
		"zip": "26675-673",
		"salary": 102902
	},
	{
		"firstname": "Marvin",
		"lastname": "Reese",
		"street": "968-1481 Erat, Street",
		"city": "Södertälje",
		"state": "AB",
		"zip": "S2E 2G0",
		"salary": 96591
	},
	{
		"firstname": "Ulysses",
		"lastname": "Barlow",
		"street": "Ap #237-5184 Enim. Av.",
		"city": "Canberra",
		"state": "ACT",
		"zip": "12495",
		"salary": 88265
	},
	{
		"firstname": "Elton",
		"lastname": "Galloway",
		"street": "Ap #285-9585 Vivamus St.",
		"city": "Rotorua",
		"state": "North Island",
		"zip": "6117",
		"salary": 91515
	},
	{
		"firstname": "August",
		"lastname": "Hardy",
		"street": "753-3942 Ac Avenue",
		"city": "Sosnowiec",
		"state": "Sląskie",
		"zip": "86128",
		"salary": 104100
	},
	{
		"firstname": "Elliott",
		"lastname": "Myers",
		"street": "P.O. Box 732, 2660 Sollicitudin St.",
		"city": "Vienna",
		"state": "Wie",
		"zip": "49-322",
		"salary": 183877
	},
	{
		"firstname": "Alec",
		"lastname": "Barnett",
		"street": "335-6178 Varius St.",
		"city": "Spijkenisse",
		"state": "Zuid Holland",
		"zip": "21146",
		"salary": 155411
	},
	{
		"firstname": "Quinlan",
		"lastname": "Sears",
		"street": "P.O. Box 779, 7342 Eu Rd.",
		"city": "Belfast",
		"state": "U",
		"zip": "71076",
		"salary": 183742
	},
	{
		"firstname": "Amal",
		"lastname": "Mccarthy",
		"street": "Ap #815-5647 Orci Rd.",
		"city": "Cottbus",
		"state": "Brandenburg",
		"zip": "40658",
		"salary": 189868
	},
	{
		"firstname": "Tyler",
		"lastname": "Weeks",
		"street": "Ap #920-7765 Adipiscing Av.",
		"city": "Turrialba",
		"state": "C",
		"zip": "84289-028",
		"salary": 182448
	},
	{
		"firstname": "Fuller",
		"lastname": "Oneal",
		"street": "4247 Eget Road",
		"city": "Chicoutimi",
		"state": "Quebec",
		"zip": "247729",
		"salary": 97641
	},
	{
		"firstname": "Noah",
		"lastname": "Hancock",
		"street": "P.O. Box 602, 2892 Nisi. Av.",
		"city": "Berlin",
		"state": "Berlin",
		"zip": "131667",
		"salary": 83135
	},
	{
		"firstname": "Carson",
		"lastname": "Nichols",
		"street": "Ap #611-8286 Neque St.",
		"city": "Manukau",
		"state": "North Island",
		"zip": "F1V 9CG",
		"salary": 145218
	},
	{
		"firstname": "Tanek",
		"lastname": "Bradford",
		"street": "P.O. Box 903, 9423 Eget Ave",
		"city": "Tay",
		"state": "Ontario",
		"zip": "38914",
		"salary": 134557
	},
	{
		"firstname": "Wing",
		"lastname": "Lyons",
		"street": "P.O. Box 598, 133 Iaculis Rd.",
		"city": "North Las Vegas",
		"state": "Nevada",
		"zip": "L2B 7R4",
		"salary": 128204
	},
	{
		"firstname": "Geoffrey",
		"lastname": "Sparks",
		"street": "P.O. Box 166, 8188 Consequat Street",
		"city": "Palma de Mallorca",
		"state": "Illes Balears",
		"zip": "187857",
		"salary": 167676
	},
	{
		"firstname": "Vladimir",
		"lastname": "Hammond",
		"street": "413-7985 A, Rd.",
		"city": "Suruç",
		"state": "Şan",
		"zip": "6074",
		"salary": 114392
	},
	{
		"firstname": "Damon",
		"lastname": "Salinas",
		"street": "9771 Imperdiet, Rd.",
		"city": "Vienna",
		"state": "Vienna",
		"zip": "9204",
		"salary": 104352
	},
	{
		"firstname": "Howard",
		"lastname": "Vega",
		"street": "Ap #439-2138 Lorem, Ave",
		"city": "Berlin",
		"state": "Berlin",
		"zip": "55600",
		"salary": 78978
	},
	{
		"firstname": "Damon",
		"lastname": "Flynn",
		"street": "P.O. Box 633, 2520 Sit St.",
		"city": "Assiniboia",
		"state": "SK",
		"zip": "154039",
		"salary": 164423
	},
	{
		"firstname": "Brenden",
		"lastname": "Russell",
		"street": "P.O. Box 483, 4554 Quis, St.",
		"city": "Bremerhaven",
		"state": "HB",
		"zip": "Y7C 1PK",
		"salary": 189466
	},
	{
		"firstname": "Ivor",
		"lastname": "Herrera",
		"street": "Ap #962-1341 Netus Ave",
		"city": "Funtua",
		"state": "KT",
		"zip": "8706CU",
		"salary": 150558
	},
	{
		"firstname": "Hiram",
		"lastname": "Davenport",
		"street": "P.O. Box 610, 4266 Euismod Rd.",
		"city": "North Las Vegas",
		"state": "Nevada",
		"zip": "95-311",
		"salary": 122676
	},
	{
		"firstname": "Edward",
		"lastname": "Hurley",
		"street": "1260 Ligula Av.",
		"city": "Petorca",
		"state": "V",
		"zip": "995351",
		"salary": 101563
	},
	{
		"firstname": "Mark",
		"lastname": "Cohen",
		"street": "P.O. Box 339, 6076 Donec St.",
		"city": "Belmont",
		"state": "Western Australia",
		"zip": "779141",
		"salary": 132518
	},
	{
		"firstname": "Jared",
		"lastname": "Bartlett",
		"street": "5916 Gravida Road",
		"city": "Tobermory",
		"state": "AR",
		"zip": "94239",
		"salary": 129712
	},
	{
		"firstname": "Kelly",
		"lastname": "Roth",
		"street": "Ap #760-1624 Non, St.",
		"city": "Clackmannan",
		"state": "CL",
		"zip": "46679",
		"salary": 153602
	},
	{
		"firstname": "Lars",
		"lastname": "Moore",
		"street": "Ap #166-8633 Donec Rd.",
		"city": "Wieze",
		"state": "Oost-Vlaanderen",
		"zip": "51299",
		"salary": 111298
	},
	{
		"firstname": "Victor",
		"lastname": "Manning",
		"street": "P.O. Box 445, 8331 Lectus Road",
		"city": "Chillán",
		"state": "VII",
		"zip": "XU5 4FX",
		"salary": 177758
	},
	{
		"firstname": "Perry",
		"lastname": "Tate",
		"street": "9500 Mauris, St.",
		"city": "Huara",
		"state": "Tarapacá",
		"zip": "60217",
		"salary": 167394
	},
	{
		"firstname": "Nehru",
		"lastname": "Oneil",
		"street": "763-8192 Egestas St.",
		"city": "Hulst",
		"state": "Zl",
		"zip": "61300",
		"salary": 187529
	},
	{
		"firstname": "Noble",
		"lastname": "Camacho",
		"street": "9914 Urna. St.",
		"city": "Rocky View",
		"state": "AB",
		"zip": "6576",
		"salary": 175911
	},
	{
		"firstname": "Aaron",
		"lastname": "Tran",
		"street": "Ap #637-9846 Tristique Avenue",
		"city": "Bydgoszcz",
		"state": "KP",
		"zip": "51013",
		"salary": 141541
	},
	{
		"firstname": "Roth",
		"lastname": "Farley",
		"street": "1901 Libero Road",
		"city": "Tacoma",
		"state": "WA",
		"zip": "10229",
		"salary": 165123
	},
	{
		"firstname": "Matthew",
		"lastname": "Cole",
		"street": "Ap #981-7378 Ut Street",
		"city": "Farrukhabad-cum-Fatehgarh",
		"state": "Uttar Pradesh",
		"zip": "E0E 4Y8",
		"salary": 93321
	},
	{
		"firstname": "Paul",
		"lastname": "Porter",
		"street": "451-967 Mauris. Rd.",
		"city": "Nevers",
		"state": "Bourgogne",
		"zip": "5531",
		"salary": 154314
	},
	{
		"firstname": "George",
		"lastname": "Hicks",
		"street": "3828 Mauris, Street",
		"city": "Osorno",
		"state": "X",
		"zip": "41-414",
		"salary": 76527
	},
	{
		"firstname": "Oren",
		"lastname": "Sullivan",
		"street": "7918 Adipiscing Rd.",
		"city": "Valera Fratta",
		"state": "LOM",
		"zip": "78-502",
		"salary": 148164
	}
]
'''


}
