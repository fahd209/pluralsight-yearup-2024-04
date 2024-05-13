package com.pluralsight;

public class TV
{
    // channels 2 - 13 (old TV)
    private int channel;
    // volume 0 - 10
    private int volume;
    private boolean isOn;

    public TV()
    {
        channel = 2;
        volume = 3;
        isOn = false;
    }

    public int getChannel()
    {
        return channel;
    }

    public int getVolume()
    {
        return volume;
    }

    public boolean isOn()
    {
        return isOn;
    }

    // Add code to the following methods

    // channel methods

    // set specific channel
    public void changeChannel(int channel)
    {
        if(channel >= 2 && channel <= 13)
        {
            this.channel = channel;
        }
    }

    // change channel up
    public void channelUp()
    {
        if(this.channel < 13)
        {
            this.channel += 1;
        }
        else
        {
            this.channel = 1;
        }
    }

    // change channel down
    public void channelDown()
    {
        if(this.channel > 2)
        {
            this.channel -= 1;
        }
        else{
            this.channel = 13;
        }
    }


    // volume control

    // set specific volume
    public void changeVolume(int volume)
    {
        if(volume >= 0 && volume <= 10)
        {
            this.volume = volume;
        }
    }


    // turn volume up
    public void volumeUp()
    {
        if(this.volume < 10)
        {
            this.volume += 1;
        }
    }

    // turn volume down
    public void volumeDown()
    {
        if(this.volume > 0)
        {
            this.volume -= 1;
        }
    }
}