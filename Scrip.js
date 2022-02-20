const url = 'http://localhost:8080/testAPI/api/login';/*URL de java web service*/
const cacheName = 'Players';/*nom de la cache coté client*/




class Playersc { /*classe Js représente les attributs de Player*/

    constructor(firstname, lastname, Score, match) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.Score = Score;
        this.match = match;
    }

}

class game {


    async getPlayers() {/* méthode pour retourner les players depuis l'api ainsi que de le stocker dans le cache*/

        try {
            const p1 = new Array();
            let result = await fetch(url);
            let data = await result.json();
            caches.open(cacheName).then(cache => {
                cache.add(url).then(() => {
                    console.log("Data cached ")
                });
            });

            let Players = data.Players;
            Players.map(item => {

                p1.push(new Playersc(item.firstname, item.lastname, item.Score, item.Matches));
            })
            return p1

        } catch (error) {
            console.log(error)
        }
    }
}

class Display {/**/


    displayPlayers(Players) {/* methode pour afficher le tableau qui représente l'Histogramme*/

        let result = "";
        let result2 = "";
        Players.forEach((item) => {

            let firstname = item.firstname;
            let lastname = item.lastname;
            let Score = item.Score;

            if (firstname == "Larry") { // premier graphe de  Larry
                result = `<table class="graph">
    <caption> <fieldset ><u> ${firstname} ${lastname}</u> : Histogramme de comparaison des points durant le mois de septembre en 2016
    </fieldset>
    <div id="titre"></div> </caption>
    <thead  ></thead><tbody id="ga">`;
                for (const x in item.match) {
                    result += `<tr style="height:${item.match[x]/10}%">
           <th >${x.slice(5, 10)}</th><td onclick='tdclick(${JSON.stringify(firstname)},${JSON.stringify(Score)},${JSON.stringify(x)},${item.match[x]});'>
           <span>${item.match[x]}</span></td></tr>`;
                }
                result += `</tbody></table><br><br><br><br><br><br><br><br><br><br>`;

            } else if (firstname == "John") {// Deuxieme garphe de  John
                result2 = `  <table class="graph">
        <caption> <fieldset ><u> ${firstname} ${lastname}</u> : Histogramme de comparaison des points durant le mois de septembre en 2016
    </fieldset>
   <div id="titre2"></div> 
 </caption><br><br>
    <thead>
   
    </thead>
    <tbody id="ga">`;

                for (const x in item.match) {
                    result2 += `<tr style="height:${item.match[x]/10}%">
           <th >${x.slice(5, 10)}</th>
             <td style='background:#1460db;' onclick='tdclick(${JSON.stringify(firstname)},${JSON.stringify(Score)},${JSON.stringify(x)},${item.match[x]});'><span>${item.match[x]}</span></td>
         </tr>`;
                }
                result2 += `  </tbody>
</table> `
                document.getElementById("chart").innerHTML = result + result2;
            }

        })
    }
}


const getUrlParams = url => `${url}#`.split('#')[1] // fonction pour retourner les paramètres et les valeurs depuis URL  
    .split('&').reduce((params, pair) =>
        ((key, val) => key ? {
            ...params,
            [key]: val
        } : params)
        (...`${pair}=`.split('=').map(decodeURIComponent)), {});


setTimeout(function() {
    ShowfromURL();

    function ShowfromURL() {/* fonction qu'affiche les donnes depuis l'URL*/
 
        const params = getUrlParams(window.location.href);
        //console.log("*****" + params["user"] + params["score"] + params["date"] + params["point"]);


        if (params["user"] == "Larry") {
            document.getElementById("titre").innerHTML = `<div style=" border: thick double #32a1ce; text-align: cntre;color:#0e1b30; font:bold 60%/110% arial; margin-top: 30px; margin-left: 30px; width:500px; position:centre;"> Le score est ${params["score"] }, la barre s\u00e9lectionn\u00e9e ${params["date"] },${params["point"] } </div></caption>`;
       

        } else {
       document.getElementById("titre2").innerHTML = `<div style=" border: thick double #32a1ce; text-align: cntre;color:#0e1b30; font:bold 60%/110% arial; margin-top: 30px; margin-left: 30px; width:500px; position:centre;"> Le score est ${score}, la barre s\u00e9lectionn\u00e9e ${key},${value} </div></caption>`;
         }
    }
}, 2000);

function tdclick(user = "", score = "", key = "", value = "") {/* changement de URL et spécification de bar selectionnée */

    location.hash = "user=" + user + "&date=" + key + "&point=" + value + "&score=" + score;

    window.addEventListener('hashchange', () => { 
        if (user == "Larry") {
            document.getElementById("titre").innerHTML = `<div style=" border: thick double #32a1ce; text-align: cntre;color:#0e1b30; font:bold 60%/110% arial; margin-top: 30px; margin-left: 30px; width:500px; position:centre;"> Le score est ${score}, la barre s\u00e9lectionn\u00e9e ${key},${value} </div></caption>`;
        } else {
           document.getElementById("titre2").innerHTML = `<div style=" border: thick double #32a1ce; text-align: cntre;color:#0e1b30; font:bold 60%/110% arial; margin-top: 30px; margin-left: 30px; width:500px; position:centre;"> Le score est ${score}, la barre s\u00e9lectionn\u00e9e ${key},${value} </div></caption>`;
        }

    });
}


document.addEventListener("DOMContentLoaded", () => { /* HTML initial a été complètement chargé et analysé avec ces composants, sans Css files soit chargé.*/
    const game1 = new game();
    const display = new Display();

    game1.getPlayers().then(game1 => display.displayPlayers(game1))
})