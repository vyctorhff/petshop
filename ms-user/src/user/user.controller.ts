import { Controller, Post, Body, NotImplementedException } from '@nestjs/common';

@Controller('user')
export class UserController {

  @Post()
  async create(@Body() data: Record<string, string>): Promise<void> {
    throw new NotImplementedException();
  }
}
