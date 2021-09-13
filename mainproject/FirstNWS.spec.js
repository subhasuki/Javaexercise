    const assert = require('chai').assert;
  describe('Jquery Site', function () {

    xtest('Window handle', function (browser) {
      browser
        .maximizeWindow()
        .url("https://jqueryui.com/demos/")
        .execute('scrollTo(0,3000)')
        .waitForElementVisible('body', 1000)
        .resizeWindow(1000, 800)
        .execute('scrollTo(0,3000)')
        .setWindowPosition(0, 0)
        .execute('scrollTo(0,3000)')
        .setWindowSize(400, 600)
      // .closeWindow();
    }),

      test('Window position', function (browser) {
        // Retrieve the attributes
        browser.getWindowPosition(function (value) {
          console.log("Window position: " + value);
        });
      }),

      xtest('Accordion', function (browser) {
        browser
          .useXpath()
          .waitForElementPresent("//*[@id='sidebar']/aside[2]/ul/li[1]/a", 20000)
          .click("//*[@id='sidebar']/aside[2]/ul/li[1]/a")
          .waitForElementVisible('body', 5000)
          .frame(0)
          .findElement('.ui-widget')
          .click('#accordion>h3:nth-child(1)')
      }),

      xtest('AutoComplete', function (browser) {

        browser
          .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .useXpath()
          .click('//a[text()="Autocomplete"]')
          .waitForElementVisible('body')
          .frame(0)
          .findElement('.ui-widget')
          .assert.visible('#tags')
          .click('#tags')
          .clearValue('#tags')
          .setValue('#tags', 'C')
          .assert.containsText('#ui-id-1>li:nth-child(4)', 'C')
          .click('#ui-id-1>li:nth-child(4)')

          .click('#tags')
          .clearValue('#tags')
          .setValue('#tags', 'script')
          .assert.containsText('#ui-id-1>li:nth-child(1)', 'ActionScript')
          .click('#ui-id-1>li:nth-child(1)')

          .click('#tags')
          .clearValue('#tags')
          .setValue('#tags', 'script')
          .assert.containsText('#ui-id-1>li:nth-child(2)', 'AppleScript')
          .click('#ui-id-1>li:nth-child(2)')

          .click('#tags')
          .clearValue('#tags')
          .setValue('#tags', 'jscript')
          .expect.element('#tags').text.to.not.equal('JavaScript')
      }),

      xtest('Button', async function (browser) {
        browser
          .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .useXpath()
          .click('//a[text()="Button"]')
          .useCss()
          .frame(0)
          .findElement('.widget')
          .useXpath()
          .click('//button[text()="A button element"]')
          .pause(5000)
          .expect.element('//button[text()="A button element"]').to.have.css('background').which.contains | matches('rgb(0, 127, 255)')
        // console.log(clr)
        // console.log(clr.value)
        const gclr = clr.value
        console.log("sdfghjk")
        console.log('Border Color' + gclr)
        assert('1px solid rgb(0,62,255)', clr.value);
      }),

      xtest('CheckBox Radio', function (browser) {
        browser
          .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .execute('scrollTo(0,500)')
          .useXpath()
          .click('//a[text()="Checkboxradio"]')
          .maximizeWindow()
          .useCss()
          .frame(0)
          .findElement('.widget')
          .useXpath()

          // - - - - - - - -     [ Radio Button ]   - - - - - - - -

          // .waitForElementPresent('//label[@for="radio-1"]')
          .click('//label[@for="radio-1"]')
        var getbg = browser.getCssProperty('//label[@for="radio-1"]', 'background')
        // browser.assert.cssProperty('//label[@for="radio-1"]', "background", "rgb(0, 127, 255");
        assert('rgb(0, 127, 255', getbg.value)

        // .waitForElementPresent('//label[@for="radio-2"]')
        browser.click('//label[@for="radio-2"]')
        var getbg1 = browser.getCssProperty('//label[@for="radio-2"]', 'background')
        assert('rgb(0, 127, 255', getbg1.value)

        // .waitForElementPresent('//label[@for="radio-3"]')
        browser.click('//label[@for="radio-3"]')
        var getbg2 = browser.getCssProperty('//label[@for="radio-3"]', 'background')
        assert('rgb(0, 127, 255', getbg2.value)

        // - - - - - - - -     [ Check Box ]   - - - - - - - -

        // .waitForElementPresent('//label[@for="checkbox-1"]')
        browser.click('//label[@for="checkbox-1"]')
        var getbg_ck = browser.getCssProperty('//label[@for="checkbox-1"]', 'background')
        assert('rgb(0, 127, 255', getbg_ck.value)

        // .waitForElementPresent('//label[@for="checkbox-2"]')
        browser.click('//label[@for="checkbox-2"]')
        var getbg1_ck = browser.getCssProperty('//label[@for="checkbox-2"]', 'background')
        assert('rgb(0, 127, 255', getbg1_ck.value)
        browser.expect.element('//label[@for="checkbox-2"]').to.not.be.selected;

        // .waitForElementPresent('//label[@for="checkbox-3"]')
        browser.click('//label[@for="checkbox-3"]')
        var getbg2_ck = browser.getCssProperty('//label[@for="checkbox-3"]', 'background')
        assert('rgb(0, 127, 255', getbg2_ck.value)

        // .waitForElementPresent('//label[@for="checkbox-4"]')
        browser.click('//label[@for="checkbox-4"]')
        var getbg3_ck = browser.getCssProperty('//label[@for="checkbox-4"]', 'background')
        assert('rgb(0, 127, 255', getbg3_ck.value)

        // - - - - - - - -     [ Div Scroll ]   - - - - - - - -

        browser.useCss()
        var scr = browser.findElement('.widget')
        scr.scrollDown = 500

        // - - - - - - - -     [ Check Box nested in label ]   - - - - - - - -

        browser.useXpath()
        // .waitForElementPresent('//label[@for="checkbox-1"]')
        browser.click('//label[@for="checkbox-nested-1"]')
        var getbg_ckn = browser.getCssProperty('//label[@for="checkbox-nested-1"]', 'background')
        assert('rgb(0, 127, 255', getbg_ckn.value)

        // .waitForElementPresent('//label[@for="checkbox-2"]')
        browser.click('//label[@for="checkbox-nested-2"]')
        var getbg1_ckn = browser.getCssProperty('//label[@for="checkbox-nested-2"]', 'background')
        assert('rgb(0, 127, 255', getbg1_ckn.value)
        browser.expect.element('//label[@for="checkbox-nested-2"]').to.not.be.selected;

        // .waitForElementPresent('//label[@for="checkbox-3"]')
        browser.click('//label[@for="checkbox-nested-3"]')
        var getbg2_ckn = browser.getCssProperty('//label[@for="checkbox-nested-3"]', 'background')
        assert('rgb(0, 127, 255', getbg2_ckn.value)

        // .waitForElementPresent('//label[@for="checkbox-4"]')
        browser.click('//label[@for="checkbox-nested-4"]')
        var getbg3_ckn = browser.getCssProperty('//label[@for="checkbox-nested-4"]', 'background')
        assert('rgb(0, 127, 255', getbg3_ckn.value)
      }),

      xtest('Controlgroup', async function (browser) {
        await browser
          .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .execute('scrollTo(0,500)')
          .useXpath()
          .click('//a[text()="Controlgroup"]')
          .useCss()
          .frame(0)
          .findElement('.widget')
          .useCss()
          .click('#car-type-button')

          .useXpath()
          .click('//*[@id="ui-id-2"]')
          .useCss()
        var opt_ast = await browser.getText('.ui-selectmenu-text')
        assert(opt_ast, 'Midsize car')

          .useXpath()
          .click('//*[@id="ui-id-3]')
          .useCss()
        var opt_ast1 = await browser.getText('.ui-selectmenu-text')
        assert(opt_ast1, 'Full size car')



          // - - - - - - - -     [ Drop Down ]   - - - - - - - -

          .click('#car-type-button')
          .click('select#car-type>option:nth-child(2) option[value=Compact car]')
        var cm = browser.findElement('select#car-type>option:nth-child(1)')
        cm.click
        var gcm = cm.getText()
        console.log(gcm)
        browser.assert.containsText('select#car-type>option:nth-child(2)', 'Midsize car')

          // - - - - - - - -     [ Radio And checkbox ]   - - - - - - - -

        .useXpath()
        browser.click('//label[@for="transmission-standard"]')
        var stand = browser.getCssProperty('//label[@for="transmission-standard"]', 'background')
        assert('rgb(0, 127, 255', stand.value)

        browser.click('//label[@for="transmission-automatic"]')
        var automat = browser.getCssProperty('//label[@for="transmission-automatic"]', 'background')
        assert('rgb(0, 127, 255', automat.value)

        browser.click('//label[@for="insurance"]')
        var insurance = browser.getCssProperty('//label[@for="insurance"]', 'background')
        assert('rgb(0, 127, 255', insurance.value)

        // - - - - - - - -     [ Number of cars ]   - - - - - - - -

        browser.useCss()
        browser.click('input#horizontal-spinner')
        browser.clearValue('input#horizontal-spinner')
        browser.setValue('input#horizontal-spinner', '-2')
        var cars = browser.getText('input#horizontal-spinner')
        assert(cars, '-2')

        browser.click('input#horizontal-spinner')
        browser.clearValue('input#horizontal-spinner')
        browser.setValue('input#horizontal-spinner', '-2')
        browser.click("a.ui-spinner-down")
        browser.timeoutsImplicitWait(10000)
        var cars_sp = browser.getText('input#horizontal-spinner')
        assert.notEqual(cars_sp, '-2')

        browser.click('input#horizontal-spinner')
        browser.clearValue('input#horizontal-spinner')
        browser.setValue('input#horizontal-spinner', '1')
        var car1 = browser.getText('input#horizontal-spinner')
        assert(car1, '1')

        browser.click('input#horizontal-spinner')
        browser.clearValue('input#horizontal-spinner')
        browser.setValue('input#horizontal-spinner', '1')
        browser.click("a.ui-spinner-up")
        browser.timeoutsImplicitWait(10000)
        var car1_sp = browser.getText('input#horizontal-spinner')
        assert(car1_sp, '2')

        browser.click('input#horizontal-spinner')
        browser.clearValue('input#horizontal-spinner')
        browser.setValue('input#horizontal-spinner', '1000')
        var cars2 = browser.getText('input#horizontal-spinner')
        assert(cars2, '1000')

        // - - - - - - - -     [ BookNow ]   - - - - - - - -

        browser.useXpath()
        browser.waitForElementPresent("//button[text()='Book Now!']")
        browser.click("//button[text()='Book Now!']")
        var booknow = browser.getCssProperty("//button[text()='Book Now!']", 'background')
        assert('rgb(0, 127, 255', booknow.value)

        // - - - - - - - -     [ Radio And checkbox Vertical]   - - - - - - - -

        browser.click('//label[@for="transmission-standard-v"]')
        var standv = browser.getCssProperty('//label[@for="transmission-standard"]', 'background')
        assert('rgb(0, 127, 255', standv.value)

        browser.click('//label[@for="transmission-automatic-v"]')
        var automatv = browser.getCssProperty('//label[@for="transmission-automatic"]', 'background')
        assert('rgb(0, 127, 255', automatv.value)

        browser.click('//label[@for="insurance-v"]')
        var insurance = browser.getCssProperty('//label[@for="insurance-v"]', 'background')
        assert('rgb(0, 127, 255', insurance.value)

        // - - - - - - - -     [ Div Scroll ]   - - - - - - - -

        browser.useCss()
        var scr = browser.findElement('.widget')
        scr.scrollDown = 500

        // - - - - - - - -     [ Radio And checkbox ]   - - - - - - - -

        browser.useCss()
        browser.click('input#vertical-spinner')
        browser.clearValue('input#vertical-spinner')
        browser.setValue('input#vertical-spinner', '-2')
        var cars = browser.getText('input#vertical-spinner')
        assert(cars, '-2')

        browser.click('input#vertical-spinner')
        browser.clearValue('input#vertical-spinner')
        browser.setValue('input#vertical-spinner', '-2')
        browser.click("a.ui-spinner-down")
        browser.timeoutsImplicitWait(10000)
        var cars_sp1 = browser.getText('input#vertical-spinner')
        assert.notEqual(cars_sp1, '-2')

        browser.click('input#vertical-spinner')
        browser.clearValue('input#vertical-spinner')
        browser.setValue('input#vertical-spinner', '1')
        var car1 = browser.getText('input#vertical-spinner')
        assert(car1, '1')

        browser.click('input#vertical-spinner')
        browser.clearValue('input#vertical-spinner')
        browser.setValue('input#vertical-spinner', '1')
        browser.click("a.ui-spinner-up")
        browser.timeoutsImplicitWait(10000)
        var car1_sp1 = browser.getText('input#vertical-spinner')
        assert(car1_sp1, '2')

        browser.click('input#vertical-spinner')
        browser.clearValue('input#vertical-spinner')
        browser.setValue('input#vertical-spinner', '1000')
        var cars2 = browser.getText('input#vertical-spinner')
        assert(cars2, '1000')

        // - - - - - - - -     [ BookNow Button ] - - - - - - - - - -

        browser.useXpath()
        browser.waitForElementPresent("//button[@id='book']")
        browser.click("//button[@id='book']")
        var booknow = browser.getCssProperty("//button[@id='book']", 'background')
        assert('rgb(0, 127, 255', booknow.value)
      }),

      xtest('DatePicker', function (browser) {
        browser
          .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .execute('scrollTo(0,500)')
          .useXpath()
          .click('//a[text()="Datepicker"]')
          .useCss()
          .findElement('#content')
          .frame(0)

          // .click('#datepicker')
          // .setValue('#datepicker','30/35/20200')
          // .keys(browser.keys.ENTER)
          // .pause(10000)
          // .end()

          .click('#datepicker')
          .click(".ui-datepicker-calendar>tbody>tr>td:nth-child(5)>a")
        var date = browser.getText('#datepicker')
        assert(date, '09/08/2021')

        // - - - - - - - -     [ Previous-Button ] - - - - - - - - - -

        browser.click('#ui-datepicker-div>.ui-datepicker-header>a:nth-child(1)')
        // browser.useCss()
        var month = browser.getText('.ui-datepicker-title > .ui-datepicker-month')
        assert(month, 'August')
        var year = browser.getText('.ui-datepicker-title > .ui-datepicker-year')
        assert(year, '2021')

        browser.click(".ui-datepicker-calendar > tbody > tr > td:nth-child(5) > a")
        browser.pause(5000)
        var prvclr = browser.getCssProperty(".ui-datepicker-calendar > tbody > tr > td:nth-child(5) > a", 'background')
        assert('rgb(0, 127, 255', prvclr.value)
        var prevdate = browser.getText('#datepicker')
        assert(prevdate, '08/05/2021')

        // - - - - - - - -     [ Next-Button ] - - - - - - - - - -

        browser.click('#datepicker')
        browser.clearValue('#datepicker')
        browser.click('#ui-datepicker-div > .ui-datepicker-header > a:nth-child(2)')
        var nmonth = browser.getText('.ui-datepicker-title > .ui-datepicker-month')
        assert(nmonth, 'September')
        var nyear = browser.getText('.ui-datepicker-title > .ui-datepicker-year')
        assert(nyear, '2021')

        browser.click(".ui-datepicker-calendar > tbody > tr > td:nth-child(6) > a")
        var ndate = browser.getText('#datepicker')
        assert(ndate, '09/09/2021')
        var nclr = browser.getCssProperty(".ui-datepicker-calendar > tbody > tr > td:nth-child(6)", 'background')
        assert('rgb(0, 127, 255', nclr.value)
      }),

      xtest('Dialog', function (browser) {
        browser
          .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .execute('scrollTo(0,500)')
          .useXpath()
          .click('//a[text()="Dialog"]')
          .useCss()
          .findElement('#content')
          .frame(0)
        // .useXpath()
        // .moveToElement('//div[@class="ui-draggable-handle"]', 100, 1000)
        // .mouseButtonDown(0)
        // .pause(5000);
        var dialog = browser.findElement('#dialog>p')
        assert(dialog, "This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.")
      }),

      xtest('Progressbar', function (browser) {
        browser
          .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .execute('scrollTo(0,500)')
          .useXpath()
          .click('//a[text()="Progressbar"]')
          .useCss()
          .findElement('#content')
          .frame(0)
          .waitForElementPresent('#progressbar')
          // .setValue('#progressbar style[width=90%]','nightwatch')
          // .getElementById('progressbar').style.width="90%"
          .execute(setElementValue, ['#progressbar > div', 'width:90%'])
        // .setValue('#progressbar','new text to be write.')
      }),

      xtest('Menu',async function (browser) {
        browser
          .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .execute('scrollTo(0,500)')
          .useXpath()
          .click('//a[text()="Menu"]')
          .useCss()
          .findElement('#content')
          .frame(0)
          .waitForElementVisible('#ui-id-1')
          var toys =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('none', toys.value)

          browser.click('#ui-id-2')
          var books =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', books.value)

          browser.click('#ui-id-3')
          var cloth =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', cloth.value)

          browser.click('#ui-id-4')
          browser.pause(2000)
          var cloth =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', cloth.value)

          browser.waitForElementVisible('#ui-id-5')
          var homeenter =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('none', homeenter.value)

          browser.click('#ui-id-6')
          var carhifi =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', carhifi.value)

          browser.click('#ui-id-7')
          var Utilities =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', Utilities.value)

          browser.click('#ui-id-8')
          var move =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', move.value)

          browser.click('#ui-id-9')
          browser.pause(2000)
          var music =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', music.value)        

          browser.click('#ui-id-10')
          browser.pause(2000)
          var rock =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', rock.value)

          browser.click('#ui-id-11')
          var alternative = await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', alternative.value)

          browser.click('#ui-id-12')
          var classic = await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', classic.value)

          browser.click('#ui-id-13')
          browser.pause(2000)
          var Jazz = await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', Jazz.value)

          browser.click('#ui-id-14')
          browser.pause(2000)
          var freeJazz = await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('rgb(0, 127, 25', freeJazz.value)

          // browser.click('#ui-id-15')
          // browser.pause(2000)
          // var bigband = await browser.getCssProperty('.ui-state-disabled', 'background')
          // assert('rgb(0, 127, 25', bigband.value)

          // browser.click('#ui-id-16')
          // browser.pause(2000)
          // var morden = await browser.getCssProperty('.ui-state-disabled', 'background')
          // assert('rgb(0, 127, 25', morden.value)

          // browser.click('#ui-id-17')
          // browser.pause(2000)
          // var pop = await browser.getCssProperty('.ui-state-disablede', 'background')
          // assert('rgb(0, 127, 25', pop.value)

          browser.waitForElementVisible('#ui-id-5')
          var special =await browser.getCssProperty('.ui-state-disabled', 'background')
          assert('none', special.value)
      }),

      xtest('Menu',async function (browser) {
        browser
          .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .execute('scrollTo(0,500)')
          .useXpath()
          .click('//a[text()="Selectmenu"]')
          .useCss()
          .findElement('#content')
          .frame(0)

          var medium = browser.getText('#speed-button')
          assert(medium,'Medium')
          browser.click('#speed-button')
          browser.click('#ui-id-1')
          var slower = browser.getText('.ui-selectmenu-text')
          assert(slower,'Slower')
          var slowerbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', slowerbg.value)

          browser.click('#speed-button')
          browser.click('#ui-id-4')
          var fast = browser.getText('.ui-selectmenu-text')
          assert(fast,'Fast')
          var fastbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', fastbg.value)

          browser.click('#speed-button')
          browser.click('#ui-id-5')
          var faster = browser.getText('.ui-selectmenu-text')
          assert(faster,'Faster')
          var fasterbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', fasterbg.value)

          var jqurey = browser.getText('#files-button')
          assert(jqurey,'jQuery.js')
          browser.click('#files-button')
          browser.useXpath()
          browser.click('//div[text()="ui.jQuery.js"]')
          browser.useCss()
          var jqeryjs = browser.getText('.ui-selectmenu-text')
          assert(jqeryjs,'ui.jQuery.js')
          var jqeryjsbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', jqeryjsbg.value)

          var scrbody = browser.findElement('body')
          scrbody.scrollDown = 200

          browser.click('#files-button')
          browser.useXpath()
          browser.click('//div[text()="Some unknown file"]')
          browser.useCss()
          var some = browser.getText('.ui-selectmenu-text')
          assert(some,'Some unknown file')
          var somebg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', somebg.value)

          browser.click('#files-button')
          browser.useXpath()
          browser.click('//div[text()="Some other file with a very long option text"]')
          browser.useCss()
          var someother = browser.getText('.ui-selectmenu-text')
          assert(someother,'Some other file with a very long option text')
          var someotherbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', someotherbg.value)


          var jqurey = browser.getText('#number-button')
          assert(jqurey,'2')
          browser.click('#number-button')
          browser.useXpath()
          browser.click('//div[text()="5"]')
          browser.useCss()
          var nine = browser.getText('.ui-selectmenu-text')
          assert(nine,'5')
          var ninebg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', ninebg.value)

          browser.click('#number-button')
          browser.useXpath()
          browser.click('//div[text()="7"]')
          browser.useCss()
          var leven = browser.getText('.ui-selectmenu-text')
          assert(leven,'7')
          var levenbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', levenbg.value)

          browser.click('#number-button')
          browser.useXpath()
          browser.click('//div[text()="6"]')
          browser.useCss()
          var six = browser.getText('.ui-selectmenu-text')
          assert(six,'6')
          var sixbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', sixbg.value)

          var scrwid = browser.findElement('#number-menu')
          scrwid.scrollDown = 500

          browser.click('#number-button')
          browser.useXpath()
          browser.click('//div[text()="19"]')
          browser.useCss()
          var nineteen = browser.getText('.ui-selectmenu-text')
          assert(nineteen,'19')
          var nineteenbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', nineteenbg.value)


          var pickone = browser.getText('#salutation-button')
          assert(pickone,'Please pick one')
          browser.click('#salutation-button')
          browser.useXpath()
          browser.click('//div[text()="Mr."]')
          browser.useCss()
          var mr = browser.getText('.ui-selectmenu-text')
          assert(mr,'Mr.')
          var mrbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', mrbg.value)

          browser.click('#salutation-button')
          browser.useXpath()
          browser.click('//div[text()=""]')
          var prof = browser.getText('.ui-selectmenu-text')
          assert(prof,'Prof.')
          var profbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', profbg.value)

          browser.click('#salutation-button')
          browser.click('#ui-id-29')
          var other = browser.getText('.ui-selectmenu-text')
          assert(other,'Faster')
          var otherbg = await browser.getCssProperty('.ui-menu-item-wrapper', 'background')
          assert('rgb(0, 127, 25', otherbg.value)
      }),

      xtest('Spinner',async function (browser) {
        browser
        .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .execute('scrollTo(0,500)')
          .useXpath()
          .click('//a[text()="Spinner"]')
          .useCss()
          .findElement('.demo-list')
          .frame(0)
          .waitForElementVisible('#spinner')

          browser.useCss()
          browser.click('#getvalue')
          browser.getAlertText((results) => {
            var alertText = results.value
            console.log("Alert TEXT Value......"+alertText)//just a quick test to see what it grabbed
            assert(alertText,'null')
        })
          browser.acceptAlert()

          .click('#disable')
          var dis = browser.getAttribute('#spinner','disabled')
          assert.notEqual(dis,'true')

          browser.click('#disable')
          var dis1 = browser.getAttribute('#spinner','disabled')
          assert.notEqual(dis1,'false')

          browser.click('#destroy')
          browser.useXpath()
          var disno = browser.getValue('//input[@name="value"]')
          assert.notEqual(disno,'values')

          browser.useCss()
          browser.click('#destroy')
          browser.useXpath()
          var disno1 = browser.getValue('//input[@class="ui-spinner-input"]')
          assert(disno1,'ui-spinner-input')

          browser.useCss()
          browser.click('#destroy')
          browser.useXpath()
          browser.useCss()
          browser.setValue('#spinner','1234567890')
          browser.useXpath()
          var disno6 = browser.getText('//input[@id="spinner"]')
          assert(disno6,'1234567890')

          browser.useCss()
          browser.click('#destroy')
          browser.click('#getvalue')
          browser.getAlertText((results) => {
            var alertText = results.value
            console.log("Alert TEXT Value......"+alertText)//just a quick test to see what it grabbed
            assert(alertText,'1234567890')
        })
          browser.acceptAlert()


          browser.useCss()
          browser.click('#destroy')
          browser.useXpath()
          browser.useCss()
          browser.setValue('#spinner','subha123')
          browser.useXpath()
          var disno4 = browser.getText('//input[@id="spinner"]')
          assert(disno4,'subha123')

          browser.useCss()
          browser.click('#destroy')
          browser.click('#getvalue')
          browser.getAlertText((results) => {
            var alertText = results.value
            console.log("Alert TEXT Value......"+alertText)//just a quick test to see what it grabbed
            assert(alertText,'null')
        })
          browser.acceptAlert()

          browser.useCss()
          await browser.click('#setvalue')
          var setvalbg = browser.getCssProperty('.ui-button', 'background')
          assert('rgb(0, 127, 25', setvalbg.value)
          browser.useXpath()
          var disno3 = browser.getText('//input[@id="spinner"]')
          assert(disno3,'5')

          browser.useCss()
          browser.click('span.ui-icon-triangle-1-n')
          browser.useXpath()
          var disno7 = browser.getText('//input[@id="spinner"]')
          assert(disno7,'6')

          browser.useCss()
          browser.click('span.ui-icon-triangle-1-s')
          browser.useXpath()
          var disno7 = browser.getText('//input[@id="spinner"]')
          assert(disno7,'5')

          browser.useCss()
          browser.click('#getvalue')
          browser.getAlertText((results) => {
            var alertText = results.value
            console.log("Alert TEXT Value......"+alertText)//just a quick test to see what it grabbed
            assert(alertText,'5')
        })
          browser.acceptAlert()
      }),

      test('Tabs',function (browser) {
        browser
        .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .execute('scrollTo(0,500)')
          .useXpath()
          .click('//a[text()="Tabs"]')
          .useCss()
          .findElement('.demo-list')
          .frame(0)
          // .waitForElementVisible('#spinner')

          .useXpath()
          .click('//a[text()="Nunc tincidunt"]')
          .useCss()
          var para = browser.getText('#tabs-1 > p') //console.log(para)
          assert(para,'Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus')

          browser.useXpath()
          browser.click('//a[text()="Proin dolor"]')
          browser.useCss()
          var para1 = browser.getText('#tabs-2 > p')
          console.log(para1)
          browser.expect.text.to.contain(para1,'Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam.')

          browser.useXpath()
          browser.click('//a[text()="Aenean lacinia"]')
          browser.useCss()
          var para2 = browser.getText('#tabs-3 > p')
          assert(para2,'Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna.')
      }),
      xtest('ToolTip',function (browser) {
        browser
        .maximizeWindow()
          .url("https://jqueryui.com/demos/")
          .execute('scrollTo(0,500)')
          .useXpath()
          .click('//a[text()="Tabs"]')
          .useCss()
          .findElement('#Tooltip')
          .frame(0)
      })
  });                                                                        


