[#ftl]
[@c.page title="${osoba.jmeno!} ${osoba.prijmeni!}"]
    [@form.form method="post" bind="osoba"]
        <div class="col-md-6">
            [@form.input label="Jméno" name="jmeno" maxlength="100" required="required" /]
        </div>
        <div class="col-md-6">
            [@form.input label="Příjmení" name="prijmeni" maxlength="100" required="required" /]
        </div>
        <div class="col-12">
            [@form.input label="Adresa" name="adresa" maxlength="200" required="required" /]
        </div>
        <div class="col-md-6">
            [@form.inputDate label="Datum narození" name="datumNarozeni" required="required" /]
        </div>
        <div class="col-md-6">
            [@form.input label="Věk" name="vek" type="number" readonly="readonly" /]
        </div>
        <div class="col-md-6">
            [@form.input label="E-mail" name="email" type="email" /]
        </div>
        <div class="col-md-6">
            [@form.input label="Telefon" name="telefon" type="tel" minlength="9" maxlength="13"/]
        </div>
        <div class="col-12 d-flex justify-content-end">
            [#if osoba.id??]
                <button type="submit" class="btn btn-light" name="akce" value="smazat">Smazat</button>
                <button type="submit" class="btn btn-primary">Uložit</button>
            [#else ]
                <button type="submit" class="btn btn-primary">Přidat</button>
            [/#if]

        </div>
    [/@form.form]
[/@c.page]
