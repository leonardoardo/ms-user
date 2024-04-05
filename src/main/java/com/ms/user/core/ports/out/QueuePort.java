package com.ms.user.core.ports.out;

import com.ms.user.core.domain.UserDomain;

public interface QueuePort {
   public void publicMessage(UserDomain user);
}
