local Gdx = luajava.bindClass("com.badlogic.gdx.Gdx")
local Input = luajava.bindClass("com.badlogic.gdx.Input")
local Funkin = luajava.bindClass("me.stringfromjava.funkin.Funkin")
local Paths = luajava.bindClass("me.stringfromjava.funkin.util.Paths")
local Sprite = luajava.bindClass("com.badlogic.gdx.graphics.g2d.Sprite")
local Texture = luajava.bindClass("com.badlogic.gdx.graphics.Texture")

local TitleScreen = Funkin.screen

local path = Paths:image('transitionSwag/stickers-set-1/bfSticker1')

local new_sprite = Sprite.new(Texture.new(path))
new_sprite:setPosition(100, 100)

TitleScreen:add(new_sprite)

local function onPostRender()
    if Gdx.input:isKeyPressed(Input.Keys.W) then
        new_sprite:setY(new_sprite:getY() + 10)
    end
    if Gdx.input:isKeyPressed(Input.Keys.A) then
        new_sprite:setX(new_sprite:getX() - 10)
    end
    if Gdx.input:isKeyPressed(Input.Keys.S) then
        new_sprite:setY(new_sprite:getY() - 10)
    end
    if Gdx.input:isKeyPressed(Input.Keys.D) then
        new_sprite:setX(new_sprite:getX() + 10)
    end
end

local runnable = luajava.createProxy('java.lang.Runnable', {
    run = onPostRender
})

Funkin.Signals.postRender:add(runnable)

Funkin:playSound('shared/sounds/ANGRY_TEXT_BOX.ogg')
