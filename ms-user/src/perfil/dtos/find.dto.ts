export class FindDTO {
  constructor(public id: number, public name: string) {}

  hasId(): boolean {
    return Boolean(this.id);
  }

  hasName(): boolean {
    return Boolean(this.name);
  }
}
