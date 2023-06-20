import { Controller, Post, Get, Body, NotImplementedException } from '@nestjs/common';
import { UserService } from './user.service';
import { UserEnrollmentRequestDTO } from './dtos/user-enrollment.request.dto';
import { User } from './entities/user.entity';

@Controller('user')
export class UserController {

  constructor(private readonly service: UserService) {}

  @Post()
  async create(@Body() data: Record<string, string>): Promise<void> {
    throw new NotImplementedException();
  }

  @Get()
  async getUserByEnrollment(@Body() dto: UserEnrollmentRequestDTO): Promise<User> {
    return this.service.getUserByEnrollment(dto);
  }
}
