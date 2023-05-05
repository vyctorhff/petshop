import { Controller, Post } from '@nestjs/common';
import { AuthorizationService } from './authorization.service';

@Controller('authorization')
export class AuthorizationController {

  constructor(private readonly authService: AuthorizationService) {}

  @Post()
  token() {
    // TODO: create dto for this request
    return this.authService.getToken();
  }
}
