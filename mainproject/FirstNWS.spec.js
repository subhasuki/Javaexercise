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
        .expect.element('//button[text()="A button element"]').to.have.css('background').which.contains|matches('rgb(0, 127, 255)')
        // console.log(clr)
        // console.log(clr.value)
        const gclr = clr.value
        console.log("sdfghjk")
        console.log('Border Color'+gclr)
        assert('1px solid rgb(0,62,255)', clr.value);
    }), 

    xtest('CheckBox Radio',async function(browser){
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

    test('Controlgroup', function(browser){
      browser
        .maximizeWindow()
        .url("https://jqueryui.com/demos/")
        .execute('scrollTo(0,500)')
        .useXpath()
        .click('//a[text()="Controlgroup"]')
        .useCss()
        .frame(0)
        .findElement('.widget')
        .useCss()
        .assert.containsText('#car-type-button', 'Compact car')

        // .click('#car-type-button')
        // .click('select#car-type>option:nth-child(2) option[value=Compact car]')
        // var cm =browser.findElement('select#car-type>option:nth-child(1)')
        // cm.click
        // var gcm = cm.getText()
        // console.log(gcm)
        // browser.assert.containsText('select#car-type>option:nth-child(2)','Midsize car')

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

        browser.useCss()
        browser.click('input#horizontal-spinner')
        browser.clearValue('input#horizontal-spinner')
        browser.setValue('input#horizontal-spinner','-2')
        var cars = browser.getText('input#horizontal-spinner')
        assert(cars,'-2')

        browser.click('input#horizontal-spinner')
        browser.clearValue('input#horizontal-spinner')
        browser.setValue('input#horizontal-spinner','1')
        var car1 = browser.getText('input#horizontal-spinner')
        assert(car1,'1')
        
        browser.click('input#horizontal-spinner')
        browser.clearValue('input#horizontal-spinner')
        browser.setValue('input#horizontal-spinner','1000')
        var cars2 = browser.getText('input#horizontal-spinner')
        assert(cars2,'1000')

        browser.useXpath()
        browser.waitForElementPresent("//button[text()='Book Now!']")
        browser.click("//button[text()='Book Now!']")
        var booknow = browser.getCssProperty("//button[text()='Book Now!']", 'background')
        assert('rgb(0, 127, 255', booknow.value)


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

        browser.useCss()
        browser.click('input#vertical-spinner')
        browser.clearValue('input#vertical-spinner')
        browser.setValue('input#vertical-spinner','-2')
        var cars = browser.getText('input#vertical-spinner')
        assert(cars,'-2')

        browser.click('input#vertical-spinner')
        browser.clearValue('input#vertical-spinner')
        browser.setValue('input#vertical-spinner','1')
        var car1 = browser.getText('input#vertical-spinner')
        assert(car1,'1')
        
        browser.click('input#vertical-spinner')
        browser.clearValue('input#vertical-spinner')
        browser.setValue('input#vertical-spinner','1000')
        var cars2 = browser.getText('input#vertical-spinner')
        assert(cars2,'1000')

        browser.useXpath()
        browser.waitForElementPresent("//button[@id='book']")
        browser.click("//button[@id='book']")
        var booknow = browser.getCssProperty("//button[@id='book']", 'background')
        assert('rgb(0, 127, 255', booknow.value)
    })
});

