[#ftl]

[@c.page title="Seznam osob"]
    [#list osoby]
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Jméno</th>
                <th scope="col">Příjmení</th>
                <th scope="col">Datum narození</th>
                <th scope="col">Adresa</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            [#items as osoba]
                <tr>
                    <td>${osoba.jmeno}</td>
                    <td>${osoba.prijmeni}</td>
                    <td>${osoba.datumNarozeni?date}</td>
                    <td>${osoba.adresa}</td>
                    <td class="d-flex justify-content-end"><a href="/${osoba.id}" class="btn btn-primary">Detail</a></td>
                </tr>
            [/#items]
            </tbody>
        </table>
    [#else]
        <p class="fst-italic">Seznam osob je prázdný.</p>
    [/#list]
    <div class="d-flex justify-content-end">
        <a href="/novy" class="btn btn-success">Nový člen</a>
    </div>
[/@c.page]
