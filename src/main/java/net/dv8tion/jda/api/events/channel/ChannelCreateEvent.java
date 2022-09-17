/*
 * Copyright 2015 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.api.events.channel;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;

import javax.annotation.Nonnull;

//TODO-v5: Docs
public class ChannelCreateEvent extends GenericChannelEvent
{

    protected final boolean newlyCreated;

    public ChannelCreateEvent(@Nonnull JDA api, long responseNumber, Channel channel, boolean newlyCreated)
    {
        super(api, responseNumber, channel);

        this.newlyCreated = newlyCreated;
    }

    /**
     * Whether the channel was newly created
     *
     * @throws IllegalStateException
     *         If the channel type is not from a thread
     *
     * @return true if the channel was created, false otherwise
     */
    public boolean isNewlyCreated()
    {
        if (!getChannelType().isThread())
            throw new IllegalStateException("The channel is not a thread channel");
        return newlyCreated;
    }
}
