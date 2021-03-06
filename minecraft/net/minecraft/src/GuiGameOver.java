// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, World, WorldInfo, GuiButton, 
//            StatCollector, ISaveFormat, ISaveHandler, GuiMainMenu, 
//            EntityPlayerSP

public class GuiGameOver extends GuiScreen
{

    public GuiGameOver()
    {
    }

    public void initGui()
    {
        controlList.clear();
        if(mc.theWorld.getWorldInfo().isHardcoreModeEnabled())
        {
            controlList.add(new GuiButton(1, width / 2 - 100, height / 4 + 96, StatCollector.translateToLocal("deathScreen.deleteWorld")));
        } else
        {
            controlList.add(new GuiButton(1, width / 2 - 100, height / 4 + 72, StatCollector.translateToLocal("deathScreen.respawn")));
            controlList.add(new GuiButton(2, width / 2 - 100, height / 4 + 96, StatCollector.translateToLocal("deathScreen.titleScreen")));
            if(mc.session == null)
            {
                ((GuiButton)controlList.get(1)).enabled = false;
            }
        }
    }

    protected void keyTyped(char c, int i)
    {
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id != 0);
        if(guibutton.id == 1)
        {
            if(mc.theWorld.getWorldInfo().isHardcoreModeEnabled())
            {
                World world = mc.theWorld;
                mc.exitToMainMenu("Deleting world");
                ISaveFormat isaveformat = mc.getSaveLoader();
                isaveformat.flushCache();
                isaveformat.deleteWorldDirectory(world.getSaveHandler().getSaveDirectoryName());
                mc.displayGuiScreen(new GuiMainMenu());
            } else
            {
                mc.thePlayer.respawnPlayer();
                mc.displayGuiScreen(null);
            }
        }
        if(guibutton.id == 2)
        {
            mc.changeWorld1(null);
            mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    public void drawScreen(int i, int j, float f)
    {
        drawGradientRect(0, 0, width, height, 0x60500000, 0xa0803030);
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        if(mc.theWorld.getWorldInfo().isHardcoreModeEnabled())
        {
            drawCenteredString(fontRenderer, StatCollector.translateToLocal("deathScreen.title.hardcore"), width / 2 / 2, 30, 0xffffff);
        } else
        {
            drawCenteredString(fontRenderer, StatCollector.translateToLocal("deathScreen.title"), width / 2 / 2, 30, 0xffffff);
        }
        GL11.glPopMatrix();
        if(mc.theWorld.getWorldInfo().isHardcoreModeEnabled())
        {
            drawCenteredString(fontRenderer, StatCollector.translateToLocal("deathScreen.hardcoreInfo"), width / 2, 144, 0xffffff);
        }
        drawCenteredString(fontRenderer, (new StringBuilder()).append(StatCollector.translateToLocal("deathScreen.score")).append(": \247e").append(mc.thePlayer.getScore()).toString(), width / 2, 100, 0xffffff);
        super.drawScreen(i, j, f);
    }

    public boolean doesGuiPauseGame()
    {
        return false;
    }
}
